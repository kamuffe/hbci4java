package org.kapott.hbci.concurrent;

import java.util.Properties;

import org.kapott.hbci.callback.HBCICallback;
import org.kapott.hbci.manager.HBCIHandler;
import org.kapott.hbci.manager.HBCIUtils;
import org.kapott.hbci.passport.HBCIPassport;
import org.kapott.hbci.security.Sig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Basis-Klasse für Implementierungen von {@link Runnable}, die typische Aufgaben mit einem {@link HBCIPassport}
 * ausführen sollen.
 *
 * <p>
 * Implementierungen müssen die Methode {@link #execute()} ergänzen.
 * </p>
 *
 * <p>
 * Bei Ausführung einer solchen {@link Runnable} passiert folgendes:
 * </p>
 *
 * <ol>
 * <li>{@link HBCIUtils.initThread(properties, callback)} wird mit den Parametern aus dem Constructor aufgerufen.</li>
 * <li>Das Passport wird von der {@link HBCIPassportFactory} abgefragt und darüber wird der {@link HBCIHandler} erzeugt.</li>
 * <li>{@link #execute()} wird aufgerufen.</li>
 * {@link HBCIPassport} und {@link HBCIHandler} sind über die Variablen <code>passport</code> bzw. <code>handler</code> verfügbar.</li>
 * <li>Abschließend werden Handler und Passport geschlossen, sowie {@link HBCIUtils#doneThread()} aufgerufen.</li>
 * </ol>
 *
 * @author Hendrik Schnepel
 */
public abstract class HBCIRunnable
		implements Runnable
{
	/**
	 * The {@link Logger} to be used.
	 */
	private static final Logger logger = LoggerFactory.getLogger( HBCIRunnable.class );

	private final Properties properties;
	private final HBCICallback callback;
	private HBCIPassportFactory passportFactory;

	protected HBCIPassport passport = null;
	protected HBCIHandler handler = null;

	public HBCIRunnable( Properties properties, HBCICallback callback, HBCIPassportFactory passportFactory )
	{
		this.properties = properties;
		this.callback = callback;
		this.passportFactory = passportFactory;
	}

	@Override
	public final void run()
	{
		init();
		try
		{
			prepare();
			execute();
		}
		catch ( Exception e )
		{
			logger.error( "An error occurred.", e );
		}
		finally
		{
			done();
		}
	}

	private void init()
	{
//        HBCIUtils.initThread(properties);
	}

	private void prepare()
			throws Exception
	{
		passport = passportFactory.createPassport();
		if ( passport != null )
		{
			String version = passport.getHBCIVersion();
			handler = new HBCIHandler( passport );
		}
	}

	protected abstract void execute()
			throws Exception;

	private void done()
	{
		if ( handler != null )
		{
			handler.close();
		}
		if ( passport != null )
		{
			passport.close();
		}
//        HBCIUtils.doneThread();
	}

}
