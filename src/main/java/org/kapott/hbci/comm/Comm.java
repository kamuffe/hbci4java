
/*
 * $Id: Comm.java,v 1.1 2011/05/04 22:37:51 willuhn Exp $
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

package org.kapott.hbci.comm;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.StringTokenizer;

import org.kapott.hbci.callback.HBCICallback;
import org.kapott.hbci.exceptions.CanNotParseMessageException;
import org.kapott.hbci.exceptions.HBCI_Exception;
import org.kapott.hbci.exceptions.ParseErrorException;
import org.kapott.hbci.manager.HBCIUtils;
import org.kapott.hbci.manager.HBCIUtilsInternal;
import org.kapott.hbci.manager.IHandlerData;
import org.kapott.hbci.manager.MsgGen;
import org.kapott.hbci.passport.HBCIPassportInternal;
import org.kapott.hbci.protocol.MSG;
import org.kapott.hbci.protocol.factory.MSGFactory;
import org.kapott.hbci.rewrite.Rewrite;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class Comm
{
	/**
	 * The {@link Logger} to be used.
	 */
	private static final Logger logger = LoggerFactory.getLogger( Comm.class );

	/**
	 * Der zu verwendende Zeichensatz.
	 */
	public final static String ENCODING = "ISO-8859-1";

	protected Filter filter;
	private HBCIPassportInternal parentPassport;

	protected abstract void ping( MSG msg );

	protected abstract StringBuffer pong( MsgGen gen );

	protected abstract void closeConnection();

	protected Comm( HBCIPassportInternal parentPassport )
	{
		this.parentPassport = parentPassport;
		this.filter = parentPassport.getCommFilter();

		parentPassport.getCallback().callback( parentPassport, HBCICallback.NEED_CONNECTION,
				HBCIUtils.getLocMsg( "CALLB_NEED_CONN" ), HBCICallback.TYPE_NONE, new StringBuffer() );
	}

	public MSG pingpong( String msgName, MSG msg )
	{
		IHandlerData handler = getParentPassport().getParentHandlerData();
		MsgGen gen = handler.getMsgGen();

		// ausgehende nachricht versenden
		parentPassport.getCallback().status( getParentPassport(), HBCICallback.STATUS_MSG_SEND, null );
		parentPassport.getCallback().status( getParentPassport(), HBCICallback.STATUS_MSG_RAW_SEND, msg.toString( 0 ) );
		ping( msg );

		// nachricht empfangen
		parentPassport.getCallback().status( getParentPassport(), HBCICallback.STATUS_MSG_RECV, null );
		String st = pong( gen ).toString();
		parentPassport.getCallback().status( getParentPassport(), HBCICallback.STATUS_MSG_RAW_RECV_ENCRYPTED, st );

		logger.debug( "received message: " + st );
		MSG retmsg = null;

		try
		{
			// erzeugen der liste aller rewriter
			String rewriters_st = HBCIUtils.getParam( "kernel.rewriter" );
			ArrayList<Rewrite> al = new ArrayList<Rewrite>();
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
					al.add( rewriter );
				}
			}
			Rewrite[] rewriters = al.toArray( new Rewrite[al.size()] );

			// alle rewriter für verschlüsselte nachricht durchlaufen
			for ( int i = 0; i < rewriters.length; i++ )
			{
				st = rewriters[i].incomingCrypted( st, gen );
			}

			// versuche, nachricht als verschlüsselte nachricht zu parsen
			parentPassport.getCallback().status( getParentPassport(), HBCICallback.STATUS_MSG_PARSE, "CryptedRes" );
			try
			{
				logger.debug( "trying to parse message as crypted message" );
				retmsg = MSGFactory.getInstance().createMSG( "CryptedRes", st, st.length(), gen, MSG.DONT_CHECK_SEQ );
			}
			catch ( ParseErrorException e )
			{
				// wenn das schiefgeht...
				logger.debug( "message seems not to be encrypted; tring to parse it as " + msgName + "Res message" );

				// alle rewriter durchlaufen, um nachricht evtl. als unverschlüsselte msg zu parsen
				gen.set( "_origSignedMsg", st );
				for ( int i = 0; i < rewriters.length; i++ )
				{
					st = rewriters[i].incomingClearText( st, gen );
				}

				// versuch, nachricht als unverschlüsselte msg zu parsen
				parentPassport.getCallback().status( getParentPassport(), HBCICallback.STATUS_MSG_PARSE, msgName + "Res" );
				retmsg = MSGFactory.getInstance().createMSG( msgName + "Res", st, st.length(), gen );
			}
		}
		catch ( Exception ex )
		{
			throw new CanNotParseMessageException( HBCIUtils.getLocMsg( "EXCMSG_CANTPARSE" ), st, ex );
		}

		return retmsg;
	}

	public static Comm getInstance( String name, HBCIPassportInternal passport )
	{
		try
		{
			Class cl = Class.forName( "org.kapott.hbci.comm.Comm" + name );
			Constructor cons = cl.getConstructor( new Class[] { HBCIPassportInternal.class } );
			return (Comm) cons.newInstance( new Object[] { passport } );
		}
		catch ( Exception e )
		{
			throw new HBCI_Exception( HBCIUtils.getLocMsg( "EXCMSG_CANTCREATECOMM", name ), e );
		}
	}

	protected HBCIPassportInternal getParentPassport()
	{
		return parentPassport;
	}

	public void close()
	{
		closeConnection();
		parentPassport.getCallback().callback( getParentPassport(), HBCICallback.CLOSE_CONNECTION,
				HBCIUtils.getLocMsg( "CALLB_CLOSE_CONN" ), HBCICallback.TYPE_NONE, new StringBuffer() );
	}
}
