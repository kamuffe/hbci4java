//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2019.06.19 um 02:07:00 PM CEST 
//


package org.kapott.hbci.sepa.jaxb.camt_052_001_01;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für ChargeTypeChoice complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="ChargeTypeChoice"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;choice&gt;
 *           &lt;element name="Cd" type="{urn:iso:std:iso:20022:tech:xsd:camt.052.001.01}ChargeType1Code"/&gt;
 *           &lt;element name="PrtryCd" type="{urn:iso:std:iso:20022:tech:xsd:camt.052.001.01}Max4AlphaNumericText"/&gt;
 *         &lt;/choice&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ChargeTypeChoice", propOrder = {
    "cd",
    "prtryCd"
})
public class ChargeTypeChoice {

    @XmlElement(name = "Cd")
    @XmlSchemaType(name = "string")
    protected ChargeType1Code cd;
    @XmlElement(name = "PrtryCd")
    protected String prtryCd;

    /**
     * Ruft den Wert der cd-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ChargeType1Code }
     *     
     */
    public ChargeType1Code getCd() {
        return cd;
    }

    /**
     * Legt den Wert der cd-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ChargeType1Code }
     *     
     */
    public void setCd(ChargeType1Code value) {
        this.cd = value;
    }

    /**
     * Ruft den Wert der prtryCd-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrtryCd() {
        return prtryCd;
    }

    /**
     * Legt den Wert der prtryCd-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrtryCd(String value) {
        this.prtryCd = value;
    }

}
