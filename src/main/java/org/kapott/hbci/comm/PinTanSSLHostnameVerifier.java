
/*
 * $Id: PinTanSSLHostnameVerifier.java,v 1.1 2011/05/04 22:37:51 willuhn Exp $
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

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * modifizierter HostnameVerifier, der zum Einsatz kommt, wenn Zert.-Check
 * deaktiviert ist.
 */

public class PinTanSSLHostnameVerifier
		implements HostnameVerifier
{
	/**
	 * The {@link Logger} to be used.
	 */
	private static final Logger logger = LoggerFactory.getLogger( PinTanSSLHostnameVerifier.class );

	public boolean verify( String hostname, SSLSession session )
	{
		logger.debug( "cert checking disabled -> hostname always OK" );
		return true;
	}
}
