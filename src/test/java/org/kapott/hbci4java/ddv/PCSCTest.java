package org.kapott.hbci4java.ddv;

import java.io.File;
import java.util.Properties;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assume;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.kapott.hbci.GV.GVSaldoReq;
import org.kapott.hbci.GV.HBCIJob;
import org.kapott.hbci.callback.HBCICallbackConsole;
import org.kapott.hbci.manager.HBCIHandler;
import org.kapott.hbci.manager.HBCIUtils;
import org.kapott.hbci.manager.HBCIVersion;
import org.kapott.hbci.manager.IHandlerData;
import org.kapott.hbci.manager.MsgGen;
import org.kapott.hbci.passport.AbstractHBCIPassport;
import org.kapott.hbci.passport.HBCIPassport;
import org.kapott.hbci.passport.HBCIPassportDDVPCSC;
import org.kapott.hbci.passport.HBCIPassportPinTan;
import org.kapott.hbci4java.AbstractTest;

/**
 * Testet den Zugriff auf eine Chipkarte via javax.smartcardio
 */
public class PCSCTest extends AbstractTest
{
  private static File dir = null;
  HBCIPassportDDVPCSC passport = null;
  
  /**
   * Deaktiviert den Test, wenn das System-Property nicht auf "true" steht.
   * @throws Exception
   */
  @BeforeClass
  public static void beforeClass() throws Exception
  {
      Assume.assumeTrue(Boolean.getBoolean(AbstractTest.SYSPROP_CHIPCARD));
  }

  /**
   * List die Daten aus der Karte.
   * @throws Exception
   */
  @Test
  public void testReadCardData() throws Exception
  {
    System.out.println("card id: " + passport.getCardId());
    System.out.println("user id: " + passport.getUserId());
    System.out.println("blz    : " + passport.getBLZ());
    System.out.println("host   : " + passport.getHost());
  }
  
  /**
   * Testet das Abrufen des Saldos.
   * @throws Exception
   */
  @Test
  public void testFetchSaldo() throws Exception
  {
	    IHandlerData handlerData = new IHandlerData() {

			@Override
			public HBCIPassport getPassport()
			{
				
				HBCIPassportPinTan passport = new HBCIPassportPinTan(null, null);
				passport.setHBCIVersion( HBCIVersion.HBCI_210.getId() );
				return passport;
			}

			@Override
			public MsgGen getMsgGen()
			{
				// TODO Auto-generated method stub
				return null;
			}
	    	
	    };
    HBCIHandler handler = new HBCIHandler(passport);
    HBCIJob job = new GVSaldoReq(handler);
    
    // wir nehmen wir die Saldo-Abfrage einfach das erste verfuegbare Konto
    job.setParam("my",passport.getAccounts().get( 0 ));
    job.addToQueue();
    handler.execute();
  }
  
  /**
   * Erzeugt das Passport-Objekt.
   * @throws Exception
   */
  @Before
  public void beforeCard() throws Exception
  {
    HBCIUtils.setParam("client.passport.DDV.path",dir.getAbsolutePath() + "/");
    HBCIUtils.setParam("client.passport.DDV.entryidx","1");

    this.passport = (HBCIPassportDDVPCSC) AbstractHBCIPassport.getInstance(HBCIPassportDDVPCSC.class,new HBCICallbackConsole());
  }
  
  /**
   * Schliesst das Passport-Objekt.
   * @throws Exception
   */
  @After
  public void afterCard() throws Exception
  {
    try
    {
      if (this.passport != null)
        this.passport.close();
    }
    finally
    {
//      HBCIUtils.done();
    }
  }
  
  /**
   * Erzeugt das Passport-Verzeichnis.
   * @throws Exception
   */
  @BeforeClass
  public static void beforeCardClass() throws Exception
  {
    String tmpDir = System.getProperty("java.io.tmpdir","/tmp");
    dir = new File(tmpDir,"ddvjava");
    dir.mkdirs();
  }
  
  /**
   * Loescht das Passport-Verzeichnis.
   * @throws Exception
   */
  @AfterClass
  public static void afterCardClass() throws Exception
  {
    dir = null;
    // TODO: Verzeichnis und Inhalt muesste mal noch geloescht werden.
  }
}
