//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2019.06.19 um 02:06:59 PM CEST 
//


package org.kapott.hbci.sepa.jaxb.camt_052_001_03;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java-Klasse für DateTimePeriodDetails complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="DateTimePeriodDetails"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="FrDtTm" type="{urn:iso:std:iso:20022:tech:xsd:camt.052.001.03}ISODateTime"/&gt;
 *         &lt;element name="ToDtTm" type="{urn:iso:std:iso:20022:tech:xsd:camt.052.001.03}ISODateTime"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DateTimePeriodDetails", propOrder = {
    "frDtTm",
    "toDtTm"
})
public class DateTimePeriodDetails {

    @XmlElement(name = "FrDtTm", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar frDtTm;
    @XmlElement(name = "ToDtTm", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar toDtTm;

    /**
     * Ruft den Wert der frDtTm-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFrDtTm() {
        return frDtTm;
    }

    /**
     * Legt den Wert der frDtTm-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFrDtTm(XMLGregorianCalendar value) {
        this.frDtTm = value;
    }

    /**
     * Ruft den Wert der toDtTm-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getToDtTm() {
        return toDtTm;
    }

    /**
     * Legt den Wert der toDtTm-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setToDtTm(XMLGregorianCalendar value) {
        this.toDtTm = value;
    }

}
