
/*
 * $Id: HBCIPassportRDH2File.java,v 1.1 2011/05/04 22:37:43 willuhn Exp $
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

import org.kapott.hbci.callback.HBCICallback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Compatibility class for old applications using "RDH2File" passport variant
 * 
 * @Deprecated Use RDHXFile instead
 */
public class HBCIPassportRDH2File
		extends HBCIPassportRDHXFile
{
	/**
	 * The {@link Logger} to be used.
	 */
	private static final Logger logger = LoggerFactory.getLogger( HBCIPassportRDH2File.class );

	protected String getCompatName()
	{
		logger.warn( "RDH2File should not be used any longer - use RDHXFile instead!" );
		return "RDH2File";
	}

	public HBCIPassportRDH2File( HBCICallback callback, Object initObject )
	{
		super( callback, initObject );
	}
}
