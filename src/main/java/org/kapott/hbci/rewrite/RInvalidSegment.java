
/*
 * $Id: RInvalidSegment.java,v 1.1 2011/05/04 22:37:57 willuhn Exp $
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

package org.kapott.hbci.rewrite;

import org.kapott.hbci.manager.MsgGen;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RInvalidSegment
		extends Rewrite
{
	/**
	 * The {@link Logger} to be used.
	 */
	private static final Logger logger = LoggerFactory.getLogger( RInvalidSegment.class );

	// TODO: msgsize muss angepasst werden
	public String incomingClearText( String st, MsgGen gen )
	{
		StringBuffer sb = new StringBuffer( st );

		int idx = sb.indexOf( "'IIDIA:" );
		if ( idx != -1 )
		{
			int idx2 = sb.indexOf( "'", idx + 1 );
			logger.warn( "removing invalid segment '" + sb.substring( idx + 1, idx2 + 1 ) + "'" );
			sb.delete( idx + 1, idx2 + 1 );
		}

		return sb.toString();
	}
}
