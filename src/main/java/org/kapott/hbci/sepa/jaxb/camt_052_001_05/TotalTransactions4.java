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
 * <p>Java-Klasse für TotalTransactions4 complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="TotalTransactions4"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="TtlNtries" type="{urn:iso:std:iso:20022:tech:xsd:camt.052.001.05}NumberAndSumOfTransactions4" minOccurs="0"/&gt;
 *         &lt;element name="TtlCdtNtries" type="{urn:iso:std:iso:20022:tech:xsd:camt.052.001.05}NumberAndSumOfTransactions1" minOccurs="0"/&gt;
 *         &lt;element name="TtlDbtNtries" type="{urn:iso:std:iso:20022:tech:xsd:camt.052.001.05}NumberAndSumOfTransactions1" minOccurs="0"/&gt;
 *         &lt;element name="TtlNtriesPerBkTxCd" type="{urn:iso:std:iso:20022:tech:xsd:camt.052.001.05}TotalsPerBankTransactionCode3" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TotalTransactions4", propOrder = {
    "ttlNtries",
    "ttlCdtNtries",
    "ttlDbtNtries",
    "ttlNtriesPerBkTxCd"
})
public class TotalTransactions4 {

    @XmlElement(name = "TtlNtries")
    protected NumberAndSumOfTransactions4 ttlNtries;
    @XmlElement(name = "TtlCdtNtries")
    protected NumberAndSumOfTransactions1 ttlCdtNtries;
    @XmlElement(name = "TtlDbtNtries")
    protected NumberAndSumOfTransactions1 ttlDbtNtries;
    @XmlElement(name = "TtlNtriesPerBkTxCd")
    protected List<TotalsPerBankTransactionCode3> ttlNtriesPerBkTxCd;

    /**
     * Ruft den Wert der ttlNtries-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link NumberAndSumOfTransactions4 }
     *     
     */
    public NumberAndSumOfTransactions4 getTtlNtries() {
        return ttlNtries;
    }

    /**
     * Legt den Wert der ttlNtries-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link NumberAndSumOfTransactions4 }
     *     
     */
    public void setTtlNtries(NumberAndSumOfTransactions4 value) {
        this.ttlNtries = value;
    }

    /**
     * Ruft den Wert der ttlCdtNtries-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link NumberAndSumOfTransactions1 }
     *     
     */
    public NumberAndSumOfTransactions1 getTtlCdtNtries() {
        return ttlCdtNtries;
    }

    /**
     * Legt den Wert der ttlCdtNtries-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link NumberAndSumOfTransactions1 }
     *     
     */
    public void setTtlCdtNtries(NumberAndSumOfTransactions1 value) {
        this.ttlCdtNtries = value;
    }

    /**
     * Ruft den Wert der ttlDbtNtries-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link NumberAndSumOfTransactions1 }
     *     
     */
    public NumberAndSumOfTransactions1 getTtlDbtNtries() {
        return ttlDbtNtries;
    }

    /**
     * Legt den Wert der ttlDbtNtries-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link NumberAndSumOfTransactions1 }
     *     
     */
    public void setTtlDbtNtries(NumberAndSumOfTransactions1 value) {
        this.ttlDbtNtries = value;
    }

    /**
     * Gets the value of the ttlNtriesPerBkTxCd property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ttlNtriesPerBkTxCd property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTtlNtriesPerBkTxCd().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TotalsPerBankTransactionCode3 }
     * 
     * 
     */
    public List<TotalsPerBankTransactionCode3> getTtlNtriesPerBkTxCd() {
        if (ttlNtriesPerBkTxCd == null) {
            ttlNtriesPerBkTxCd = new ArrayList<TotalsPerBankTransactionCode3>();
        }
        return this.ttlNtriesPerBkTxCd;
    }

}
