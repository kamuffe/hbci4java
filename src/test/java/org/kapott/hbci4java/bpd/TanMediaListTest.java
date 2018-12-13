package org.kapott.hbci4java.bpd;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.StringTokenizer;

import org.junit.Test;
import org.kapott.hbci.manager.HBCIKernelImpl;
import org.kapott.hbci.manager.HBCIUtils;
import org.kapott.hbci.manager.IHandlerData;
import org.kapott.hbci.manager.MsgGen;
import org.kapott.hbci.passport.HBCIPassport;
import org.kapott.hbci.passport.HBCIPassportPinTan;
import org.kapott.hbci.protocol.MSG;
import org.kapott.hbci.protocol.factory.MSGFactory;
import org.kapott.hbci.rewrite.Rewrite;
import org.kapott.hbci4java.AbstractTest;

/**
 * Testet das Empfangen der TAN-Medienliste.
 */
public class TanMediaListTest extends AbstractTest
{

  /**
   * @throws Exception
   */
  @Test
  public void test() throws Exception
  {
    String data = getFile("bpd-tanmedialist.txt");
    
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

    Rewrite.setData("msgName", "CustomMsg");
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

    kernel.rawNewMsg("CustomMsg");

    MsgGen gen = kernel.getMsgGen();

    // alle patches für die unverschlüsselte nachricht durchlaufen
    String newmsgstring = data;

    for (int i = 0; i < rewriters.length; i++)
    {
      newmsgstring = rewriters[i].incomingClearText(newmsgstring, gen);
    }

    MSG msg = MSGFactory.getInstance().createMSG("CustomMsgRes", newmsgstring, newmsgstring.length(), gen);
    Hashtable<String, String> ht = new Hashtable<String, String>();
    msg.extractValues(ht);
  }

}
