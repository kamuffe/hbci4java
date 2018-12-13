package org.kapott.hbci4java.sepa;

import java.util.Properties;

import org.junit.Test;
import org.kapott.hbci.GV.GVTermUebSEPAList;
import org.kapott.hbci.GV.HBCIJob;
import org.kapott.hbci.manager.HBCIHandler;
import org.kapott.hbci.passport.HBCIPassport;
import org.kapott.hbci4java.AbstractTestGV;



/**
 * Testet das Abrufen der Liste der SEPA-Termin-Ueberweisungen.
 */
public class TestGVTermUebSEPAList extends AbstractTestGV
{
    /**
     * Testet das Abrufen der Liste der SEPA-Termin-Ueberweisungen.
     */
    @Test
    public void test()
    {
        this.execute(new Execution() {
            @Override
            public HBCIJob getJob(HBCIHandler handler) {
                return new GVTermUebSEPAList(handler);
            }
            
            /**
             * @see org.kapott.hbci4java.AbstractTestGV.Execution#configure(org.kapott.hbci.GV.HBCIJob, org.kapott.hbci.passport.HBCIPassport, java.util.Properties)
             */
            @Override
            public void configure(HBCIJob job, HBCIPassport passport, Properties params) {
                super.configure(job, passport, params);
                job.setParam("my.bic",params.getProperty("bic",System.getProperty("bic")));
                job.setParam("my.iban",params.getProperty("iban",System.getProperty("iban")));
            }
        });
    }
}
