
/*
 * $Id: HBCIPassportRDH.java,v 1.1 2011/05/04 22:37:42 willuhn Exp $
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

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StreamCorruptedException;
import java.security.interfaces.RSAPrivateCrtKey;
import java.util.Properties;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.spec.PBEParameterSpec;

import org.kapott.hbci.callback.HBCICallback;
import org.kapott.hbci.exceptions.HBCI_Exception;
import org.kapott.hbci.exceptions.InvalidPassphraseException;
import org.kapott.hbci.manager.HBCIKey;
import org.kapott.hbci.manager.HBCIUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>
 * <em><b>Veraltete</b></em> Passport-Klasse für RDH-Zugänge mit Sicherheitsmedium "Datei".
 * Diese Klasse sollte nicht mehr benutzt werden, sondern statt dessen die Klasse
 * {@link org.kapott.hbci.passport.HBCIPassportRDHNew}.
 * RDH-Passport-Datei können mit dem Tool
 * {@link org.kapott.hbci.tools.ConvertRDHPassport} oder
 * mit Hilfe des separat verfügbaren <em>HBCI4Java Passport Editors</em>
 * in RDHNew-Passport-Dateien umgewandelt werden. Siehe dazu auch die Daten
 * <code>README.RDHNew</code>
 * </p>
 * <p>
 * Das API dieser Klasse ist identisch zu dem der Klasse
 * {@link org.kapott.hbci.passport.HBCIPassportRDHNew}. Siehe
 * Beschreibung dort.
 * </p>
 * .
 */
