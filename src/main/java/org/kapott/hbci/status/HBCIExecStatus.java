
/*
 * $Id: HBCIExecStatus.java,v 1.1 2011/05/04 22:38:02 willuhn Exp $
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

package org.kapott.hbci.status;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.kapott.hbci.manager.HBCIUtils;
import org.kapott.hbci.security.Sig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Statusinformationen über alle ausgeführten Dialoge. Die Methode
 * {@link org.kapott.hbci.manager.HBCIHandler#execute()} gibt nach der Ausführung
 * aller HBCI-Dialoge ein Objekt dieser Klasse zurück. Dieses Objekt enthält
 * Informationen darüber, für welche Kunden-IDs tatsächlich HBCI-Dialoge geführt
 * wurden. Für jeden geführten HBCI-Dialog existiert dann ein
 * {@link HBCIDialogStatus}-Objekt, welches Informationen zu dem jeweiligen
 * Dialog enthält.
 */
public class HBCIExecStatus
{
	/**
	 * The {@link Logger} to be used.
	 */
	private static final Logger logger = LoggerFactory.getLogger( HBCIExecStatus.class );

	private Map<String, HBCIDialogStatus> statusData = new HashMap<>();
	private Map<String, ArrayList<Exception>> exceptions = new HashMap<>();

	public HBCIExecStatus()
	{

	}

	/**
	 * Gibt die Menge aller Kunden-IDs zurück, für die ein HBCI-Dialog geführt wurde.
	 * 
	 * @return Liste mit Kunden-IDs
	 */
	public List<String> getCustomerIds()
	{
		List<String> ret = new ArrayList<>();

		Set<String> sset = statusData.keySet();
		if ( sset != null )
		{
			ret.addAll( sset );
		}

		Set<String> eset = exceptions.keySet();
		if ( eset != null )
		{
			ret.addAll( eset );
		}

		return ret;
	}

	/** Wird von der <em>HBCI4Java</em>-Dialog-Engine aufgerufen */
	public void addDialogStatus( String customerid, HBCIDialogStatus status )
	{
		if ( status != null )
		{
			statusData.put( customerid, status );
		}
		else
		{
			statusData.remove( customerid );
		}
	}

	/** Wird von der <em>HBCI4Java</em>-Dialog-Engine aufgerufen */
	public void addException( String customerid, Exception e )
	{
		ArrayList<Exception> exc = exceptions.get( customerid );
		if ( exc == null )
		{
			exc = new ArrayList<>();
			exceptions.put( customerid, exc );
		}
		exc.add( e );
		logger.error( "An error occurred.", e );
	}

	/**
	 * Gibt eine Liste von Status-Informationen für jeden ausgeführten HBCI-Dialog
	 * zurück. Diese Methode ist insofern von eingeschränkter Bedeutung, weil
	 * es nicht möglich ist, einem {@link HBCIDialogStatus}-Objekt dieser Liste
	 * die Kunden-ID zuzuordnen, unter der der jeweilige Dialog geführt wurde.
	 * Dazu müssen die Methoden {@link #getCustomerIds()} und {@link #getDialogStatus(String)}
	 * verwendet werden.
	 * 
	 * @return Menge aller gespeicherten HBCI-Dialog-Status-Informationen
	 * @deprecated sinnlos
	 */
	public List<HBCIDialogStatus> getDialogStatusList()
	{
		Collection<HBCIDialogStatus> values = statusData.values();
		return (values != null) ? (new ArrayList<HBCIDialogStatus>( values )) : (new ArrayList<HBCIDialogStatus>());
	}

	/**
	 * {@link HBCIDialogStatus} für den Dialog einer bestimmten Kunden-ID zurückgeben.
	 * 
	 * @param customerid
	 *        die Kunden-ID, für deren Dialog das Status-Objekt zurückgegeben werden soll
	 * @return Status-Objekt für den ausgewählten Dialog
	 */
	public HBCIDialogStatus getDialogStatus( String customerid )
	{
		return statusData.get( customerid );
	}

