
/*
 * $Id: CommStandard.java,v 1.1 2011/05/04 22:37:50 willuhn Exp $
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

import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Socket;

import org.kapott.hbci.exceptions.HBCI_Exception;
import org.kapott.hbci.manager.HBCIUtils;
import org.kapott.hbci.manager.HBCIUtilsInternal;
import org.kapott.hbci.manager.MsgGen;
import org.kapott.hbci.passport.HBCIPassportInternal;
import org.kapott.hbci.protocol.MSG;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class CommStandard
		extends Comm
{
	/**
	 * The {@link Logger} to be used.
	 */
	private static final Logger logger = LoggerFactory.getLogger( CommStandard.class );

	Socket s;
	/** < @internal @brief The socket for communicating with the server. */
	OutputStream o;
	/** < @internal @brief The outputstream to write HBCI-messages to. */
	InputStream i;

	/** < @internal @brief The inputstream to read HBCI-messages from. */

	public CommStandard( HBCIPassportInternal parentPassport )
	{
		super( parentPassport );

		logger.debug( "opening connection to " +
				parentPassport.getHost() + ":" +
				parentPassport.getPort().toString() );

		try
		{
			String socksServer = HBCIUtils.getParam( "comm.standard.socks.server" );
			if ( socksServer != null && socksServer.trim().length() != 0 )
			{
				// use SOCKS server
				String[] ss = socksServer.split( ":" );
				String socksHost = ss[0].trim();
				String socksPort = ss[1].trim();
				logger.debug(
						"using SOCKS server at " + socksHost + ":" + socksPort );

				Proxy proxy = new Proxy(
						Proxy.Type.SOCKS,
						new InetSocketAddress( socksHost, Integer.parseInt( socksPort ) ) );
				this.s = new Socket( proxy );

			}
			else
			{
				// no SOCKS server
				s = new Socket();
			}

			int localPort = Integer.parseInt( HBCIUtils.getParam( "client.connection.localPort", "0" ) );
			if ( localPort != 0 )
			{
				s.setReuseAddress( true );
				s.bind( new InetSocketAddress( localPort ) );
			}

			s.connect( new InetSocketAddress( parentPassport.getHost(),
					parentPassport.getPort().intValue() ) );
			i = s.getInputStream();
			o = s.getOutputStream();
		}
		catch ( Exception e )
		{
			throw new HBCI_Exception( HBCIUtils.getLocMsg( "EXCMSG_CONNERR" ), e );
		}
	}

	protected void ping( MSG msg )
	{
		try
		{
			byte[] b = filter.encode( msg.toString( 0 ) );

			o.write( b );
			o.flush();
		}
		catch ( Exception ex )
		{
			throw new HBCI_Exception( HBCIUtils.getLocMsg( "EXCMSG_SENDERR" ), ex );
		}
	}

	protected StringBuffer pong( MsgGen gen )
	{
		int num;
		byte[] b = new byte[1024];
		StringBuffer ret = new StringBuffer();
		boolean sizeknown = false;
		int msgsize = -1;

		logger.info( "waiting for response" );

		try
		{
			StringBuffer res = new StringBuffer();

			while ( (!sizeknown || msgsize > 0) && (num = i.read( b )) != -1 )
			{
				logger.debug( "received " + num + " bytes" );

				String st = new String( b, 0, num, ENCODING );

				ret.append( st );

				if ( !sizeknown )
				{
					res.setLength( 0 );
					res.append( filter.decode( ret.toString() ) );

					msgsize = extractMessageSize( res );
					if ( msgsize != -1 )
					{
						logger.debug( "found message size: " + msgsize );
						// jetzt ist die msgsize bekannt
						// davon die anzahl der schon gelesenen zeichen abziehen
						msgsize -= ret.length();
						sizeknown = true;
					}
				}
				else
				{
					msgsize -= num;

				}
				logger.debug( "we still need " + msgsize + " bytes" );
			}

			// FileOutputStream fo=new FileOutputStream("pong.dat");
			// fo.write(ret.toString().getBytes(ENCODING));
			// fo.close();

			return new StringBuffer( filter.decode( ret.toString() ) );
		}
		catch ( Exception ex )
		{
			throw new HBCI_Exception( HBCIUtils.getLocMsg( "EXCMSG_RECVERR" ), ex );
		}
	}

	private int extractMessageSize( StringBuffer st )
	{
		int ret = -1;

		if ( st != null )
		{
			int firstPlus = st.indexOf( "+" );
			if ( firstPlus != -1 )
			{
				int secondPlus = st.indexOf( "+", firstPlus + 1 );
				if ( secondPlus != -1 )
				{
					ret = Integer.parseInt( st.substring( firstPlus + 1, secondPlus ) );
				}
			}
		}

		return ret;
	}

	protected void closeConnection()
	{
		try
		{
			logger.debug( "closing communication line" );
			s.close();
		}
		catch ( Exception ex )
		{
			throw new HBCI_Exception( HBCIUtils.getLocMsg( "EXCMSG_CLOSEERR" ), ex );
		}
	}
}
