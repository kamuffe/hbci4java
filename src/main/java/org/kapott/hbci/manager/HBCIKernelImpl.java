
/*
 * $Id: HBCIKernelImpl.java,v 1.1 2011/05/04 22:37:47 willuhn Exp $
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

package org.kapott.hbci.manager;

import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.StringTokenizer;

import org.kapott.hbci.callback.HBCICallback;
import org.kapott.hbci.exceptions.CanNotParseMessageException;
import org.kapott.hbci.exceptions.HBCI_Exception;
import org.kapott.hbci.exceptions.InvalidUserDataException;
import org.kapott.hbci.passport.HBCIPassport;
import org.kapott.hbci.passport.HBCIPassportInternal;
import org.kapott.hbci.passport.HBCIPassportList;
import org.kapott.hbci.protocol.MSG;
import org.kapott.hbci.protocol.factory.MSGFactory;
import org.kapott.hbci.rewrite.Rewrite;
import org.kapott.hbci.security.Crypt;
import org.kapott.hbci.security.Sig;
import org.kapott.hbci.security.factory.CryptFactory;
import org.kapott.hbci.security.factory.SigFactory;
import org.kapott.hbci.status.HBCIMsgStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public final class HBCIKernelImpl
		implements HBCIKernel
{
	/**
	 * The {@link Logger} to be used.
	 */
	private static final Logger logger = LoggerFactory.getLogger( HBCIKernelImpl.class );

	public static final boolean SIGNIT = true;
	public static final boolean DONT_SIGNIT = false;
	public static final boolean CRYPTIT = true;
	public static final boolean DONT_CRYPTIT = false;
	public static final boolean NEED_SIG = true;
	public static final boolean DONT_NEED_SIG = false;
	public static final boolean NEED_CRYPT = true;
	public static final boolean DONT_NEED_CRYPT = false;

	private MsgGen gen; /* an instance of a message generator */
	private String currentMsgName; /* name of job currently beeing created */

	private IHandlerData parentHandlerData;

	public HBCIKernelImpl( IHandlerData parentHandlerData )
	{
		this.parentHandlerData = parentHandlerData;

		InputStream syntaxStream = null;


		String hbciVersion = parentHandlerData.getPassport().getHBCIVersion();			
		
		ClassLoader cl = this.getClass().getClassLoader();
		String filename = "hbci-" + hbciVersion + ".xml";
		syntaxStream = cl.getResourceAsStream( filename );
		if ( syntaxStream == null )
		{
			throw new InvalidUserDataException( HBCIUtils.getLocMsg( "EXCMSG_KRNL_CANTLOAD_SYN", filename ) );			
		}

		try
		{
			gen = new MsgGen( syntaxStream );
			currentMsgName = null;
		}
		catch ( Exception e )
		{
			throw new HBCI_Exception( HBCIUtils.getLocMsg( "EXCMSG_MSGGEN_INIT" ), e );
		}
	}

	public void setParentHandlerData( IHandlerData parentHandlerData )
	{
		if ( this.parentHandlerData != null )
		{
			throw new HBCI_Exception( "*** can not overwrite existing handler object" );
		}
		this.parentHandlerData = parentHandlerData;
	}

	public IHandlerData getParentHandlerData()
	{
		return this.parentHandlerData;
	}

	public String getHBCIVersion( int dummy )
	{
		String ret = "";
		NodeList nodes = gen.getSyntax().getElementById( "MsgHeadUser" ).getElementsByTagName( "value" );
		int len = nodes.getLength();

		for ( int i = 0; i < len; i++ )
		{
			Element node = (Element) nodes.item( i );
			if ( node.getAttribute( "path" ).equals( "hbciversion" ) )
			{
				ret = node.getFirstChild().getNodeValue();
				break;
			}
		}

		return ret;
	}

	/*
	 * Starts the creation of a new HBCI message (mid-level API).
	 * This method initializes some internal variables that are needed
	 * when you later set parameters using the rawSet() method.
	 * @param name Is the name of the message to be created. You can find a list
	 * of all possible names in the xml-file describing the syntax,
	 * all nodes <MSGdef id="xxx"> contain descriptions for the message
	 * with name "xxx"
	 */
	public void rawNewMsg( String name )
	{
		if ( name == null || name.length() == 0 )
			throw new HBCI_Exception( HBCIUtils.getLocMsg( "EXCMSG_EMPTY_MSGNAME" ) );

		currentMsgName = name;
		logger.debug( "creating new raw message {}", name );
		gen.reset();
	}

	/*
	 * Sets a parameter for the currently to be created message
	 * (mid-level API).
	 * The @p key is the path to the element to be set, with the message name
	 * of the current message removed, e.g. if you want to set the value
	 * of DialogInit.Idn.prodName, you have to specify Idn.prodName as @key.
	 * @param key Path in current message to the element to be set.
	 * @param value String-representation of the new value for that element
	 */
	public void rawSet( String key, String value )
	{
		logger.debug( "setting raw property " + currentMsgName + "." + key + " to \"" + value + "\"" );

		if ( currentMsgName == null )
			throw new HBCI_Exception( HBCIUtils.getLocMsg( "EXCMSG_NORAWMSG" ) );
		if ( key == null )
			throw new HBCI_Exception( HBCIUtils.getLocMsg( "EXCMSG_KEYNULL" ) );
		if ( value == null )
			throw new HBCI_Exception( HBCIUtils.getLocMsg( "EXCMSG_VALUENULL", key ) );

		if ( value.length() != 0 )
		{
			gen.set( currentMsgName + "." + key, value );
		}
	}

	public HBCIMsgStatus rawDoIt( boolean signit, boolean cryptit, boolean needSig, boolean needCrypt )
	{
		HBCIPassportList passports = new HBCIPassportList();
		HBCIPassportInternal passport = (HBCIPassportInternal) getParentHandlerData().getPassport();
		passports.addPassport( passport, HBCIPassport.ROLE_ISS );
		return rawDoIt( passports, signit, cryptit, needSig, needCrypt );
	}

	/*
	 * Processes the current message (mid-level API).
	 * This method creates the message specified earlier by the methods rawNewJob() and
	 * rawSet(), signs and encrypts it using the values of @p inst, @p user, @p signit
	 * and @p crypit and sends it to server.
	 * After that it waits for the response, decrypts it, checks the signature of the
	 * received message and returns a Properties object, that contains as keys the
	 * pathnames of all elements of the received message, and as values the corresponding
	 * value of the element with that path
	 * bricht diese methode mit einer exception ab, so muss die aufrufende methode
	 * die nachricht komplett neu erzeugen.
	 * @param signit A boolean value specifying, if the message to be sent should be signed.
	 * @param cryptit A boolean value specifying, if the message to be sent should be encrypted.
	 * @return A Properties object that contains a path-value-pair for each dataelement of
	 * the received message.
	 */
	public HBCIMsgStatus rawDoIt( HBCIPassportList passports, boolean signit, boolean cryptit, boolean needSig, boolean needCrypt )
	{
		HBCIMsgStatus ret = new HBCIMsgStatus();
		MSG msg = null;

		try
		{
			HBCIPassportInternal mainPassport = passports.getMainPassport();

			logger.debug( "generating raw message {}", currentMsgName );
			mainPassport.getCallback().status( mainPassport, HBCICallback.STATUS_MSG_CREATE, currentMsgName );

			// plaintextnachricht erzeugen
			msg = gen.generate( currentMsgName );

			// alle daten für den rewriter setzen
			Rewrite.setData( "passports", passports );
			Rewrite.setData( "msgStatus", ret );
			Rewrite.setData( "msgName", currentMsgName );
			Rewrite.setData( "signIt", Boolean.valueOf( signit ) );
			Rewrite.setData( "cryptIt", Boolean.valueOf( cryptit ) );
			Rewrite.setData( "needSig", Boolean.valueOf( needSig ) );
			Rewrite.setData( "needCrypt", Boolean.valueOf( needCrypt ) );

			// liste der rewriter erzeugen
			String rewriters_st = HBCIUtils.getParam( "kernel.rewriter" );
			ArrayList<Rewrite> rewriters = new ArrayList<>();
			StringTokenizer tok = new StringTokenizer( rewriters_st, "," );
			while ( tok.hasMoreTokens() )
			{
				String rewriterName = tok.nextToken().trim();
				if ( rewriterName.length() != 0 )
				{
					Class cl = this.getClass().getClassLoader().loadClass( "org.kapott.hbci.rewrite.R" +
							rewriterName );
					Constructor con = cl.getConstructor( (Class[]) null );
					Rewrite rewriter = (Rewrite) (con.newInstance( (Object[]) null ));
					rewriters.add( rewriter );
				}
			}

			// alle rewriter durchlaufen und plaintextnachricht patchen
			for ( Rewrite rewrite : rewriters )
			{
				MSG old = msg;
				msg = rewrite.outgoingClearText( old, gen );
				if ( msg != old )
				{
					MSGFactory.getInstance().unuseObject( old );
				}
			}

			// HBCIUtils.log("sending msg: "+msg.toString(0));

			// wenn nachricht signiert werden soll
			if ( signit )
			{
				logger.debug( "trying to insert signature" );
				mainPassport.getCallback().status( mainPassport, HBCICallback.STATUS_MSG_SIGN, null );

				// signatur erzeugen und an nachricht anhängen
				Sig sig = SigFactory.getInstance().createSig( getParentHandlerData(), msg, passports );
				try
				{
					if ( !sig.signIt() )
					{
						String errmsg = HBCIUtils.getLocMsg( "EXCMSG_CANTSIGN" );
						if ( !HBCIUtilsInternal.ignoreError( null, "client.errors.ignoreSignErrors", errmsg ) )
						{
							throw new HBCI_Exception( errmsg );
						}
					}
				}
				finally
				{
					SigFactory.getInstance().unuseObject( sig );
				}

				// alle rewrites erledigen, die *nach* dem hinzufügen der signatur stattfinden müssen
				for ( Rewrite rewrite : rewriters )
				{
					MSG old = msg;
					msg = rewrite.outgoingSigned( old, gen );
					if ( msg != old )
					{
						MSGFactory.getInstance().unuseObject( old );
					}
				}
			}

			/*
			 * zu jeder SyntaxElement-Referenz (2:3,1)==(SEG:DEG,DE) den Pfad
			 * des jeweiligen Elementes speichern
			 */
			Properties paths = new Properties();
			msg.getElementPaths( paths, null, null, null );
			ret.addData( paths );

			/*
			 * für alle Elemente (Pfadnamen) die aktuellen Werte speichern,
			 * wie sie bei der ausgehenden Nachricht versandt werden
			 */
			Hashtable<String, String> current = new Hashtable<>();
			msg.extractValues( current );
			Properties origs = new Properties();
			for ( Enumeration<String> e = current.keys(); e.hasMoreElements(); )
			{
				String key = e.nextElement();
				String value = current.get( key );
				origs.setProperty( "orig_" + key, value );
			}
			ret.addData( origs );

			// zu versendene nachricht loggen
			String outstring = msg.toString( 0 );
			logger.debug( "sending message: {}", outstring );

			// max. nachrichtengröße aus BPD überprüfen
			int maxmsgsize = mainPassport.getMaxMsgSizeKB();
			if ( maxmsgsize != 0 && (outstring.length() >> 10) > maxmsgsize )
			{
				String errmsg = HBCIUtils.getLocMsg( "EXCMSG_MSGTOOLARGE",
						new Object[] { Integer.toString( outstring.length() >> 10 ), Integer.toString( maxmsgsize ) } );
				if ( !HBCIUtilsInternal.ignoreError( null, "client.errors.ignoreMsgSizeErrors", errmsg ) )
					throw new HBCI_Exception( errmsg );
			}

			// soll nachricht verschlüsselt werden?
			if ( cryptit )
			{
				logger.debug( "trying to encrypt message" );
				mainPassport.getCallback().status( mainPassport, HBCICallback.STATUS_MSG_CRYPT, null );

				// nachricht verschlüsseln
				MSG old = msg;
				Crypt crypt = CryptFactory.getInstance().createCrypt( getParentHandlerData(), old );
				try
				{
					msg = crypt.cryptIt( "Crypted" );
				}
				finally
				{
					CryptFactory.getInstance().unuseObject( crypt );
					if ( msg != old )
					{
						MSGFactory.getInstance().unuseObject( old );
					}
				}

				if ( !msg.getName().equals( "Crypted" ) )
				{
					String errmsg = HBCIUtils.getLocMsg( "EXCMSG_CANTCRYPT" );
					if ( !HBCIUtilsInternal.ignoreError( null, "client.errors.ignoreCryptErrors", errmsg ) )
						throw new HBCI_Exception( errmsg );
				}

				// verschlüsselte nachricht patchen
				for ( Rewrite rewrite : rewriters )
				{
					MSG oldMsg = msg;
					msg = rewrite.outgoingCrypted( oldMsg, gen );
					if ( msg != oldMsg )
					{
						MSGFactory.getInstance().unuseObject( oldMsg );
					}
				}

				logger.debug( "encrypted message to be sent: {}", msg.toString( 0 ) );
			}

			// basic-values der ausgehenden nachricht merken
			String msgPath = msg.getPath();
			String msgnum = msg.getValueOfDE( msgPath + ".MsgHead.msgnum" );
			String dialogid = msg.getValueOfDE( msgPath + ".MsgHead.dialogid" );
			String hbciversion = msg.getValueOfDE( msgPath + ".MsgHead.hbciversion" );

			// nachricht versenden und antwortnachricht empfangen
			logger.debug( "communicating dialogid/msgnum " + dialogid + "/" + msgnum );
			MSG old = msg;
			msg = mainPassport.getComm().pingpong( currentMsgName, old );
			if ( msg != old )
			{
				MSGFactory.getInstance().unuseObject( old );
			}

			// ist antwortnachricht verschlüsselt?
			boolean crypted = msg.getName().equals( "CryptedRes" );
			if ( crypted )
			{
				mainPassport.getCallback().status( mainPassport, HBCICallback.STATUS_MSG_DECRYPT, null );

				// wenn ja, dann nachricht entschlüsseln
				logger.debug( "acquire crypt instance" );
				Crypt crypt = CryptFactory.getInstance().createCrypt( getParentHandlerData(), msg );
				String newmsgstring;
				try
				{
					logger.debug( "decrypting using " + crypt );
					newmsgstring = crypt.decryptIt();
					logger.debug( "decrypted" );
					mainPassport.getCallback().status( mainPassport, HBCICallback.STATUS_MSG_RAW_RECV, newmsgstring );
				}
				finally
				{
					logger.debug( "free crypt" );
					CryptFactory.getInstance().unuseObject( crypt );
					logger.debug( "crypt freed" );
				}
				gen.set( "_origSignedMsg", newmsgstring );

				// alle patches für die unverschlüsselte nachricht durchlaufen
				logger.debug( "rewriting message" );
				for ( Rewrite rewrite : rewriters )
				{
					logger.debug( "applying rewriter {}", rewrite.getClass().getSimpleName() );
					newmsgstring = rewrite.incomingClearText( newmsgstring, gen );
				}
				logger.debug( "rewriting done" );

				logger.debug( "decrypted message after rewriting: {}", newmsgstring );

				// nachricht als plaintextnachricht parsen
				try
				{
					mainPassport.getCallback().status( mainPassport, HBCICallback.STATUS_MSG_PARSE, currentMsgName + "Res" );
					logger.debug( "message to pe parsed: {}", msg.toString( 0 ) );
					MSG oldMsg = msg;
					msg = MSGFactory.getInstance().createMSG( currentMsgName + "Res", newmsgstring, newmsgstring.length(), gen );
					if ( msg != oldMsg )
					{
						MSGFactory.getInstance().unuseObject( oldMsg );
					}
				}
				catch ( Exception ex )
				{
					throw new CanNotParseMessageException( HBCIUtils.getLocMsg( "EXCMSG_CANTPARSE" ), newmsgstring, ex );
				}
			}
			else
			{
				mainPassport.getCallback().status( mainPassport, HBCICallback.STATUS_MSG_RAW_RECV, msg.toString( 0 ) );
			}

			logger.debug( "received message after decryption: {}", msg.toString( 0 ) );

			// alle patches für die plaintextnachricht durchlaufen
			for ( Rewrite rewrite : rewriters )
			{
				MSG oldMsg = msg;
				msg = rewrite.incomingData( oldMsg, gen );
				if ( msg != oldMsg )
				{
					MSGFactory.getInstance().unuseObject( oldMsg );
				}
			}

			// daten aus nachricht in status-objekt einstellen
			logger.debug( "extracting data from received message" );
			Properties p = msg.getData();
			p.setProperty( "_msg", gen.get( "_origSignedMsg" ) );
			ret.addData( p );

			// überprüfen einiger constraints, die in einer antwortnachricht eingehalten werden müssen
			msgPath = msg.getPath();
			try
			{
				String hbciversion2 = msg.getValueOfDE( msgPath + ".MsgHead.hbciversion" );
				if ( !hbciversion2.equals( hbciversion ) )
					throw new HBCI_Exception( HBCIUtils.getLocMsg( "EXCMSG_INVVERSION", new Object[] { hbciversion2,
							hbciversion } ) );
				String msgnum2 = msg.getValueOfDE( msgPath + ".MsgHead.msgnum" );
				if ( !msgnum2.equals( msgnum ) )
					throw new HBCI_Exception( HBCIUtils.getLocMsg( "EXCMSG_INVMSGNUM_HEAD", new Object[] { msgnum2, msgnum } ) );
				msgnum2 = msg.getValueOfDE( msgPath + ".MsgTail.msgnum" );
				if ( !msgnum2.equals( msgnum ) )
					throw new HBCI_Exception( HBCIUtils.getLocMsg( "EXCMSG_INVMSGNUM_TAIL", new Object[] { msgnum2, msgnum } ) );
				String dialogid2 = msg.getValueOfDE( msgPath + ".MsgHead.dialogid" );
				if ( !dialogid.equals( "0" ) && !dialogid2.equals( dialogid ) )
					throw new HBCI_Exception( HBCIUtils.getLocMsg( "EXCMSG_INVDIALOGID", new Object[] { dialogid2, dialogid } ) );
				if ( !dialogid.equals( "0" ) && !msg.getValueOfDE( msgPath + ".MsgHead.MsgRef.dialogid" ).equals( dialogid ) )
					throw new HBCI_Exception( HBCIUtils.getLocMsg( "EXCMSG_INVDIALOGID_REF" ) );
				if ( !msg.getValueOfDE( msgPath + ".MsgHead.MsgRef.msgnum" ).equals( msgnum ) )
					throw new HBCI_Exception( HBCIUtils.getLocMsg( "EXCMSG_INVMSGNUM_REF" ) );
			}
			catch ( HBCI_Exception e )
			{
				String errmsg = HBCIUtils.getLocMsg( "EXCMSG_MSGCHECK" ) + ": " + HBCIUtils.exception2String( e );
				if ( !HBCIUtilsInternal.ignoreError( null, "client.errors.ignoreMsgCheckErrors", errmsg ) )
					throw e;
			}

			// überprüfen der signatur
			logger.debug( "looking for a signature" );
			mainPassport.getCallback().status( mainPassport, HBCICallback.STATUS_MSG_VERIFY, null );
			boolean sigOk = false;
			Sig sig = SigFactory.getInstance().createSig( getParentHandlerData(), msg, passports );
			try
			{
				sigOk = sig.verify();
			}
			finally
			{
				SigFactory.getInstance().unuseObject( sig );
			}

			// fehlermeldungen erzeugen, wenn irgendwelche fehler aufgetreten sind
			logger.debug( "looking if message is encrypted" );

			// fehler wegen falscher verschlüsselung
			if ( needCrypt && !crypted )
			{
				String errmsg = HBCIUtils.getLocMsg( "EXCMSG_NOTCRYPTED" );
				if ( !HBCIUtilsInternal.ignoreError( null, "client.errors.ignoreCryptErrors", errmsg ) )
					throw new HBCI_Exception( errmsg );
			}

			// signaturfehler
			if ( !sigOk )
			{
				String errmsg = HBCIUtils.getLocMsg( "EXCMSG_INVSIG" );
				if ( !HBCIUtilsInternal.ignoreError( null, "client.errors.ignoreSignErrors", errmsg ) )
					throw new HBCI_Exception( errmsg );
			}
		}
		catch ( Exception e )
		{
			// TODO: hack to be able to "disable" HKEND response message analysis
			// because some credit institutes are buggy regarding HKEND responses
			String paramName = "client.errors.ignoreDialogEndErrors";
			if ( currentMsgName.startsWith( "DialogEnd" ) &&
					HBCIUtils.getParam( paramName, "no" ).equals( "yes" ) )
			{
				logger.warn( "Exception occurred", e );
				logger.warn( "error while receiving DialogEnd response - but ignoring it because of special setting" );
			}
			else
			{
				ret.addException( e );
			}
		}
		finally
		{
			MSGFactory.getInstance().unuseObject( msg );
			currentMsgName = null;
			gen.reset();
		}

		return ret;
	}

	public void reset()
	{
		gen.reset();
		currentMsgName = null;
	}

	@Override
	public Map<String, List<String>> getAllLowlevelJobs()
	{
		return getMsgGen().getLowlevelGVs();
	}

	@Override
	public List<String> getLowlevelJobParameterNames( String gvname, String version )
	{
		return getMsgGen().getGVParameterNames( gvname, version );
	}

	@Override
	public List<String> getLowlevelJobResultNames( String gvname, String version )
	{
		return getMsgGen().getGVResultNames( gvname, version );
	}

	@Override
	public List<String> getLowlevelJobRestrictionNames( String gvname, String version )
	{
		return getMsgGen().getGVRestrictionNames( gvname, version );
	}

	public MsgGen getMsgGen()
	{
		return gen;
	}
}