	/**
	 * Exceptions zurückgeben, die beim Ausführen eines bestimmten Dialoges aufgetreten sind.
	 * Dabei werden nur die Exceptions zurückgegeben, die Fehler in der Verwaltung der
	 * Kunden-IDs/Dialoge betreffen. Alle Exceptions, die während der eigentlichen
	 * Dialogausführung evtl. aufgetreten sind, sind im entsprechenden
	 * {@link HBCIDialogStatus}-Objekt des jeweiligen Dialoges enthalten.
	 * 
	 * @param customerid
	 *        die Kunden-ID, für deren HBCI-Dialog die evtl. aufgetretenen
	 *        Exceptions ermittelt werden sollen.
	 * @return Liste mit aufgetretenen Exceptions
	 */
	public List<Exception> getExceptions( String customerid )
	{
		List<Exception> exeptions = exceptions.get( customerid );
		return exeptions == null ? new ArrayList<Exception>() : exeptions;
	}

	/**
	 * Gibt einen String zurück, der alle Fehlermeldungen aller ausgeführten
	 * Dialog enthält.
	 * 
	 * @return String mit allen aufgetretenen Fehlermeldungen
	 */
	public String getErrorString()
	{
		StringBuilder sb = new StringBuilder();
		String linesep = System.lineSeparator();
		int nofCustomerIds = getCustomerIds().size();

		for ( String customerId : getCustomerIds() )
		{
			boolean customeridWritten = false;

			List<Exception> exc = getExceptions( customerId );
			if ( !exc.isEmpty() )
			{
				if ( nofCustomerIds > 1 )
				{
					sb.append( "Dialog for '" ).append( customerId ).append( "':" ).append( linesep );
					customeridWritten = true;
				}

				// ret.append(HBCIUtilsInternal.getLocMsg("STAT_EXCEPTIONS")).append(":").append(linesep);
				for ( Exception e : exc )
				{
					sb.append( HBCIUtils.exception2StringShort( e ) );
					sb.append( linesep );
				}
			}

			HBCIDialogStatus status = getDialogStatus( customerId );
			if ( status != null )
			{
				String errMsg = status.getErrorString();
				if ( errMsg.length() != 0 )
				{
					if ( nofCustomerIds > 1 && !customeridWritten )
					{
						sb.append( "Dialog for '" ).append( customerId ).append( "':" ).append( linesep );
					}
					sb.append( errMsg + linesep );
				}
			}
		}

		return sb.toString().trim();
	}

	public String toString( String customerId )
	{
		StringBuilder sb = new StringBuilder();

		List<Exception> exc = getExceptions( customerId );
		for ( Exception e : exc )
		{
			sb.append( HBCIUtils.exception2StringShort( e ) );
			sb.append( System.lineSeparator() );
		}
		

		HBCIDialogStatus status = getDialogStatus( customerId );
		if ( status != null )
		{
			sb.append( status.toString() );
			sb.append( System.lineSeparator() );
		}

		return sb.toString().trim();
	}

	/**
	 * Gibt einen String mit allen Status-Informationen über alle ausgeführten
	 * Dialoge zurück.
	 * 
	 * @return textuelle Darstellung aller gespeicherten Statusdaten
	 */
	public String toString()
	{
		StringBuilder sb = new StringBuilder();

		for ( String customerId : getCustomerIds() )
		{
			sb.append( "Dialog for '" );
			sb.append( customerId );
			sb.append( "':" );
			sb.append( System.lineSeparator() );
			sb.append( toString( customerId ) );
			sb.append( System.lineSeparator() );
		}

		return sb.toString().trim();
	}

	public boolean isOK( String customerId )
	{
		boolean ok = true;
		List<Exception> exc = getExceptions( customerId );
		HBCIDialogStatus status = getDialogStatus( customerId );

		ok &= (exc.isEmpty());
		ok &= (status != null);
		ok &= status.isOK();

		return ok;
	}

	/**
	 * Gibt zurück, ob alle "geplanten" HBCI-Dialoge ordnungsgemäß ausgeführt wurden.
	 * 
	 * @return <code>false</code>, wenn wenigstens bei einer Dialog-Ausführung
	 *         für eine Kunden-ID ein Fehler aufgetreten ist; ansonsten <code>true</code>
	 */
	public boolean isOK()
	{
		boolean ok = true;
		List<String> customerIds = getCustomerIds();

		for ( Iterator<String> i = customerIds.iterator(); i.hasNext(); )
		{
			String customerId = i.next();
			ok &= isOK( customerId );
		}

		return ok;
	}
}
