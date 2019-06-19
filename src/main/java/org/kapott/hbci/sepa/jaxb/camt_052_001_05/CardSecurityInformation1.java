//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2019.06.19 um 02:06:59 PM CEST 
//


package org.kapott.hbci.sepa.jaxb.camt_052_001_05;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für CardSecurityInformation1 complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CardSecurityInformation1"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="CSCMgmt" type="{urn:iso:std:iso:20022:tech:xsd:camt.052.001.05}CSCManagement1Code"/&gt;
 *         &lt;element name="CSCVal" type="{urn:iso:std:iso:20022:tech:xsd:camt.052.001.05}Min3Max4NumericText" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CardSecurityInformation1", propOrder = {
    "cscMgmt",
    "cscVal"
})
public class CardSecurityInformation1 {

    @XmlElement(name = "CSCMgmt", required = true)
    @XmlSchemaType(name = "string")
    protected CSCManagement1Code cscMgmt;
    @XmlElement(name = "CSCVal")
    protected String cscVal;

    /**
     * Ruft den Wert der cscMgmt-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CSCManagement1Code }
     *     
     */
    public CSCManagement1Code getCSCMgmt() {
        return cscMgmt;
    }

    /**
     * Legt den Wert der cscMgmt-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CSCManagement1Code }
     *     
     */
    public void setCSCMgmt(CSCManagement1Code value) {
        this.cscMgmt = value;
    }

    /**
     * Ruft den Wert der cscVal-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCSCVal() {
        return cscVal;
    }

    /**
     * Legt den Wert der cscVal-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCSCVal(String value) {
        this.cscVal = value;
    }

}