public class HBCIPassportRDH
		extends AbstractRDHSWFileBasedPassport
{
	/**
	 * The {@link Logger} to be used.
	 */
	private static final Logger logger = LoggerFactory.getLogger( HBCIPassportRDH.class );

	public HBCIPassportRDH( HBCICallback callback, Object init, int dummy )
	{
		super( callback, init );
		setParamHeader( "client.passport.RDH" );
	}

	public HBCIPassportRDH( HBCICallback callback, Object initObject )
	{
		this( callback, initObject, 0 );

		String header = getParamHeader();
		String fname = HBCIUtils.getParam( header + ".filename" );
		boolean init = HBCIUtils.getParam( header + ".init", "1" ).equals( "1" );

		if ( fname == null )
		{
			throw new NullPointerException( header + ".filename must not be null" );
		}

		logger.debug( "loading passport data from file {}", fname );
		setFilename( fname );

		if ( init )
		{
			logger.debug( "loading data from file {}", fname );

			setFilterType( "None" );
			setPort( new Integer( 3000 ) );

			if ( !new File( fname ).canRead() )
			{
				logger.warn( "have to create new passport file" );
				askForMissingData( true, true, true, true, false, true, true );
				saveChanges();
			}

			ObjectInputStream o = null;
			try
			{
				int retries = getRetries();

				while ( true )
				{ // loop for entering the correct passphrase
					if ( getPassportKey() == null )
						setPassportKey( calculatePassportKey( FOR_LOAD ) );

					PBEParameterSpec paramspec = new PBEParameterSpec( CIPHER_SALT, CIPHER_ITERATIONS );
					String provider = HBCIUtils.getParam( "kernel.security.provider" );
					Cipher cipher = provider == null ? Cipher.getInstance( "PBEWithMD5AndDES" ) : Cipher.getInstance( "PBEWithMD5AndDES", provider );
					cipher.init( Cipher.DECRYPT_MODE, getPassportKey(), paramspec );

					o = null;
					try
					{
						o = new ObjectInputStream( new CipherInputStream( new FileInputStream( fname ), cipher ) );
					}
					catch ( StreamCorruptedException e )
					{
						setPassportKey( null );

						retries--;
						if ( retries <= 0 )
							throw new InvalidPassphraseException();
					}

					if ( o != null )
						break;
				}

				setCountry( (String) (o.readObject()) );
				setBLZ( (String) (o.readObject()) );
				setHost( (String) (o.readObject()) );
				setPort( (Integer) (o.readObject()) );
				setUserId( (String) (o.readObject()) );
				setSysId( (String) (o.readObject()) );
				setSigId( (Long) (o.readObject()) );
				setBPD( (Properties) (o.readObject()) );
				setUPD( (Properties) (o.readObject()) );

				for ( int i = 0; i < 3; i++ )
				{
					for ( int j = 0; j < 2; j++ )
					{
						setKey( i, j, (HBCIKey) (o.readObject()) );
					}
				}

				setCID( (String) (o.readObject()) );
				setHBCIVersion( (String) o.readObject() );
				setCustomerId( (String) o.readObject() );

				HBCIKey k = getMyPrivateSigKey();
				if ( k != null && k.key != null && !(k.key instanceof RSAPrivateCrtKey) )
				{
					logger.warn( "private sig key is no CRT key, please contact the author!" );
				}

				k = getMyPrivateEncKey();
				if ( k != null && k.key != null && !(k.key instanceof RSAPrivateCrtKey) )
				{
					logger.warn( "private enc key is no CRT key, please contact the author!" );
				}
			}
			catch ( Exception e )
			{
				throw new HBCI_Exception( "*** loading of passport file failed", e );
			}

			try
			{
				o.close();
			}
			catch ( Exception e )
			{
				logger.error( "An error occurred.", e );
			}

			if ( askForMissingData( true, true, true, true, false, true, true ) )
				saveChanges();
		}
	}

	public void saveChanges()
	{
		try
		{
			if ( getPassportKey() == null )
				setPassportKey( calculatePassportKey( FOR_SAVE ) );

			PBEParameterSpec paramspec = new PBEParameterSpec( CIPHER_SALT, CIPHER_ITERATIONS );
			String provider = HBCIUtils.getParam( "kernel.security.provider" );
			Cipher cipher = provider == null ? Cipher.getInstance( "PBEWithMD5AndDES" ) : Cipher.getInstance( "PBEWithMD5AndDES", provider );
			cipher.init( Cipher.ENCRYPT_MODE, getPassportKey(), paramspec );

			File passportfile = new File( getFilename() );
			File directory = passportfile.getAbsoluteFile().getParentFile();
			String prefix = passportfile.getName() + "_";
			File tempfile = File.createTempFile( prefix, "", directory );

			ObjectOutputStream o = new ObjectOutputStream( new CipherOutputStream( new FileOutputStream( tempfile ), cipher ) );

			o.writeObject( getCountry() );
			o.writeObject( getBLZ() );
			o.writeObject( getHost() );
			o.writeObject( getPort() );
			o.writeObject( getUserId() );
			o.writeObject( getSysId() );
			o.writeObject( getSigId() );
			o.writeObject( getBPD() );
			o.writeObject( getUPD() );

			for ( int i = 0; i < 3; i++ )
			{
				for ( int j = 0; j < 2; j++ )
				{
					HBCIKey key = getKey( i, j );

					if ( key != null )
					{
						o.writeObject( new HBCIKey( key.country, key.blz, key.userid, key.num, key.version, key.key ) );
					}
					else
						o.writeObject( null );
				}
			}

			o.writeObject( getCID() );
			o.writeObject( getHBCIVersion() );
			o.writeObject( getCustomerId() );

			o.close();

			this.safeReplace( passportfile, tempfile );

			HBCIKey k = getMyPrivateSigKey();
			if ( k != null && k.key != null && !(k.key instanceof RSAPrivateCrtKey) )
			{
				logger.warn( "private sig key is no CRT key, please contact the author!" );
			}

			k = getMyPrivateEncKey();
			if ( k != null && k.key != null && !(k.key instanceof RSAPrivateCrtKey) )
			{
				logger.warn( "private enc key is no CRT key, please contact the author!" );
			}
		}
		catch ( Exception e )
		{
			throw new HBCI_Exception( "*** saving of passport file failed", e );
		}
	}

	public String getProfileVersion()
	{
		// old RDH format can only be used for profile RDH-1
		return "1";
	}
}
