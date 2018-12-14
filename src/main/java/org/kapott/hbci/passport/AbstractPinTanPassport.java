
/*
 * $Id: AbstractPinTanPassport.java,v 1.6 2011/06/06 10:30:31 willuhn Exp $
 * This file is part of HBCI4Java
 * Copyright (C) 2001-2008 Stefan Palme
 * HBCI4Java is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 * HBCI4Java is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
 */

package org.kapott.hbci.passport;

import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import org.kapott.hbci.GV.GVTAN2Step;
import org.kapott.hbci.GV.HBCIJobImpl;
import org.kapott.hbci.callback.HBCICallback;
import org.kapott.hbci.comm.Comm;
import org.kapott.hbci.exceptions.HBCI_Exception;
import org.kapott.hbci.exceptions.InvalidUserDataException;
import org.kapott.hbci.manager.ChallengeInfo;
import org.kapott.hbci.manager.HBCIDialog;
import org.kapott.hbci.manager.HBCIHandler;
import org.kapott.hbci.manager.HBCIKey;
import org.kapott.hbci.manager.HBCIUtils;
import org.kapott.hbci.manager.HBCIUtilsInternal;
import org.kapott.hbci.protocol.SEG;
import org.kapott.hbci.protocol.factory.SEGFactory;
import org.kapott.hbci.security.Crypt;
import org.kapott.hbci.security.Sig;
import org.kapott.hbci.status.HBCIMsgStatus;
import org.kapott.hbci.status.HBCIRetVal;
import org.kapott.hbci.structures.Konto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractPinTanPassport
		extends AbstractHBCIPassport
{
	/**
	 * The {@link Logger} to be used.
	 */
	private static final Logger logger = LoggerFactory.getLogger( AbstractPinTanPassport.class );

	private String certfile;
	private boolean checkCert = true;

	private String proxy;
	private String proxyuser;
	private String proxypass;

	private boolean verifyTANMode;

	private Hashtable<String, Properties> twostepMechanisms = new Hashtable<String, Properties>();
	private List<String> allowedTwostepMechanisms = new ArrayList<String>();

	private String currentTANMethod;
	private boolean currentTANMethodWasAutoSelected;

	private String pin;

	public AbstractPinTanPassport( HBCICallback callback, Object initObject )
	{
		super( callback, initObject );
		
		// TCP-Port des Servers. Bei PIN/TAN immer 443, da das ja ueber HTTPS laeuft.
		setPort( 443 );
		
		// Art der Nachrichten-Codierung. Bei Chipkarte/Schluesseldatei wird
		// "None" verwendet. Bei PIN/TAN kommt "Base64" zum Einsatz.
		setFilterType( "Base64" );
	}

	public String getPassportTypeName()
	{
		return "PinTan";
	}

	public void setBPD( Properties p )
	{
		super.setBPD( p );

		if ( p != null && p.size() != 0 )
		{
			// hier die liste der verfügbaren sicherheitsverfahren aus den
			// bpd (HITANS) extrahieren

			twostepMechanisms.clear();

			// willuhn 2011-06-06 Maximal zulaessige HITANS-Segment-Version ermitteln
			// Hintergrund: Es gibt User, die nur HHD 1.3-taugliche TAN-Generatoren haben,
			// deren Banken aber auch HHD 1.4 beherrschen. In dem Fall wuerde die Bank
			// HITANS/HKTAN/HITAN in Segment-Version 5 machen, was in der Regel dazu fuehren
			// wird, dass HHD 1.4 zur Anwendung kommt. Das bewirkt, dass ein Flicker-Code
			// erzeugt wird, der vom TAN-Generator des Users gar nicht lesbar ist, da dieser
			// kein HHD 1.4 beherrscht. Mit dem folgenden Parameter kann die Maximal-Version
			// des HITANS-Segments nach oben begrenzt werden, so dass z.Bsp. HITANS5 ausgefiltert
			// wird.
			int maxAllowedVersion = Integer.parseInt( HBCIUtils.getParam( "kernel.gv.HITANS.segversion.max", "0" ) );

			for ( Enumeration e = p.propertyNames(); e.hasMoreElements(); )
			{
				String key = (String) e.nextElement();

				// p.getProperty("Params_x.TAN2StepParY.ParTAN2StepZ.TAN2StepParamsX_z.*")
				if ( key.startsWith( "Params" ) )
				{
					String subkey = key.substring( key.indexOf( '.' ) + 1 );
					if ( subkey.startsWith( "TAN2StepPar" ) )
					{

						// willuhn 2011-05-13 Wir brauchen die Segment-Version, weil mittlerweile TAN-Verfahren
						// mit identischer Sicherheitsfunktion in unterschiedlichen Segment-Versionen auftreten koennen
						// Wenn welche mehrfach vorhanden sind, nehmen wir nur das aus der neueren Version
						int segVersion = Integer.parseInt( subkey.substring( 11, 12 ) );

						subkey = subkey.substring( subkey.indexOf( '.' ) + 1 );
						if ( subkey.startsWith( "ParTAN2Step" ) &&
								subkey.endsWith( ".secfunc" ) )
						{
							// willuhn 2011-06-06 Segment-Versionen ueberspringen, die groesser als die max. zulaessige sind
							if ( maxAllowedVersion > 0 && segVersion > maxAllowedVersion )
							{
								logger.info( "skipping segversion " + segVersion + ", larger than allowed version " + maxAllowedVersion );
								continue;
							}

							String secfunc = p.getProperty( key );

							// willuhn 2011-05-13 Checken, ob wir das Verfahren schon aus einer aktuelleren Segment-Version haben
							Properties prev = twostepMechanisms.get( secfunc );
							if ( prev != null )
							{
								// Wir haben es schonmal. Mal sehen, welche Versionsnummer es hat
								int prevVersion = Integer.parseInt( prev.getProperty( "segversion" ) );
								if ( prevVersion > segVersion )
								{
									logger.debug( "found another twostepmech " + secfunc + " in segversion " + segVersion + ", allready have one in segversion " + prevVersion
											+ ", ignoring segversion " + segVersion );
									continue;
								}
							}

							Properties entry = new Properties();

							// willuhn 2011-05-13 Wir merken uns die Segment-Version in dem Zweischritt-Verfahren
							// Daran koennen wir erkennen, ob wir ein mehrfach auftretendes
							// Verfahren ueberschreiben koennen oder nicht.
							entry.put( "segversion", Integer.toString( segVersion ) );

							String paramHeader = key.substring( 0, key.lastIndexOf( '.' ) );
							// Params_x.TAN2StepParY.ParTAN2StepZ.TAN2StepParamsX_z

							// alle properties durchlaufen und alle suchen, die mit dem
							// paramheader beginnen, und die entsprechenden werte im
							// entry abspeichern
							for ( Enumeration e2 = p.propertyNames(); e2.hasMoreElements(); )
							{
								String key2 = (String) e2.nextElement();

								if ( key2.startsWith( paramHeader + "." ) )
								{
									int dotPos = key2.lastIndexOf( '.' );

									entry.setProperty(
											key2.substring( dotPos + 1 ),
											p.getProperty( key2 ) );
								}
							}

							// diesen mechanismus abspeichern
							twostepMechanisms.put( secfunc, entry );
						}
					}
				}
			}
		}
	}

	private void searchFor3920s( HBCIRetVal[] rets )
	{
		int l = rets.length;
		for ( int i = 0; i < l; i++ )
		{
			HBCIRetVal ret = rets[i];
			if ( ret.code.equals( "3920" ) )
			{
				this.allowedTwostepMechanisms.clear();

				int l2 = ret.params.length;
				for ( int j = 0; j < l2; j++ )
				{
					this.allowedTwostepMechanisms.add( ret.params[j] );
				}

				logger.debug( "autosecfunc: found 3920 in response - updated list of allowed twostepmechs with " + allowedTwostepMechanisms.size() + " entries" );
			}
		}
	}

	private boolean searchFor3072s( HBCIRetVal[] rets )
	{
		int l = rets.length;
		for ( int i = 0; i < l; i++ )
		{
			HBCIRetVal ret = rets[i];
			if ( ret.code.equals( "3072" ) )
			{
				String newCustomerId = "";
				String newUserId = "";
				int l2 = ret.params.length;
				if ( l2 > 0 )
				{
					newUserId = ret.params[0];
					newCustomerId = ret.params[0];
				}
				if ( l2 > 1 )
				{
					newCustomerId = ret.params[1];
				}
				if ( l2 > 0 )
				{
					logger.debug( "autosecfunc: found 3072 in response - change user id" );
					// Aufrufer informieren, dass UserID und CustomerID geändert wurde
					StringBuffer retData = new StringBuffer();
					retData.append( newUserId + "|" + newCustomerId );
					getCallback().callback( this, HBCICallback.USERID_CHANGED, "*** User ID changed", HBCICallback.TYPE_TEXT, retData );
					return true;
				}
			}
		}
		return false;
	}

	public boolean postInitResponseHook( HBCIMsgStatus msgStatus, boolean anonDialog )
	{
		boolean restart_needed = super.postInitResponseHook( msgStatus, anonDialog );

		if ( !msgStatus.isOK() )
		{
			logger.debug( "dialog init ended with errors - searching for return code 'wrong PIN'" );

			if ( msgStatus.isInvalidPIN() )
			{
				logger.info( "detected 'invalid PIN' error - clearing passport PIN" );
				clearPIN();

				// Aufrufer informieren, dass falsche PIN eingegeben wurde (um evtl. PIN aus Puffer zu löschen, etc.)
				StringBuffer retData = new StringBuffer();
				getCallback().callback( this, HBCICallback.WRONG_PIN, "*** invalid PIN entered", HBCICallback.TYPE_TEXT, retData );
			}
		}

		logger.debug( "autosecfunc: search for 3920s in response to detect allowed twostep secmechs" );

		searchFor3920s( msgStatus.globStatus.getWarnings() );
		searchFor3920s( msgStatus.segStatus.getWarnings() );

		searchFor3072s( msgStatus.segStatus.getWarnings() );

		if ( !anonDialog )
		{
			setPersistentData( "_authed_dialog_executed", Boolean.TRUE );

			// aktuelle secmech merken und neue auswählen (basierend auf evtl. gerade
			// neu empfangenen informationen (3920s))
			String oldTANMethod = currentTANMethod;
			String updatedTANMethod = getCurrentTANMethod( true );

			if ( !oldTANMethod.equals( updatedTANMethod ) )
			{
				// wenn sich das ausgewählte secmech geändert hat, müssen wir
				// einen dialog-restart fordern, weil während eines dialoges
				// das secmech nicht gewechselt werden darf
				restart_needed = true;
				logger.info( "autosecfunc: after this dialog-init we had to change selected pintan method from " + oldTANMethod + " to " + updatedTANMethod
						+ ", so a restart of this dialog is needed" );
			}
		}

		return restart_needed;
	}

	public Comm getCommInstance()
	{
		return Comm.getInstance( "PinTan", this );
	}

	public boolean isSupported()
	{
		boolean ret = false;
		Properties bpd = getBPD();

		if ( bpd != null && bpd.size() != 0 )
		{
			// loop through bpd and search for PinTanPar segment
			for ( Enumeration e = bpd.propertyNames(); e.hasMoreElements(); )
			{
				String key = (String) e.nextElement();

				if ( key.startsWith( "Params" ) )
				{
					int posi = key.indexOf( "." );
					if ( key.substring( posi + 1 ).startsWith( "PinTanPar" ) )
					{
						ret = true;
						break;
					}
				}
			}

			if ( ret )
			{
				// prüfen, ob gewähltes sicherheitsverfahren unterstützt wird
				// autosecmech: hier wird ein flag uebergeben, das anzeigt, dass getCurrentTANMethod()
				// hier evtl. automatisch ermittelte secmechs neu verifzieren soll
				String current = getCurrentTANMethod( true );

				if ( current.equals( Sig.SECFUNC_SIG_PT_1STEP ) )
				{
					// einschrittverfahren gewählt
					if ( !isOneStepAllowed() )
					{
						logger.error( "not supported: onestep method not allowed by BPD" );
						ret = false;
					}
					else
					{
						logger.debug( "supported: pintan-onestep" );
					}
				}
				else
				{
					// irgendein zweischritt-verfahren gewählt
					Properties entry = twostepMechanisms.get( current );
					if ( entry == null )
					{
						// es gibt keinen info-eintrag für das gewählte verfahren
						logger.error( "not supported: twostep-method " + current + " selected, but this is not supported" );
						ret = false;
					}
					else
					{
						logger.debug( "selected twostep-method " + current + " (" + entry.getProperty( "name" ) + ") is supported" );
					}
				}
			}
		}
		else
		{
			ret = true;
		}

		return ret;
	}

	private boolean isOneStepAllowed()
	{
		// default ist true, weil entweder *nur* das einschritt-verfahren unter-
		// stützt wird oder keine BPD vorhanden sind, um das zu entscheiden
		boolean ret = true;

		Properties bpd = getBPD();
		if ( bpd != null )
		{
			for ( Enumeration e = bpd.propertyNames(); e.hasMoreElements(); )
			{
				String key = (String) e.nextElement();

				// TODO: willuhn 2011-05-13: Das nimmt einfach den ersten gefundenen Parameter, liefert
				// jedoch faelschlicherweise false, wenn das erste gefundene kein Einschritt-Verfahren ist
				// Hier muesste man durch alle iterieren und dann true liefern, wenn wenigstens
				// eines den Wert "J" hat.

				// p.getProperty("Params_x.TAN2StepParY.ParTAN2StepZ.can1step")
				if ( key.startsWith( "Params" ) )
				{
					String subkey = key.substring( key.indexOf( '.' ) + 1 );
					if ( subkey.startsWith( "TAN2StepPar" ) &&
							subkey.endsWith( ".can1step" ) )
					{
						String value = bpd.getProperty( key );
						ret = value.equals( "J" );
						break;
					}
				}
			}
		}

		return ret;
	}

	/**
	 * Kann vor <code>new HBCIHandler()</code> aufgerufen werden, um zu
	 * erzwingen, dass die Liste der unterstützten PIN/TAN-Sicherheitsverfahren
	 * neu vom Server abgeholt wird und evtl. neu vom Nutzer abgefragt wird.
	 */
	public void resetSecMechs()
	{
		this.allowedTwostepMechanisms = new ArrayList<String>();
		this.currentTANMethod = null;
		this.currentTANMethodWasAutoSelected = false;
	}

	public void setCurrentTANMethod( String method )
	{
		this.currentTANMethod = method;
	}

	public String getCurrentTANMethod( boolean recheckSupportedSecMechs )
	{
		// autosecmech: hier auch dann checken, wenn recheckSupportedSecMechs==true
		// UND die vorherige auswahl AUTOMATISCH getroffen wurde (manuelle auswahl
		// also in jedem fall weiter verwenden) (das AUTOMATISCH erkennt man daran,
		// dass recheckCurrentTANMethodNeeded==true ist)
		if ( currentTANMethod == null || recheckSupportedSecMechs )
		{
			logger.debug( "autosecfunc: (re)checking selected pintan secmech" );

			// es ist noch kein zweischrittverfahren ausgewaehlt, oder die
			// aktuelle auswahl soll gegen die liste der tatsaechlich unterstuetzten
			// verfahren validiert werden

			List<String[]> options = new ArrayList<String[]>();

			if ( isOneStepAllowed() )
			{
				// wenn einschrittverfahren unterstützt, dass zur liste hinzufügen
				if ( allowedTwostepMechanisms.size() == 0 || allowedTwostepMechanisms.contains( Sig.SECFUNC_SIG_PT_1STEP ) )
				{
					options.add( new String[] { Sig.SECFUNC_SIG_PT_1STEP, "Einschritt-Verfahren" } );
				}
			}

			// alle zweischritt-verfahren zur auswahlliste hinzufügen
			String[] secfuncs = twostepMechanisms.keySet().toArray( new String[twostepMechanisms.size()] );
			Arrays.sort( secfuncs );
			int len = secfuncs.length;
			for ( int i = 0; i < len; i++ )
			{
				String secfunc = secfuncs[i];
				if ( allowedTwostepMechanisms.size() == 0 || allowedTwostepMechanisms.contains( secfunc ) )
				{
					Properties entry = twostepMechanisms.get( secfunc );
					options.add( new String[] { secfunc, entry.getProperty( "name" ) } );
				}
			}

			if ( options.size() == 1 )
			{
				// wenn nur ein verfahren unterstützt wird, das automatisch auswählen
				String autoSelection = (options.get( 0 ))[0];

				logger.debug( "autosecfunc: there is only one pintan method (" + autoSelection + ") supported - choosing this automatically" );
				if ( currentTANMethod != null && !autoSelection.equals( currentTANMethod ) )
				{
					logger.debug( "autosecfunc: currently selected method (" + currentTANMethod + ") differs from auto-selected method (" + autoSelection + ")" );
				}

				setCurrentTANMethod( autoSelection );

				// autosecmech: hier merken, dass dieses verfahren AUTOMATISCH
				// ausgewaehlt wurde, so dass wir spaeter immer mal wieder pruefen
				// muessen, ob inzwischen nicht mehr/andere unterstuetzte secmechs bekannt sind
				// (passiert z.b. wenn das anonyme abholen der bpd fehlschlaegt)
				this.currentTANMethodWasAutoSelected = true;

			}
			else if ( options.size() > 1 )
			{
				// es werden mehrere verfahren unterstützt

				if ( currentTANMethod != null )
				{
					// es ist schon ein verfahren ausgewaehlt. falls dieses verfahren
					// nicht in der liste der unterstuetzten verfahren enthalten ist,
					// setzen wir das auf "null" zurueck, damit das zu verwendende
					// verfahren neu ermittelt wird

					boolean ok = false;
					for ( Iterator<String[]> i = options.iterator(); i.hasNext(); )
					{
						if ( currentTANMethod.equals( (i.next())[0] ) )
						{
							ok = true;
							break;
						}
					}

					if ( !ok )
					{
						logger.debug( "autosecfunc: currently selected pintan method (" + currentTANMethod + ") not in list of supported methods - resetting current selection" );
						currentTANMethod = null;
					}
				}

				if ( currentTANMethod == null || this.currentTANMethodWasAutoSelected )
				{
					// wenn noch kein verfahren ausgewaehlt ist, oder das bisherige
					// verfahren automatisch ausgewaehlt wurde, muessen wir uns
					// neu fuer eine method aus der liste entscheiden

					// TODO: damit das sinnvoll funktioniert, sollte die liste der
					// allowedTwostepMechs mit im passport gespeichert werden.
					if ( allowedTwostepMechanisms.size() == 0 &&
							getPersistentData( "_authed_dialog_executed" ) == null )
					{
						// wir wählen einen secmech automatisch aus, wenn wir
						// die liste der erlaubten secmechs nicht haben
						// (entweder weil wir sie noch nie abgefragt haben oder weil
						// diese daten einfach nicht geliefert werden). im fall
						// "schon abgefragt, aber nicht geliefert" dürfen wir aber
						// wiederum NICHT automatisch auswählen, so dass wir zusätzlich
						// fragen, ob schon mal ein dialog gelaufen ist, bei dem
						// diese daten hätten geliefert werden KÖNNEN (_authed_dialog_executed).
						// nur wenn wir die liste der gültigen secmechs noch gar
						// nicht haben KÖNNEN, wählen wir einen automatisch aus.

						String autoSelection = (options.get( 0 ))[0];
						logger.debug( "autosecfunc: there are " + options.size()
								+ " pintan methods supported, but we don't know which of them are allowed for the current user, so we automatically choose " + autoSelection );
						setCurrentTANMethod( autoSelection );

						// autosecmech: hier merken, dass dieses verfahren AUTOMATISCH
						// ausgewaehlt wurde, so dass wir spaeter immer mal wieder pruefen
						// muessen, ob inzwischen nicht mehr/andere unterstuetzte secmechs bekannt sind
						// (passiert z.b. wenn das anonyme abholen der bpd fehlschlaegt)
						this.currentTANMethodWasAutoSelected = true;

					}
					else
					{
						// wir wissen schon, welche secmechs erlaubt sind (entweder
						// durch einen vorhergehenden dialog oder aus den persistenten
						// passport-daten), oder wir wissen es nicht (size==0), haben aber schonmal
						// danach gefragt (ein authed_dialog ist schon gelaufen, bei dem
						// diese daten aber nicht geliefert wurden).
						// in jedem fall steht in "options" die liste der prinzipiell
						// verfügbaren secmechs drin, u.U. gekürzt auf die tatsächlich
						// erlaubten secmechs.
						// wir fragen also via callback nach, welcher dieser secmechs
						// denn nun verwendet werden soll

						logger.debug( "autosecfunc: we have to callback to ask for pintan method to be used" );

						// auswahlliste als string zusammensetzen
						StringBuffer retData = new StringBuffer();
						for ( Iterator<String[]> i = options.iterator(); i.hasNext(); )
						{
							if ( retData.length() != 0 )
							{
								retData.append( "|" );
							}
							String[] entry = i.next();
							retData.append( entry[0] ).append( ":" ).append( entry[1] );
						}

						// callback erzeugen
						getCallback().callback( this,
								HBCICallback.NEED_PT_SECMECH,
								"*** Select a pintan method from the list",
								HBCICallback.TYPE_TEXT,
								retData );

						// überprüfen, ob das gewählte verfahren einem aus der liste entspricht
						String selected = retData.toString();
						boolean ok = false;
						for ( Iterator<String[]> i = options.iterator(); i.hasNext(); )
						{
							if ( selected.equals( (i.next())[0] ) )
							{
								ok = true;
								break;
							}
						}

						if ( !ok )
						{
							throw new InvalidUserDataException( "*** selected pintan method not supported!" );
						}

						setCurrentTANMethod( selected );
						this.currentTANMethodWasAutoSelected = false;

						logger.debug( "autosecfunc: manually selected pintan method " + currentTANMethod );
					}
				}

			}
			else
			{
				// es wird scheinbar GAR KEIN verfahren unterstuetzt. also nehmen
				// wir automatisch 999
				logger.debug( "autosecfunc: absolutely no information about allowed pintan methods available - automatically falling back to 999" );
				setCurrentTANMethod( "999" );
				this.currentTANMethodWasAutoSelected = true;
			}
		}

		return currentTANMethod;
	}

	public Properties getCurrentSecMechInfo()
	{
		return twostepMechanisms.get( getCurrentTANMethod( false ) );
	}

	public Hashtable<String, Properties> getTwostepMechanisms()
	{
		return twostepMechanisms;
	}

	public String getProfileMethod()
	{
		return "PIN";
	}

	public String getProfileVersion()
	{
		return getCurrentTANMethod( false ).equals( Sig.SECFUNC_SIG_PT_1STEP ) ? "1" : "2";
	}

	public boolean needUserKeys()
	{
		return false;
	}

	public boolean needInstKeys()
	{
		// TODO: das abhängig vom thema "bankensignatur für HKTAN" machen
		return false;
	}

	public boolean needUserSig()
	{
		return true;
	}

	public String getSysStatus()
	{
		return "1";
	}

	public boolean hasInstSigKey()
	{
		// TODO: hier müsste es eigentlich zwei antworten geben: eine für
		// das PIN/TAN-verfahren an sich (immer true) und eine für
		// evtl. bankensignatur-schlüssel für HITAN
		return true;
	}

	public boolean hasInstEncKey()
	{
		return true;
	}

	public boolean hasMySigKey()
	{
		return true;
	}

	public boolean hasMyEncKey()
	{
		return true;
	}

	public HBCIKey getInstSigKey()
	{
		// TODO: hier müsste es eigentlich zwei antworten geben: eine für
		// das PIN/TAN-verfahren an sich (immer null) und eine für
		// evtl. bankensignatur-schlüssel für HITAN
		return null;
	}

	public HBCIKey getInstEncKey()
	{
		return null;
	}

	public String getInstSigKeyName()
	{
		// TODO: evtl. zwei antworten: pin/tan und bankensignatur für HITAN
		return getUserId();
	}

	public String getInstSigKeyNum()
	{
		// TODO: evtl. zwei antworten: pin/tan und bankensignatur für HITAN
		return "0";
	}

	public String getInstSigKeyVersion()
	{
		// TODO: evtl. zwei antworten: pin/tan und bankensignatur für HITAN
		return "0";
	}

	public String getInstEncKeyName()
	{
		return getUserId();
	}

	public String getInstEncKeyNum()
	{
		return "0";
	}

	public String getInstEncKeyVersion()
	{
		return "0";
	}

	public String getMySigKeyName()
	{
		return getUserId();
	}

	public String getMySigKeyNum()
	{
		return "0";
	}

	public String getMySigKeyVersion()
	{
		return "0";
	}

	public String getMyEncKeyName()
	{
		return getUserId();
	}

	public String getMyEncKeyNum()
	{
		return "0";
	}

	public String getMyEncKeyVersion()
	{
		return "0";
	}

	public HBCIKey getMyPublicDigKey()
	{
		return null;
	}

	public HBCIKey getMyPrivateDigKey()
	{
		return null;
	}

	public HBCIKey getMyPublicSigKey()
	{
		return null;
	}

	public HBCIKey getMyPrivateSigKey()
	{
		return null;
	}

	public HBCIKey getMyPublicEncKey()
	{
		return null;
	}

	public HBCIKey getMyPrivateEncKey()
	{
		return null;
	}

	public String getCryptMode()
	{
		// dummy-wert
		return Crypt.ENCMODE_CBC;
	}

	public String getCryptAlg()
	{
		// dummy-wert
		return Crypt.ENCALG_2K3DES;
	}

	public String getCryptKeyType()
	{
		// dummy-wert
		return Crypt.ENC_KEYTYPE_DDV;
	}

	public String getSigFunction()
	{
		return getCurrentTANMethod( false );
	}

	public String getCryptFunction()
	{
		return Crypt.SECFUNC_ENC_PLAIN;
	}

	public String getSigAlg()
	{
		// dummy-wert
		return Sig.SIGALG_RSA;
	}

	public String getSigMode()
	{
		// dummy-wert
		return Sig.SIGMODE_ISO9796_1;
	}

	public String getHashAlg()
	{
		// dummy-wert
		return Sig.HASHALG_RIPEMD160;
	}

	public void setInstSigKey( HBCIKey key )
	{
	}

	public void setInstEncKey( HBCIKey key )
	{
		// TODO: implementieren für bankensignatur bei HITAN
	}

	public void setMyPublicDigKey( HBCIKey key )
	{
	}

	public void setMyPrivateDigKey( HBCIKey key )
	{
	}

	public void setMyPublicSigKey( HBCIKey key )
	{
	}

	public void setMyPrivateSigKey( HBCIKey key )
	{
	}

	public void setMyPublicEncKey( HBCIKey key )
	{
	}

	public void setMyPrivateEncKey( HBCIKey key )
	{
	}

	public void incSigId()
	{
		// for PinTan we always use the same sigid
	}

	protected String collectSegCodes( String msg )
	{
		StringBuffer ret = new StringBuffer();
		int len = msg.length();
		int posi = 0;

		while ( true )
		{
			int endPosi = msg.indexOf( ':', posi );
			if ( endPosi == -1 )
			{
				break;
			}

			String segcode = msg.substring( posi, endPosi );
			if ( ret.length() != 0 )
			{
				ret.append( "|" );
			}
			ret.append( segcode );

			while ( posi < len && msg.charAt( posi ) != '\'' )
			{
				posi = HBCIUtilsInternal.getPosiOfNextDelimiter( msg, posi + 1 );
			}
			if ( posi >= len )
			{
				break;
			}
			posi++;
		}

		return ret.toString();
	}

	public String getPinTanInfo( String code )
	{
		String ret = "";
		Properties bpd = getBPD();

		if ( bpd != null )
		{
			boolean isGV = false;
			StringBuffer paramCode = new StringBuffer( code ).replace( 1, 2, "I" ).append( "S" );

			for ( Enumeration e = bpd.propertyNames(); e.hasMoreElements(); )
			{
				String key = (String) e.nextElement();

				if ( key.startsWith( "Params" ) &&
						key.substring( key.indexOf( "." ) + 1 ).startsWith( "PinTanPar" ) &&
						key.indexOf( ".ParPinTan.PinTanGV" ) != -1 &&
						key.endsWith( ".segcode" ) )
				{
					String code2 = bpd.getProperty( key );
					if ( code.equals( code2 ) )
					{
						key = key.substring( 0, key.length() - ("segcode").length() ) + "needtan";
						ret = bpd.getProperty( key );
						break;
					}
				}
				else if ( key.startsWith( "Params" ) &&
						key.endsWith( ".SegHead.code" ) )
				{

					String code2 = bpd.getProperty( key );
					if ( paramCode.equals( code2 ) )
					{
						isGV = true;
					}
				}
			}

			// wenn das kein GV ist, dann ist es ein Admin-Segment
			if ( ret.length() == 0 && !isGV )
			{
				if ( verifyTANMode && code.equals( "HKIDN" ) )
				{
					// im TAN-verify-mode wird bei der dialog-initialisierung
					// eine TAN mit versandt; die Dialog-Initialisierung erkennt
					// man am HKIDN-segment
					ret = "J";
					deactivateTANVerifyMode();
				}
				else
				{
					ret = "A";
				}
			}
		}

		return ret;
	}

	public void deactivateTANVerifyMode()
	{
		this.verifyTANMode = false;
	}

	public void activateTANVerifyMode()
	{
		this.verifyTANMode = true;
	}

	/**
	 * <code>client.passport.PinTan.certfile</code> (für PIN/TAN-Passports)
	 * <p>
	 * Dieser Parameter gibt den Dateinamen einer Datei an, die ein Zertifikat für
	 * die Kommunikation via HTTPS (SSL-Verschlüsselung) enthält. Diese Datei kann
	 * mit dem Tool <code>keytool</code> erzeugt werden, welches zur
	 * Java-Laufzeitumgebung gehört. Das Zertifikat (ein bestätigter öffentlicher
	 * Schlüssel) kann i.d.R. von der Bank angefordert werden.
	 * <p>
	 * Dieser Parameter wird nur dann benötigt, wenn das SSL-Zertifikat der Bank
	 * nicht mit dem defaultmäßig in die JRE eingebauten TrustStore überprüft werden
	 * kann (also am besten erst ohne diesen Parameter ausprobieren - wenn eine
	 * entsprechende Fehlermeldung erscheint, muss das jeweilige Zertifikat von der
	 * Bank angefordert, mit <code>keytool</code> konvertiert und hier angegeben
	 * werden). Wenn ein entsprechendes Root-Zertifikat für die Überprüfung gar
	 * nicht zur Verfügung steht, so kann mit dem Parameter
	 * <code>client.passport.PinTan.checkcert</code> die Zertifikatsüberprüfung
	 * gänzlich deaktiviert werden.
	 * 
	 * @param filename
	 */
	public void setCertFile( String filename )
	{
		this.certfile = filename;
	}

	public String getCertFile()
	{
		return certfile;
	}

	/**
	 * <code>client.passport.PinTan.checkcert</code> (für PIN/TAN-Passports)
	 * <p>
	 * Dieser Parameter steht defaultmäßig auf "<code>true</code>". Wird dieser
	 * Parameter allerdings auf "<code>false</code>" gesetzt, so wird die Überprüfung
	 * des Bank-Zertifikates, welches für die SSL-Kommunikation verwendet wird,
	 * deaktiviert. Diese Vorgehensweise wird nicht empfohlen, da dann Angriffe auf
	 * das SSL-Protokoll und damit auch auf die HBCI-Kommunikation möglich sind. In
	 * einigen Fällen steht aber kein Root-Zertifikat für die Überprüfung des
	 * SSL-Zertifikats der Bank zur Verfügung, so dass diese Überprüfung
	 * abgeschaltet werden <em>muss</em>, um überhaupt eine Kommunikation mit der
	 * Bank zu ermöglichen.
	 * 
	 * 
	 * @param skip
	 */
	protected void setCheckCert( boolean skip )
	{
		this.checkCert = skip;
	}

	public boolean getCheckCert()
	{
		return checkCert;
	}

	public String getProxy()
	{
		return proxy;
	}

	/**
	 * <code>client.passport.PinTan.proxy</code> (für PIN/TAN-Passports)
	 * <p>
	 * Falls ausgehende HTTPS-Verbindungen über einen Proxy-Server laufen sollen,
	 * kann der zu verwendende Proxy-Server mit diesem Parameter konfiguriert
	 * werden. Das Format für den Wert dieses Kernel-Parameters ist "HOST:PORT",
	 * also z.B. <code>proxy.intern.domain.com:3128</code>.
	 * 
	 */
	public void setProxy( String proxy )
	{
		this.proxy = proxy;
	}

	public String getProxyPass()
	{
		return proxypass;
	}

	public String getProxyUser()
	{
		return proxyuser;
	}

	/**
	 * <code>client.passport.PinTan.proxypass</code> (für PIN/TAN-Passports)
	 * <p>
	 * Falls für ausgehende HTTPS-Verbindungen (für HBCI-PIN/TAN) ein Proxy-Server
	 * verwendet wird, und falls dieser Proxy-Server eine Authentifizierung
	 * verlangt, kann mit diesem Parameter das Passwort festgelegt werden.
	 * <p>
	 * Wenn dieser Parameter nicht gesetzt wird, wird bei Bedarf über einen Callback
	 * (<code>NEED_PROXY_PASS</code>) nach dem Passwort gefragt.
	 * 
	 * @param proxypass
	 */
	public void setProxyPass( String proxypass )
	{
		this.proxypass = proxypass;
	}

	/**
	 * <code>client.passport.PinTan.proxyuser</code> (für PIN/TAN-Passports)
	 * <p>
	 * Falls für ausgehende HTTPS-Verbindungen (für HBCI-PIN/TAN) ein Proxy-Server
	 * verwendet wird, und falls dieser Proxy-Server eine Authentifizierung
	 * verlangt, kann mit diesem Parameter der Nutzername festgelegt werden.
	 * <p>
	 * Wenn dieser Parameter nicht gesetzt wird, wird bei Bedarf über einen Callback
	 * (<code>NEED_PROXY_USER</code>) nach dem Nutzernamen gefragt.
	 * 
	 * @param proxyuser
	 */
	public void setProxyUser( String proxyuser )
	{
		this.proxyuser = proxyuser;
	}

	private String getOrderHashMode()
	{
		String ret = null;

		Properties bpd = getBPD();
		if ( bpd != null )
		{
			for ( Enumeration<?> e = bpd.propertyNames(); e.hasMoreElements(); )
			{
				String key = (String) e.nextElement();

				Properties props = getCurrentSecMechInfo();
				String segVersion = "";
				try
				{
					int value = Integer.parseInt( props.getProperty( "segversion" ) );
					segVersion += value;
				}
				catch ( NumberFormatException nfe )
				{
					// Not an integer, hence ignored
				}

				// p.getProperty("Params_x.TAN2StepParY.ParTAN2StepZ.can1step")
				if ( key.startsWith( "Params" ) )
				{
					String subkey = key.substring( key.indexOf( '.' ) + 1 );
					if ( subkey.startsWith( "TAN2StepPar" + segVersion ) &&
							subkey.endsWith( ".orderhashmode" ) )
					{
						ret = bpd.getProperty( key );
						break;
					}
				}
			}
		}

		return ret;
	}

	// das wird vor dialog.executeJobs() abstrakt aufgerufen
	// (via beforeCustomDialogHook(dialog))
	private void patchMessagesFor2StepMethods( HBCIDialog dialog )
	{
		if ( !getCurrentTANMethod( false ).equals( Sig.SECFUNC_SIG_PT_1STEP ) )
		{
			// wenn es sich um das pintan-verfahren im zweischritt-modus handelt,
			// müssen evtl. zusätzliche nachrichten bzw. segmente eingeführt werden

			logger.debug( "afterCustomDialogInitHook: patching message queues for twostep method" );

			HBCIHandler handler = (HBCIHandler) getParentHandlerData();
			Properties secmechInfo = getCurrentSecMechInfo();
			String segversion = secmechInfo.getProperty( "segversion" );
			String process = secmechInfo.getProperty( "process" );

			List<ArrayList<HBCIJobImpl>> msgs = dialog.getMessages();
			List<ArrayList<HBCIJobImpl>> new_msgs = new ArrayList<>();

			// durch alle ursprünglichen nachrichten laufen
			for ( Iterator<ArrayList<HBCIJobImpl>> i = msgs.iterator(); i.hasNext(); )
			{
				ArrayList<HBCIJobImpl> msg_tasks = i.next();
				ArrayList<HBCIJobImpl> new_msg_tasks = new ArrayList<>();

				ArrayList<HBCIJobImpl> additional_msg_tasks = null;

				// jeden task einer nachricht ansehen
				for ( Iterator<HBCIJobImpl> j = msg_tasks.iterator(); j.hasNext(); )
				{
					HBCIJobImpl task = j.next();
					String segcode = task.getHBCICode();

					if ( getPinTanInfo( segcode ).equals( "J" ) )
					{
						// es handelt sich um einen tan-pflichtigen task
						logger.debug( "found task that requires a TAN: {} - have to patch message queue", segcode );

						if ( process.equals( "1" ) )
						{
							// prozessvariante 1
							logger.debug( "process #1: adding new message with HKTAN(p=1,hash=...) before current message" );

							// neue msg erzeugen
							additional_msg_tasks = new ArrayList<>();

							GVTAN2Step hktan = new GVTAN2Step( handler );
							hktan.setExternalId( task.getExternalId() ); // externe ID durchreichen

							// muessen wir explizit setzen, damit wir das HKTAN in der gleichen Version
							// schicken, in der das HITANS kam.
							hktan.setSegVersion( segversion );

							hktan.setParam( "process", process );
							hktan.setParam( "notlasttan", "N" );

							// willuhn 2011-05-16
							// Siehe FinTS_3.0_Security_Sicherheitsverfahren_PINTAN_Rel_20101027_final_version.pdf, Seite 58
							int hktanVersion = Integer.parseInt( hktan.getSegVersion() );
							if ( hktanVersion >= 5 )
							{
								// Bis HKTAN4/hhd1.3 wurde das noch als Challenge-Parameter uebermittelt. Jetzt hat es einen
								// eigenen Platz in den Job-Parametern
								hktan.setParam( "ordersegcode", task.getHBCICode() );

								// Zitat aus HITANS5: Diese Funktion ermöglicht das Sicherstellen einer gültigen Kontoverbindung
								// z. B. für die Abrechnung von SMS-Kosten bereits vor Erzeugen und Versenden einer
								// (ggf. kostenpflichtigen!) TAN.
								// 0: Auftraggeberkonto darf nicht angegeben werden
								// 2: Auftraggeberkonto muss angegeben werden, wenn im Geschäftsvorfall enthalten
								String noa = secmechInfo.getProperty( "needorderaccount", "" );
								logger.info( "needorderaccount=" + noa );
								if ( noa.equals( "2" ) )
								{
									Konto k = task.getOrderAccount();
									if ( k != null )
									{
										logger.info( "applying orderaccount to HKTAN for " + task.getHBCICode() );
										hktan.setParam( "orderaccount", k );
									}
									else
									{
										logger.warn( "orderaccount needed, but not found in {}", task.getHBCICode() );
									}
								}
							}

							// TODO: das für mehrfachsignaturen
							// hktan.setParam("notlasttan","J");

							// orderhash ermitteln
							try
							{
								// TODO: hier wird jetzt *immer* segnum=3 angenommen,
								// kann in Einzelfällen evtl. auch anders sein (?)
								SEG seg = task.createJobSegment( 3 );
								seg.validate();
								String segdata = seg.toString( 0 );
								logger.debug( "calculating hash for jobsegment: {}", segdata );

								// zu verwendenden Hash-Algorithmus von dem Wert "orderhashmode" aus den BPD abhängig machen
								String orderhashmode = getOrderHashMode();
								String alg = null;
								String provider = null;
								if ( orderhashmode.equals( "1" ) )
								{
									alg = "RIPEMD160";
									provider = "CryptAlgs4Java";
								}
								else if ( orderhashmode.equals( "2" ) )
								{
									alg = "SHA-1";
								}
								logger.debug( "using " + alg + "/" + provider + " for generating order hash" );
								MessageDigest digest = MessageDigest.getInstance( alg, provider );

								digest.update( segdata.getBytes( Comm.ENCODING ) );
								byte[] hash = digest.digest();
								SEGFactory.getInstance().unuseObject( seg );
								hktan.setParam( "orderhash", new String( hash, Comm.ENCODING ) );
							}
							catch ( Exception e )
							{
								throw new HBCI_Exception( e );
							}

							// TODO: evtl. listindex ermitteln
							// hktan.setParam("listidx","");

							// wenn needchallengeklass gesetzt ist:
							if ( secmechInfo.getProperty( "needchallengeklass", "N" ).equals( "J" ) )
							{
								logger.debug( "we are in PV #1, and a challenge klass is required" );
								ChallengeInfo cinfo = ChallengeInfo.getInstance();
								cinfo.applyParams( task, hktan, secmechInfo );
							}

							// willuhn 2011-05-09: Bei Bedarf noch das TAN-Medium erfragen
							applyTanMedia( hktan );

							// hktan-job zur neuen msg hinzufügen
							additional_msg_tasks.add( hktan );

							// diese neue msg vor der aktuellen in die msg-queue einstellen
							new_msgs.add( additional_msg_tasks );
							// und gleich wieder auf null setzen, damit diese msg nicht
							// später nochmal *nach* der aktuellen msg eingefügt wird
							additional_msg_tasks = null;

							// den aktuellen task ganz normal zur aktuellen msg hinzufügen
							new_msg_tasks.add( task );
						}
						else
						{
							// prozessvariante 2
							logger.debug( "process #2: adding new task HKTAN(p=4) to current message" );

							// den aktuellen task ganz normal zur aktuellen msg hinzufügen
							new_msg_tasks.add( task );

							// dazu noch einen hktan-job hinzufügen
							GVTAN2Step hktan1 = new GVTAN2Step( handler );
							hktan1.setExternalId( task.getExternalId() ); // externe ID durchreichen

							// muessen wir explizit setzen, damit wir das HKTAN in der gleichen Version
							// schicken, in der das HITANS kam.
							hktan1.setSegVersion( segversion );

							hktan1.setParam( "process", "4" );
							// TODO: evtl. listindex ermitteln
							// hktan1.setParam("listidx","");
							// TODO: das für mehrfachsignaturen
							// hktan1.setParam("notlasttan","N");

							// willuhn 2011-05-09: Bei Bedarf noch das TAN-Medium erfragen
							applyTanMedia( hktan1 );

							// den hktan-job zusätzlich zur aktuellen msg hinzufügen
							new_msg_tasks.add( hktan1 );

							// eine neue msg für das einreichen der tan erzeugen
							logger.debug( "creating new msg with HKTAN(p=2,orderref=DELAYED)" );
							additional_msg_tasks = new ArrayList<>();

							// HKTAN-job für das einreichen der TAN erzeugen
							GVTAN2Step hktan2 = new GVTAN2Step( handler );
							hktan2.setExternalId( task.getExternalId() ); // externe ID durchreichen

							// muessen wir explizit setzen, damit wir das HKTAN in der gleichen Version
							// schicken, in der das HITANS kam.
							hktan1.setSegVersion( segversion );

							hktan2.setParam( "process", "2" );
							hktan2.setParam( "notlasttan", "N" );
							// TODO: evtl. listindex ermitteln
							// hktan2.setParam("listidx","");
							// TODO: das für mehrfachsignaturen
							// hktan2.setParam("notlasttan","J");

							// willuhn 2011-05-09 TAN-Media gibts nur bei Prozess 1,3,4 - also nicht in hktan2

							// hktan-job zur neuen msg hinzufügen
							additional_msg_tasks.add( hktan2 );

							// in dem ersten HKTAN-job eine referenz auf den zweiten speichern,
							// damit der erste die auftragsreferenz später im zweiten speichern kann
							logger.debug( "storing reference to this HKTAN in previous HKTAN segment" );
							hktan1.storeOtherTAN2StepTask( hktan2 );

							// in dem zweiten HKTAN-job eine referenz auf den originalen job
							// speichern, damit die antwortdaten für den job, die als antwortdaten
							// für hktan2 ankommen, dem richtigen job zugeordnet werden können
							logger.debug( "storing reference to original job in new HKTAN segment" );
							hktan2.storeOriginalTask( task );

							// die neue msg wird später (nach der aktuellen) zur msg-queue hinzugefügt
						}
					}
					else
					{
						// kein tan-pflichtiger task, also einfach zur gepatchten msg-queue hinzufügen
						logger.debug( "found task that does not require a TAN: " + segcode + " - adding it to current msg" );
						new_msg_tasks.add( task );
					}
				}

				msg_tasks.clear();
				msg_tasks.addAll( new_msg_tasks );

				new_msgs.add( msg_tasks );
				if ( additional_msg_tasks != null )
				{
					// wenn für prozessvariante 2 eine zusätzliche msg erzeugt
					// wurde, diese jetzt mit anhängen
					logger.debug( "adding newly created message with HKTAN(p=2) after current one" );
					new_msgs.add( additional_msg_tasks );
					additional_msg_tasks = null;
				}
			}

			msgs.clear();
			msgs.addAll( new_msgs );
		}
	}

	/**
	 * Uebernimmt das Rueckfragen und Einsetzen der TAN-Medien-Bezeichung bei Bedarf.
	 * 
	 * @param hktan
	 *        der Job, in den der Parameter eingesetzt werden soll.
	 * @param secmechInfo
	 */
	private void applyTanMedia( GVTAN2Step hktan )
	{
		if ( hktan == null )
			return;

		// Gibts erst ab hhd1.3, siehe
		// FinTS_3.0_Security_Sicherheitsverfahren_PINTAN_Rel_20101027_final_version.pdf, Kapitel B.4.3.1.1.1
		// Zitat: Ist in der BPD als Anzahl unterstützter aktiver TAN-Medien ein Wert > 1
		// angegeben und ist der BPD-Wert für Bezeichnung des TAN-Mediums erforderlich = 2,
		// so muss der Kunde z. B. im Falle des mobileTAN-Verfahrens
		// hier die Bezeichnung seines für diesen Auftrag zu verwendenden TAN-
		// Mediums angeben.
		// Ausserdem: "Nur bei TAN-Prozess=1, 3, 4". Das muess aber der Aufrufer pruefen. Ist mir
		// hier zu kompliziert

		int hktan_version = Integer.parseInt( hktan.getSegVersion() );
		logger.debug( "hktan_version: {}", hktan_version );
		if ( hktan_version >= 3 )
		{
			Properties secmechInfo = getCurrentSecMechInfo();

			// Anzahl aktiver TAN-Medien ermitteln
			int num = Integer.parseInt( secmechInfo.getProperty( "nofactivetanmedia", "0" ) );
			String needed = secmechInfo.getProperty( "needtanmedia", "" );
			logger.debug( "nofactivetanmedia: " + num + ", needtanmedia: " + needed );

			// Ich hab Mails von Usern erhalten, bei denen die Angabe des TAN-Mediums auch
			// dann noetig war, wenn nur eine Handy-Nummer hinterlegt war. Daher logen wir
			// "num" nur, bringen die Abfrage jedoch schon bei num<2 - insofern needed=2.
			if ( needed.equals( "2" ) )
			{
				logger.debug( "we have to add the tan media" );

				StringBuffer retData = new StringBuffer();
				retData.append( this.getUPD().getProperty( "tanmedia.names", "" ) );
				getCallback().callback( this, HBCICallback.NEED_PT_TANMEDIA,
						"*** Enter the name of your TAN media",
						HBCICallback.TYPE_TEXT,
						retData );

				hktan.setParam( "tanmedia", retData.toString() );
			}
		}
	}

	public void afterCustomDialogInitHook( HBCIDialog dialog )
	{
		super.afterCustomDialogInitHook( dialog );
		patchMessagesFor2StepMethods( dialog );
	}

	public void setPIN( String pin )
	{
		this.pin = pin;
	}

	public String getPIN()
	{
		return this.pin;
	}

	public void clearPIN()
	{
		setPIN( null );
	}

	public List<String> getAllowedTwostepMechanisms()
	{
		return this.allowedTwostepMechanisms;
	}

	public void setAllowedTwostepMechanisms( List<String> l )
	{
		this.allowedTwostepMechanisms = l;
	}

	public int getMaxGVSegsPerMsg()
	{
		return 1;
	}

	/**
	 * Ueberschrieben, um das "https://" am Anfang automatisch abzuschneiden.
	 * Das sorgte schon fuer so viele unnoetige Fehler.
	 * 
	 * @see org.kapott.hbci.passport.AbstractHBCIPassport#getHost()
	 */
	@Override
	public String getHost()
	{
		String host = super.getHost();
		if ( host == null || host.length() == 0 || !host.startsWith( "https://" ) )
			return host;

		return host.replace( "https://", "" );
	}
}