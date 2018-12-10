
/*
 * $Id: HBCIUtilsInternal.java,v 1.1 2011/05/04 22:37:47 willuhn Exp $
 * This file is part of hbci4java
 * Copyright (C) 2001-2008 Stefan Palme
 * hbci4java is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 * hbci4java is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
 */

package org.kapott.hbci.manager;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.MessageFormat;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import org.kapott.hbci.callback.HBCICallback;
import org.kapott.hbci.passport.HBCIPassport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HBCIUtilsInternal
{

	/**
	 * The {@link Logger} to be used.
	 */
	private static final Logger logger = LoggerFactory.getLogger( HBCIUtilsInternal.class );

	

	public static String bigDecimal2String( BigDecimal value )
	{
		DecimalFormat format = new DecimalFormat( "0.##" );
		DecimalFormatSymbols symbols = format.getDecimalFormatSymbols();
		symbols.setDecimalSeparator( '.' );
		format.setDecimalFormatSymbols( symbols );
		format.setDecimalSeparatorAlwaysShown( false );
		return format.format( value );
	}



	public static boolean ignoreError( HBCIPassport passport, String paramName, String msg )
	{
		boolean ret = false;
		String paramValue = HBCIUtils.getParam( paramName, "no" );

		if ( paramValue.equals( "yes" ) )
		{
			logger.error( msg );
			logger.error( "ignoring error because param " + paramName + "=yes" );
			ret = true;
		}
		else if ( paramValue.equals( "callback" ) )
		{
			StringBuffer sb = new StringBuffer();
			passport.getCallback().callback( passport,
					HBCICallback.HAVE_ERROR,
					msg,
					HBCICallback.TYPE_BOOLEAN,
					sb );
			if ( sb.length() == 0 )
			{
				logger.error( msg );
				logger.error( "ignoring error because param " + paramName + "=callback" );
				ret = true;
			}
		}

		return ret;
	}

	public static long string2Long( String st, long factor )
	{
		BigDecimal result = new BigDecimal( st );
		result = result.multiply( new BigDecimal( factor ) );
		return result.longValue();
	}

	public static String withCounter( String st, int idx )
	{
		return st + ((idx != 0) ? "_" + Integer.toString( idx + 1 ) : "");
	}

	public static int getPosiOfNextDelimiter( String st, int posi )
	{
		int len = st.length();
		boolean quoting = false;
		while ( posi < len )
		{
			char ch = st.charAt( posi );

			if ( !quoting )
			{
				if ( ch == '?' )
				{
					quoting = true;
				}
				else if ( ch == '@' )
				{
					int endpos = st.indexOf( '@', posi + 1 );
					String binlen_st = st.substring( posi + 1, endpos );
					int binlen = Integer.parseInt( binlen_st );
					posi += binlen_st.length() + 1 + binlen;
				}
				else if ( ch == '\'' || ch == '+' || ch == ':' )
				{
					// Ende gefunden
					break;
				}
			}
			else
			{
				quoting = false;
			}

			posi++;
		}

		return posi;
	}

	public static String ba2string( byte[] ba )
	{
		StringBuffer ret = new StringBuffer();

		for ( int i = 0; i < ba.length; i++ )
		{
			int x = ba[i];
			if ( x < 0 )
			{
				x += 256;
			}
			String st = Integer.toString( x, 16 );
			if ( st.length() == 1 )
			{
				st = "0" + st;
			}
			ret.append( st + " " );
		}

		return ret.toString();

	}

	public static String stripLeadingZeroes( String st )
	{
		String ret = null;

		if ( st != null )
		{
			int start = 0;
			int l = st.length();
			while ( start < l && st.charAt( start ) == '0' )
			{
				start++;
			}
			ret = st.substring( start );
		}

		return ret;
	}

}
