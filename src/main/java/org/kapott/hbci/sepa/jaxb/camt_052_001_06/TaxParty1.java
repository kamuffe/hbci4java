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
 * <p>Java-Klasse für TaxParty1 complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="TaxParty1"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="TaxId" type="{urn:iso:std:iso:20022:tech:xsd:camt.052.001.06}Max35Text" minOccurs="0"/&gt;
 *         &lt;element name="RegnId" type="{urn:iso:std:iso:20022:tech:xsd:camt.052.001.06}Max35Text" minOccurs="0"/&gt;
 *         &lt;element name="TaxTp" type="{urn:iso:std:iso:20022:tech:xsd:camt.052.001.06}Max35Text" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TaxParty1", propOrder = {
    "taxId",
    "regnId",
    "taxTp"
})
public class TaxParty1 {

    @XmlElement(name = "TaxId")
    protected String taxId;
    @XmlElement(name = "RegnId")
    protected String regnId;
    @XmlElement(name = "TaxTp")
    protected String taxTp;

    /**
     * Ruft den Wert der taxId-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTaxId() {
        return taxId;
    }

    /**
     * Legt den Wert der taxId-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTaxId(String value) {
        this.taxId = value;
    }

    /**
     * Ruft den Wert der regnId-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRegnId() {
        return regnId;
    }

    /**
     * Legt den Wert der regnId-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRegnId(String value) {
        this.regnId = value;
    }

    /**
     * Ruft den Wert der taxTp-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTaxTp() {
        return taxTp;
    }

    /**
     * Legt den Wert der taxTp-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTaxTp(String value) {
        this.taxTp = value;
    }

}
