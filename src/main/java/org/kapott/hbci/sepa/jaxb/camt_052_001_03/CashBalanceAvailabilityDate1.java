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
 * <p>Java-Klasse für CashBalanceAvailabilityDate1 complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CashBalanceAvailabilityDate1"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;choice&gt;
 *           &lt;element name="NbOfDays" type="{urn:iso:std:iso:20022:tech:xsd:camt.052.001.03}Max15PlusSignedNumericText"/&gt;
 *           &lt;element name="ActlDt" type="{urn:iso:std:iso:20022:tech:xsd:camt.052.001.03}ISODate"/&gt;
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
@XmlType(name = "CashBalanceAvailabilityDate1", propOrder = {
    "nbOfDays",
    "actlDt"
})
public class CashBalanceAvailabilityDate1 {

    @XmlElement(name = "NbOfDays")
    protected String nbOfDays;
    @XmlElement(name = "ActlDt")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar actlDt;

    /**
     * Ruft den Wert der nbOfDays-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNbOfDays() {
        return nbOfDays;
    }

    /**
     * Legt den Wert der nbOfDays-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNbOfDays(String value) {
        this.nbOfDays = value;
    }

    /**
     * Ruft den Wert der actlDt-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getActlDt() {
        return actlDt;
    }

    /**
     * Legt den Wert der actlDt-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setActlDt(XMLGregorianCalendar value) {
        this.actlDt = value;
    }

}
