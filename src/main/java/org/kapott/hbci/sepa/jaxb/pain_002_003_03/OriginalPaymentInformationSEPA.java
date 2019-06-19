//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2019.06.19 um 02:07:01 PM CEST 
//


package org.kapott.hbci.sepa.jaxb.pain_002_003_03;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für OriginalPaymentInformationSEPA complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="OriginalPaymentInformationSEPA"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="OrgnlPmtInfId" type="{urn:iso:std:iso:20022:tech:xsd:pain.002.003.03}RestrictedIdentificationSEPA1"/&gt;
 *         &lt;element name="OrgnlNbOfTxs" type="{urn:iso:std:iso:20022:tech:xsd:pain.002.003.03}Max15NumericText" minOccurs="0"/&gt;
 *         &lt;element name="OrgnlCtrlSum" type="{urn:iso:std:iso:20022:tech:xsd:pain.002.003.03}DecimalNumber" minOccurs="0"/&gt;
 *         &lt;element name="PmtInfSts" type="{urn:iso:std:iso:20022:tech:xsd:pain.002.003.03}TransactionGroupStatusCodeSEPA" minOccurs="0"/&gt;
 *         &lt;element name="StsRsnInf" type="{urn:iso:std:iso:20022:tech:xsd:pain.002.003.03}StatusReasonInformationSEPA" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="TxInfAndSts" type="{urn:iso:std:iso:20022:tech:xsd:pain.002.003.03}PaymentTransactionInformationSEPA" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OriginalPaymentInformationSEPA", propOrder = {
    "orgnlPmtInfId",
    "orgnlNbOfTxs",
    "orgnlCtrlSum",
    "pmtInfSts",
    "stsRsnInf",
    "txInfAndSts"
})
public class OriginalPaymentInformationSEPA {

    @XmlElement(name = "OrgnlPmtInfId", required = true)
    protected String orgnlPmtInfId;
    @XmlElement(name = "OrgnlNbOfTxs")
    protected String orgnlNbOfTxs;
    @XmlElement(name = "OrgnlCtrlSum")
    protected BigDecimal orgnlCtrlSum;
    @XmlElement(name = "PmtInfSts")
    @XmlSchemaType(name = "string")
    protected TransactionGroupStatusCodeSEPA pmtInfSts;
    @XmlElement(name = "StsRsnInf")
    protected List<StatusReasonInformationSEPA> stsRsnInf;
    @XmlElement(name = "TxInfAndSts")
    protected List<PaymentTransactionInformationSEPA> txInfAndSts;

    /**
     * Ruft den Wert der orgnlPmtInfId-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrgnlPmtInfId() {
        return orgnlPmtInfId;
    }

    /**
     * Legt den Wert der orgnlPmtInfId-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrgnlPmtInfId(String value) {
        this.orgnlPmtInfId = value;
    }

    /**
     * Ruft den Wert der orgnlNbOfTxs-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrgnlNbOfTxs() {
        return orgnlNbOfTxs;
    }

    /**
     * Legt den Wert der orgnlNbOfTxs-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrgnlNbOfTxs(String value) {
        this.orgnlNbOfTxs = value;
    }

    /**
     * Ruft den Wert der orgnlCtrlSum-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getOrgnlCtrlSum() {
        return orgnlCtrlSum;
    }

    /**
     * Legt den Wert der orgnlCtrlSum-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setOrgnlCtrlSum(BigDecimal value) {
        this.orgnlCtrlSum = value;
    }

    /**
     * Ruft den Wert der pmtInfSts-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TransactionGroupStatusCodeSEPA }
     *     
     */
    public TransactionGroupStatusCodeSEPA getPmtInfSts() {
        return pmtInfSts;
    }

    /**
     * Legt den Wert der pmtInfSts-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TransactionGroupStatusCodeSEPA }
     *     
     */
    public void setPmtInfSts(TransactionGroupStatusCodeSEPA value) {
        this.pmtInfSts = value;
    }

    /**
     * Gets the value of the stsRsnInf property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the stsRsnInf property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getStsRsnInf().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link StatusReasonInformationSEPA }
     * 
     * 
     */
    public List<StatusReasonInformationSEPA> getStsRsnInf() {
        if (stsRsnInf == null) {
            stsRsnInf = new ArrayList<StatusReasonInformationSEPA>();
        }
        return this.stsRsnInf;
    }

    /**
     * Gets the value of the txInfAndSts property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the txInfAndSts property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTxInfAndSts().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PaymentTransactionInformationSEPA }
     * 
     * 
     */
    public List<PaymentTransactionInformationSEPA> getTxInfAndSts() {
        if (txInfAndSts == null) {
            txInfAndSts = new ArrayList<PaymentTransactionInformationSEPA>();
        }
        return this.txInfAndSts;
    }

}
