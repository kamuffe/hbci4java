//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2019.06.19 um 02:07:01 PM CEST 
//


package org.kapott.hbci.sepa.jaxb.pain_002_001_03;

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
 *         &lt;element name="CstmrPmtStsRpt" type="{urn:iso:std:iso:20022:tech:xsd:pain.002.001.03}CustomerPaymentStatusReportV03"/&gt;
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
    "cstmrPmtStsRpt"
})
public class Document {

    @XmlElement(name = "CstmrPmtStsRpt", required = true)
    protected CustomerPaymentStatusReportV03 cstmrPmtStsRpt;

    /**
     * Ruft den Wert der cstmrPmtStsRpt-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CustomerPaymentStatusReportV03 }
     *     
     */
    public CustomerPaymentStatusReportV03 getCstmrPmtStsRpt() {
        return cstmrPmtStsRpt;
    }

    /**
     * Legt den Wert der cstmrPmtStsRpt-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CustomerPaymentStatusReportV03 }
     *     
     */
    public void setCstmrPmtStsRpt(CustomerPaymentStatusReportV03 value) {
        this.cstmrPmtStsRpt = value;
    }

}
