//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2019.06.19 um 02:07:02 PM CEST 
//


package org.kapott.hbci.sepa.jaxb.pain_008_002_02;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java-Klasse für PaymentInstructionInformationSDD complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="PaymentInstructionInformationSDD"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="PmtInfId" type="{urn:iso:std:iso:20022:tech:xsd:pain.008.002.02}RestrictedIdentificationSEPA1"/&gt;
 *         &lt;element name="PmtMtd" type="{urn:iso:std:iso:20022:tech:xsd:pain.008.002.02}PaymentMethod2Code"/&gt;
 *         &lt;element name="BtchBookg" type="{urn:iso:std:iso:20022:tech:xsd:pain.008.002.02}BatchBookingIndicator" minOccurs="0"/&gt;
 *         &lt;element name="NbOfTxs" type="{urn:iso:std:iso:20022:tech:xsd:pain.008.002.02}Max15NumericText" minOccurs="0"/&gt;
 *         &lt;element name="CtrlSum" type="{urn:iso:std:iso:20022:tech:xsd:pain.008.002.02}DecimalNumber" minOccurs="0"/&gt;
 *         &lt;element name="PmtTpInf" type="{urn:iso:std:iso:20022:tech:xsd:pain.008.002.02}PaymentTypeInformationSDD"/&gt;
 *         &lt;element name="ReqdColltnDt" type="{urn:iso:std:iso:20022:tech:xsd:pain.008.002.02}ISODate"/&gt;
 *         &lt;element name="Cdtr" type="{urn:iso:std:iso:20022:tech:xsd:pain.008.002.02}PartyIdentificationSEPA5"/&gt;
 *         &lt;element name="CdtrAcct" type="{urn:iso:std:iso:20022:tech:xsd:pain.008.002.02}CashAccountSEPA1"/&gt;
 *         &lt;element name="CdtrAgt" type="{urn:iso:std:iso:20022:tech:xsd:pain.008.002.02}BranchAndFinancialInstitutionIdentificationSEPA1"/&gt;
 *         &lt;element name="UltmtCdtr" type="{urn:iso:std:iso:20022:tech:xsd:pain.008.002.02}PartyIdentificationSEPA1" minOccurs="0"/&gt;
 *         &lt;element name="ChrgBr" type="{urn:iso:std:iso:20022:tech:xsd:pain.008.002.02}ChargeBearerTypeSEPACode" minOccurs="0"/&gt;
 *         &lt;element name="CdtrSchmeId" type="{urn:iso:std:iso:20022:tech:xsd:pain.008.002.02}PartyIdentificationSEPA3" minOccurs="0"/&gt;
 *         &lt;element name="DrctDbtTxInf" type="{urn:iso:std:iso:20022:tech:xsd:pain.008.002.02}DirectDebitTransactionInformationSDD" maxOccurs="unbounded"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PaymentInstructionInformationSDD", propOrder = {
    "pmtInfId",
    "pmtMtd",
    "btchBookg",
    "nbOfTxs",
    "ctrlSum",
    "pmtTpInf",
    "reqdColltnDt",
    "cdtr",
    "cdtrAcct",
    "cdtrAgt",
    "ultmtCdtr",
    "chrgBr",
    "cdtrSchmeId",
    "drctDbtTxInf"
})
public class PaymentInstructionInformationSDD {

