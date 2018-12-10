
/*
 * $Id: PinTanProxyAuthenticator.java,v 1.1 2011/05/04 22:37:50 willuhn Exp $
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

import java.net.Authenticator;
import java.net.PasswordAuthentication;

import org.kapott.hbci.passport.AbstractPinTanPassport;
import org.kapott.hbci.passport.HBCIPassportInternal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PinTanProxyAuthenticator
		extends Authenticator
{
	/**
	 * The {@link Logger} to be used.
	 */
	private static final Logger logger = LoggerFactory.getLogger( PinTanProxyAuthenticator.class );

	private AbstractPinTanPassport passport;

	public PinTanProxyAuthenticator( HBCIPassportInternal passport )
	{
		this.passport = (AbstractPinTanPassport) passport;
	}

	protected PasswordAuthentication getPasswordAuthentication()
	{
		logger.debug( "need proxy authentication" );

		String user = passport.getProxyUser();
		String pass = passport.getProxyPass();

		logger.debug( "returning proxyuser from client.passport.PinTan.proxyuser" );
		logger.debug( "returning proxyuser from client.passport.PinTan.proxypass" );

		return new PasswordAuthentication( user, pass.toCharArray() );
	}

}
