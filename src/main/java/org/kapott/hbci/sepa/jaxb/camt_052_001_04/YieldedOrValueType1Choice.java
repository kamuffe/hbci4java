//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2019.06.19 um 02:06:59 PM CEST 
//


package org.kapott.hbci.sepa.jaxb.camt_052_001_04;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für YieldedOrValueType1Choice complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="YieldedOrValueType1Choice"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;choice&gt;
 *         &lt;element name="Yldd" type="{urn:iso:std:iso:20022:tech:xsd:camt.052.001.04}YesNoIndicator"/&gt;
 *         &lt;element name="ValTp" type="{urn:iso:std:iso:20022:tech:xsd:camt.052.001.04}PriceValueType1Code"/&gt;
 *       &lt;/choice&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "YieldedOrValueType1Choice", propOrder = {
    "yldd",
    "valTp"
})
public class YieldedOrValueType1Choice {

    @XmlElement(name = "Yldd")
    protected Boolean yldd;
    @XmlElement(name = "ValTp")
    @XmlSchemaType(name = "string")
    protected PriceValueType1Code valTp;

    /**
     * Ruft den Wert der yldd-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isYldd() {
        return yldd;
    }

    /**
     * Legt den Wert der yldd-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setYldd(Boolean value) {
        this.yldd = value;
    }

    /**
     * Ruft den Wert der valTp-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PriceValueType1Code }
     *     
     */
    public PriceValueType1Code getValTp() {
        return valTp;
    }

    /**
     * Legt den Wert der valTp-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PriceValueType1Code }
     *     
     */
    public void setValTp(PriceValueType1Code value) {
        this.valTp = value;
    }

}
