
/*
 * $Id: ThreadSyncer.java,v 1.1 2011/05/04 22:37:46 willuhn Exp $
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

import java.util.Hashtable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ThreadSyncer
{
	/**
	 * The {@link Logger} to be used.
	 */
	private static final Logger logger = LoggerFactory.getLogger( ThreadSyncer.class );

	private String name;
	private boolean waiting;
	private boolean notified;
	private boolean timeouted;
	private Hashtable<String, Object> data;

	public ThreadSyncer( String name )
	{
		this.name = name;
		this.waiting = false;
		this.notified = false;
		this.timeouted = false;
		this.data = new Hashtable<>();
	}

	public synchronized void startWaiting( long seconds, String errMsg )
	{
		try
		{
			if ( !notified )
			{
				logger.debug( "{}.startWaiting: !notified, waiting now", name );
				// wenn das notify() nicht schon vor dem wait() kam, dann
				// wirklich warten

				waiting = true;
				wait( seconds * 1000 );
				waiting = false;

				if ( !notified )
				{
					logger.debug( "{}.startWaiting: end of wait: !notified (timeouted)", name );
					// wenn das wait() wegen timeouted terminierte
					timeouted = true;
					throw new RuntimeException( name + ": " + errMsg );
				}
				logger.debug( "{}.startWaiting: end of wait: notified, normal end of wait", name );

				// damit ist alles wieder im ausgangszustand
				notified = false;
			}
			else
			{
				logger.debug( "{}.startWaiting: notified (notified before wait())", name );
				notified = false;
			}
		}
		catch ( Exception e )
		{
			throw new RuntimeException( e );
		}
	}

	public synchronized void stopWaiting()
	{
		logger.debug( "{}.stopWaiting", name );
		notified = true;
		if ( waiting )
		{
			logger.debug( "{}.stopWaiting: someone waits, so notify()", name );
			notify();
		}
		else
		{
			if ( timeouted )
			{
				logger.debug( "{}.stopWaiting: trying to awake a timeouted wait() - aborting", name );
				timeouted = false;
				throw new RuntimeException( name + ": can not awake a timeouted wait()" );
			}

			logger.debug( "{}.stopWaiting: no one waits, so we do nothing", name );
		}
	}

	public void setData( String key, Object obj )
	{
		if ( obj != null )
		{
			data.put( key, obj );
		}
		else
		{
			data.remove( key );
		}
	}

	public void clearData()
	{
		data.clear();
	}

	public Object getData( String key )
	{
		return data.get( key );
	}
}