    @XmlElement(name = "PmtInfId", required = true)
    protected String pmtInfId;
    @XmlElement(name = "PmtMtd", required = true)
    @XmlSchemaType(name = "string")
    protected PaymentMethod2Code pmtMtd;
    @XmlElement(name = "BtchBookg")
    protected Boolean btchBookg;
    @XmlElement(name = "NbOfTxs")
    protected String nbOfTxs;
    @XmlElement(name = "CtrlSum")
    protected BigDecimal ctrlSum;
    @XmlElement(name = "PmtTpInf", required = true)
    protected PaymentTypeInformationSDD pmtTpInf;
    @XmlElement(name = "ReqdColltnDt", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar reqdColltnDt;
    @XmlElement(name = "Cdtr", required = true)
    protected PartyIdentificationSEPA5 cdtr;
    @XmlElement(name = "CdtrAcct", required = true)
    protected CashAccountSEPA1 cdtrAcct;
    @XmlElement(name = "CdtrAgt", required = true)
    protected BranchAndFinancialInstitutionIdentificationSEPA1 cdtrAgt;
    @XmlElement(name = "UltmtCdtr")
    protected PartyIdentificationSEPA1 ultmtCdtr;
    @XmlElement(name = "ChrgBr")
    @XmlSchemaType(name = "string")
    protected ChargeBearerTypeSEPACode chrgBr;
    @XmlElement(name = "CdtrSchmeId")
    protected PartyIdentificationSEPA3 cdtrSchmeId;
    @XmlElement(name = "DrctDbtTxInf", required = true)
    protected List<DirectDebitTransactionInformationSDD> drctDbtTxInf;

    /**
     * Ruft den Wert der pmtInfId-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPmtInfId() {
        return pmtInfId;
    }

    /**
     * Legt den Wert der pmtInfId-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPmtInfId(String value) {
        this.pmtInfId = value;
    }

    /**
     * Ruft den Wert der pmtMtd-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PaymentMethod2Code }
     *     
     */
    public PaymentMethod2Code getPmtMtd() {
        return pmtMtd;
    }

    /**
     * Legt den Wert der pmtMtd-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PaymentMethod2Code }
     *     
     */
    public void setPmtMtd(PaymentMethod2Code value) {
        this.pmtMtd = value;
    }

    /**
     * Ruft den Wert der btchBookg-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isBtchBookg() {
        return btchBookg;
    }

    /**
     * Legt den Wert der btchBookg-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setBtchBookg(Boolean value) {
        this.btchBookg = value;
    }

    /**
     * Ruft den Wert der nbOfTxs-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNbOfTxs() {
        return nbOfTxs;
    }

    /**
     * Legt den Wert der nbOfTxs-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNbOfTxs(String value) {
        this.nbOfTxs = value;
    }

    /**
     * Ruft den Wert der ctrlSum-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getCtrlSum() {
        return ctrlSum;
    }

    /**
     * Legt den Wert der ctrlSum-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setCtrlSum(BigDecimal value) {
        this.ctrlSum = value;
    }

    /**
     * Ruft den Wert der pmtTpInf-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PaymentTypeInformationSDD }
     *     
     */
    public PaymentTypeInformationSDD getPmtTpInf() {
        return pmtTpInf;
    }

    /**
     * Legt den Wert der pmtTpInf-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PaymentTypeInformationSDD }
     *     
     */
    public void setPmtTpInf(PaymentTypeInformationSDD value) {
        this.pmtTpInf = value;
    }

    /**
     * Ruft den Wert der reqdColltnDt-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getReqdColltnDt() {
        return reqdColltnDt;
    }

    /**
     * Legt den Wert der reqdColltnDt-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setReqdColltnDt(XMLGregorianCalendar value) {
        this.reqdColltnDt = value;
    }

    /**
     * Ruft den Wert der cdtr-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PartyIdentificationSEPA5 }
     *     
     */
    public PartyIdentificationSEPA5 getCdtr() {
        return cdtr;
    }

    /**
     * Legt den Wert der cdtr-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PartyIdentificationSEPA5 }
     *     
     */
    public void setCdtr(PartyIdentificationSEPA5 value) {
        this.cdtr = value;
    }

    /**
     * Ruft den Wert der cdtrAcct-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CashAccountSEPA1 }
     *     
     */
    public CashAccountSEPA1 getCdtrAcct() {
        return cdtrAcct;
    }

    /**
     * Legt den Wert der cdtrAcct-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CashAccountSEPA1 }
     *     
     */
    public void setCdtrAcct(CashAccountSEPA1 value) {
        this.cdtrAcct = value;
    }

    /**
     * Ruft den Wert der cdtrAgt-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link BranchAndFinancialInstitutionIdentificationSEPA1 }
     *     
     */
    public BranchAndFinancialInstitutionIdentificationSEPA1 getCdtrAgt() {
        return cdtrAgt;
    }

    /**
     * Legt den Wert der cdtrAgt-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link BranchAndFinancialInstitutionIdentificationSEPA1 }
     *     
     */
    public void setCdtrAgt(BranchAndFinancialInstitutionIdentificationSEPA1 value) {
        this.cdtrAgt = value;
    }

    /**
     * Ruft den Wert der ultmtCdtr-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PartyIdentificationSEPA1 }
     *     
     */
    public PartyIdentificationSEPA1 getUltmtCdtr() {
        return ultmtCdtr;
    }

    /**
     * Legt den Wert der ultmtCdtr-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PartyIdentificationSEPA1 }
     *     
     */
    public void setUltmtCdtr(PartyIdentificationSEPA1 value) {
        this.ultmtCdtr = value;
    }

    /**
     * Ruft den Wert der chrgBr-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ChargeBearerTypeSEPACode }
     *     
     */
    public ChargeBearerTypeSEPACode getChrgBr() {
        return chrgBr;
    }

    /**
     * Legt den Wert der chrgBr-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ChargeBearerTypeSEPACode }
     *     
     */
    public void setChrgBr(ChargeBearerTypeSEPACode value) {
        this.chrgBr = value;
    }

    /**
     * Ruft den Wert der cdtrSchmeId-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PartyIdentificationSEPA3 }
     *     
     */
    public PartyIdentificationSEPA3 getCdtrSchmeId() {
        return cdtrSchmeId;
    }

    /**
     * Legt den Wert der cdtrSchmeId-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PartyIdentificationSEPA3 }
     *     
     */
    public void setCdtrSchmeId(PartyIdentificationSEPA3 value) {
        this.cdtrSchmeId = value;
    }

    /**
     * Gets the value of the drctDbtTxInf property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the drctDbtTxInf property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDrctDbtTxInf().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DirectDebitTransactionInformationSDD }
     * 
     * 
     */
    public List<DirectDebitTransactionInformationSDD> getDrctDbtTxInf() {
        if (drctDbtTxInf == null) {
            drctDbtTxInf = new ArrayList<DirectDebitTransactionInformationSDD>();
        }
        return this.drctDbtTxInf;
    }

}
