package org.kapott.hbci4java.bpd;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Properties;
import java.util.Set;
import java.util.StringTokenizer;

import org.junit.Assert;
import org.junit.Test;
import org.kapott.hbci.manager.HBCIKernelImpl;
import org.kapott.hbci.manager.HBCIUtils;
import org.kapott.hbci.manager.HBCIVersion;
import org.kapott.hbci.manager.IHandlerData;
import org.kapott.hbci.manager.MsgGen;
import org.kapott.hbci.passport.HBCIPassport;
import org.kapott.hbci.passport.HBCIPassportPinTan;
import org.kapott.hbci.protocol.MSG;
import org.kapott.hbci.protocol.factory.MSGFactory;
import org.kapott.hbci.rewrite.Rewrite;
import org.kapott.hbci4java.AbstractTest;

/**
 * Testet die erlaubten Geschaeftsvorfaelle.
 */
public class AllowedGVTest extends AbstractTest
{

  /**
   * @throws Exception
   */
  @Test
  public void test() throws Exception
  {
    String data = getFile("bpd-allowedgv.txt");
    
    IHandlerData handlerData = new IHandlerData() {

		@Override
		public HBCIPassport getPassport()
		{
			
			HBCIPassportPinTan passport = new HBCIPassportPinTan(null, null);
			passport.setHBCIVersion( HBCIVersion.HBCI_PLUS.getId() );
			return passport;
		}

		@Override
		public MsgGen getMsgGen()
		{
			// TODO Auto-generated method stub
			return null;
		}
    	
    };
    HBCIKernelImpl kernel = new HBCIKernelImpl(handlerData);

    Rewrite.setData("msgName", "Synch");
    // liste der rewriter erzeugen
    String rewriters_st = HBCIUtils.getParam("kernel.rewriter");
    ArrayList<Rewrite> al = new ArrayList<Rewrite>();
    StringTokenizer tok = new StringTokenizer(rewriters_st, ",");
    while (tok.hasMoreTokens())
    {
      String rewriterName = tok.nextToken().trim();
      if (rewriterName.length() != 0)
      {
        Class cl = this.getClass().getClassLoader().loadClass("org.kapott.hbci.rewrite.R" + rewriterName);
        Constructor con = cl.getConstructor((Class[]) null);
        Rewrite rewriter = (Rewrite) (con.newInstance((Object[]) null));
        al.add(rewriter);
      }
    }
    Rewrite[] rewriters = al.toArray(new Rewrite[al.size()]);

    kernel.rawNewMsg("Synch");

    MsgGen gen = kernel.getMsgGen();

    // alle patches f¸r die unverschl¸sselte nachricht durchlaufen
    String newmsgstring = data;
    for (int i = 0; i < rewriters.length; i++)
    {
      newmsgstring = rewriters[i].incomingClearText(newmsgstring, gen);
    }

    MSG msg = MSGFactory.getInstance().createMSG("SynchRes", newmsgstring, newmsgstring.length(), gen);
    Hashtable<String, String> ht = new Hashtable<String, String>();
    msg.extractValues(ht);
  }

  /**
   * @throws Exception
   */
  @Test
  public void test2() throws Exception
  {
    String data = getFile("bpd-allowedgv2.txt");
    
    IHandlerData handlerData = new IHandlerData() {

		@Override
		public HBCIPassport getPassport()
		{
			
			HBCIPassportPinTan passport = new HBCIPassportPinTan(null, null);
			return passport;
		}

		@Override
		public MsgGen getMsgGen()
		{
			// TODO Auto-generated method stub
			return null;
		}
    	
    };
    HBCIKernelImpl kernel = new HBCIKernelImpl(handlerData);

    Rewrite.setData("msgName", "Synch");
    // liste der rewriter erzeugen
    String rewriters_st = HBCIUtils.getParam("kernel.rewriter");
    ArrayList<Rewrite> al = new ArrayList<Rewrite>();
    StringTokenizer tok = new StringTokenizer(rewriters_st, ",");
    while (tok.hasMoreTokens())
    {
      String rewriterName = tok.nextToken().trim();
      if (rewriterName.length() != 0)
      {
        Class cl = this.getClass().getClassLoader().loadClass("org.kapott.hbci.rewrite.R" + rewriterName);
        Constructor con = cl.getConstructor((Class[]) null);
        Rewrite rewriter = (Rewrite) (con.newInstance((Object[]) null));
        al.add(rewriter);
      }
    }
    Rewrite[] rewriters = al.toArray(new Rewrite[al.size()]);

    kernel.rawNewMsg("Synch");

    MsgGen gen = kernel.getMsgGen();

    // alle patches f¸r die unverschl¸sselte nachricht durchlaufen
    String newmsgstring = data;
    for (int i = 0; i < rewriters.length; i++)
    {
      newmsgstring = rewriters[i].incomingClearText(newmsgstring, gen);
    }

    MSG msg = MSGFactory.getInstance().createMSG("SynchRes", newmsgstring, newmsgstring.length(), gen);
    Hashtable<String, String> ht = new Hashtable<String, String>();
    msg.extractValues(ht);

    Properties upd = new Properties();
    for (String key : ht.keySet())
    {
      if (key.startsWith("SynchRes.UPD.") && key.contains(".code"))
      {
        String value = ht.get(key);
        key = key.replace("SynchRes.UPD.", "");
        upd.put(key, value);
      }
    }

    Set keys = upd.keySet();
    Assert.assertEquals(keys.contains("KInfo.AllowedGV_2.code"), true);
  }
}
