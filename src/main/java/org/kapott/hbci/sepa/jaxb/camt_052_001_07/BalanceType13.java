//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2019.06.19 um 02:06:57 PM CEST 
//


package org.kapott.hbci.sepa.jaxb.camt_052_001_07;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für BalanceType13 complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="BalanceType13"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="CdOrPrtry" type="{urn:iso:std:iso:20022:tech:xsd:camt.052.001.07}BalanceType10Choice"/&gt;
 *         &lt;element name="SubTp" type="{urn:iso:std:iso:20022:tech:xsd:camt.052.001.07}BalanceSubType1Choice" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BalanceType13", propOrder = {
    "cdOrPrtry",
    "subTp"
})
public class BalanceType13 {

    @XmlElement(name = "CdOrPrtry", required = true)
    protected BalanceType10Choice cdOrPrtry;
    @XmlElement(name = "SubTp")
    protected BalanceSubType1Choice subTp;

    /**
     * Ruft den Wert der cdOrPrtry-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link BalanceType10Choice }
     *     
     */
    public BalanceType10Choice getCdOrPrtry() {
        return cdOrPrtry;
    }

    /**
     * Legt den Wert der cdOrPrtry-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link BalanceType10Choice }
     *     
     */
    public void setCdOrPrtry(BalanceType10Choice value) {
        this.cdOrPrtry = value;
    }

    /**
     * Ruft den Wert der subTp-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link BalanceSubType1Choice }
     *     
     */
    public BalanceSubType1Choice getSubTp() {
        return subTp;
    }

    /**
     * Legt den Wert der subTp-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link BalanceSubType1Choice }
     *     
     */
    public void setSubTp(BalanceSubType1Choice value) {
        this.subTp = value;
    }

}
