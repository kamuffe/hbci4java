//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2019.06.19 um 02:06:58 PM CEST 
//


package org.kapott.hbci.sepa.jaxb.camt_052_001_06;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für Document complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="Document"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="BkToCstmrAcctRpt" type="{urn:iso:std:iso:20022:tech:xsd:camt.052.001.06}BankToCustomerAccountReportV06"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Document", propOrder = {
    "bkToCstmrAcctRpt"
})
public class Document {

    @XmlElement(name = "BkToCstmrAcctRpt", required = true)
    protected BankToCustomerAccountReportV06 bkToCstmrAcctRpt;

    /**
     * Ruft den Wert der bkToCstmrAcctRpt-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link BankToCustomerAccountReportV06 }
     *     
     */
    public BankToCustomerAccountReportV06 getBkToCstmrAcctRpt() {
        return bkToCstmrAcctRpt;
    }

    /**
     * Legt den Wert der bkToCstmrAcctRpt-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link BankToCustomerAccountReportV06 }
     *     
     */
    public void setBkToCstmrAcctRpt(BankToCustomerAccountReportV06 value) {
        this.bkToCstmrAcctRpt = value;
    }

}
