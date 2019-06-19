//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2019.06.19 um 02:06:59 PM CEST 
//


package org.kapott.hbci.sepa.jaxb.camt_052_001_05;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für TransactionInterest3 complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="TransactionInterest3"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="TtlIntrstAndTaxAmt" type="{urn:iso:std:iso:20022:tech:xsd:camt.052.001.05}ActiveOrHistoricCurrencyAndAmount" minOccurs="0"/&gt;
 *         &lt;element name="Rcrd" type="{urn:iso:std:iso:20022:tech:xsd:camt.052.001.05}InterestRecord1" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TransactionInterest3", propOrder = {
    "ttlIntrstAndTaxAmt",
    "rcrd"
})
public class TransactionInterest3 {

    @XmlElement(name = "TtlIntrstAndTaxAmt")
    protected ActiveOrHistoricCurrencyAndAmount ttlIntrstAndTaxAmt;
    @XmlElement(name = "Rcrd")
    protected List<InterestRecord1> rcrd;

    /**
     * Ruft den Wert der ttlIntrstAndTaxAmt-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ActiveOrHistoricCurrencyAndAmount }
     *     
     */
    public ActiveOrHistoricCurrencyAndAmount getTtlIntrstAndTaxAmt() {
        return ttlIntrstAndTaxAmt;
    }

    /**
     * Legt den Wert der ttlIntrstAndTaxAmt-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ActiveOrHistoricCurrencyAndAmount }
     *     
     */
    public void setTtlIntrstAndTaxAmt(ActiveOrHistoricCurrencyAndAmount value) {
        this.ttlIntrstAndTaxAmt = value;
    }

    /**
     * Gets the value of the rcrd property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the rcrd property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRcrd().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link InterestRecord1 }
     * 
     * 
     */
    public List<InterestRecord1> getRcrd() {
        if (rcrd == null) {
            rcrd = new ArrayList<InterestRecord1>();
        }
        return this.rcrd;
    }

}
