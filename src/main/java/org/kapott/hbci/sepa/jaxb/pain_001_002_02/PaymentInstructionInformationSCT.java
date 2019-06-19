//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2019.06.19 um 02:07:00 PM CEST 
//


package org.kapott.hbci.sepa.jaxb.pain_001_002_02;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java-Klasse für PaymentInstructionInformationSCT complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="PaymentInstructionInformationSCT"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="PmtInfId" type="{urn:swift:xsd:$pain.001.002.02}RestrictedIdentification2" minOccurs="0"/&gt;
 *         &lt;element name="PmtMtd" type="{urn:swift:xsd:$pain.001.002.02}PaymentMethodSCTCode"/&gt;
 *         &lt;element name="PmtTpInf" type="{urn:swift:xsd:$pain.001.002.02}PaymentTypeInformationSCT1" minOccurs="0"/&gt;
 *         &lt;element name="ReqdExctnDt" type="{urn:swift:xsd:$pain.001.002.02}ISODate"/&gt;
 *         &lt;element name="Dbtr" type="{urn:swift:xsd:$pain.001.002.02}PartyIdentificationSCT2"/&gt;
 *         &lt;element name="DbtrAcct" type="{urn:swift:xsd:$pain.001.002.02}CashAccountSCT1"/&gt;
 *         &lt;element name="DbtrAgt" type="{urn:swift:xsd:$pain.001.002.02}BranchAndFinancialInstitutionIdentificationSCT"/&gt;
 *         &lt;element name="UltmtDbtr" type="{urn:swift:xsd:$pain.001.002.02}PartyIdentificationSCT1" minOccurs="0"/&gt;
 *         &lt;element name="ChrgBr" type="{urn:swift:xsd:$pain.001.002.02}ChargeBearerTypeSCTCode" minOccurs="0"/&gt;
 *         &lt;element name="CdtTrfTxInf" type="{urn:swift:xsd:$pain.001.002.02}CreditTransferTransactionInformationSCT" maxOccurs="unbounded"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PaymentInstructionInformationSCT", propOrder = {
    "pmtInfId",
    "pmtMtd",
    "pmtTpInf",
    "reqdExctnDt",
    "dbtr",
    "dbtrAcct",
    "dbtrAgt",
    "ultmtDbtr",
    "chrgBr",
    "cdtTrfTxInf"
})
public class PaymentInstructionInformationSCT {

    @XmlElement(name = "PmtInfId")
    protected String pmtInfId;
    @XmlElement(name = "PmtMtd", required = true)
    @XmlSchemaType(name = "string")
    protected PaymentMethodSCTCode pmtMtd;
    @XmlElement(name = "PmtTpInf")
    protected PaymentTypeInformationSCT1 pmtTpInf;
    @XmlElement(name = "ReqdExctnDt", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar reqdExctnDt;
    @XmlElement(name = "Dbtr", required = true)
    protected PartyIdentificationSCT2 dbtr;
    @XmlElement(name = "DbtrAcct", required = true)
    protected CashAccountSCT1 dbtrAcct;
    @XmlElement(name = "DbtrAgt", required = true)
    protected BranchAndFinancialInstitutionIdentificationSCT dbtrAgt;
    @XmlElement(name = "UltmtDbtr")
    protected PartyIdentificationSCT1 ultmtDbtr;
    @XmlElement(name = "ChrgBr")
    @XmlSchemaType(name = "string")
    protected ChargeBearerTypeSCTCode chrgBr;
    @XmlElement(name = "CdtTrfTxInf", required = true)
    protected List<CreditTransferTransactionInformationSCT> cdtTrfTxInf;

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
     *     {@link PaymentMethodSCTCode }
     *     
     */
    public PaymentMethodSCTCode getPmtMtd() {
        return pmtMtd;
    }

    /**
     * Legt den Wert der pmtMtd-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PaymentMethodSCTCode }
     *     
     */
    public void setPmtMtd(PaymentMethodSCTCode value) {
        this.pmtMtd = value;
    }

    /**
     * Ruft den Wert der pmtTpInf-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PaymentTypeInformationSCT1 }
     *     
     */
    public PaymentTypeInformationSCT1 getPmtTpInf() {
        return pmtTpInf;
    }

    /**
     * Legt den Wert der pmtTpInf-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PaymentTypeInformationSCT1 }
     *     
     */
    public void setPmtTpInf(PaymentTypeInformationSCT1 value) {
        this.pmtTpInf = value;
    }

    /**
     * Ruft den Wert der reqdExctnDt-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getReqdExctnDt() {
        return reqdExctnDt;
    }

    /**
     * Legt den Wert der reqdExctnDt-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setReqdExctnDt(XMLGregorianCalendar value) {
        this.reqdExctnDt = value;
    }

    /**
     * Ruft den Wert der dbtr-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PartyIdentificationSCT2 }
     *     
     */
    public PartyIdentificationSCT2 getDbtr() {
        return dbtr;
    }

    /**
     * Legt den Wert der dbtr-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PartyIdentificationSCT2 }
     *     
     */
    public void setDbtr(PartyIdentificationSCT2 value) {
        this.dbtr = value;
    }

    /**
     * Ruft den Wert der dbtrAcct-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CashAccountSCT1 }
     *     
     */
    public CashAccountSCT1 getDbtrAcct() {
        return dbtrAcct;
    }

    /**
     * Legt den Wert der dbtrAcct-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CashAccountSCT1 }
     *     
     */
    public void setDbtrAcct(CashAccountSCT1 value) {
        this.dbtrAcct = value;
    }

    /**
     * Ruft den Wert der dbtrAgt-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link BranchAndFinancialInstitutionIdentificationSCT }
     *     
     */
    public BranchAndFinancialInstitutionIdentificationSCT getDbtrAgt() {
        return dbtrAgt;
    }

    /**
     * Legt den Wert der dbtrAgt-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link BranchAndFinancialInstitutionIdentificationSCT }
     *     
     */
    public void setDbtrAgt(BranchAndFinancialInstitutionIdentificationSCT value) {
        this.dbtrAgt = value;
    }

    /**
     * Ruft den Wert der ultmtDbtr-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PartyIdentificationSCT1 }
     *     
     */
    public PartyIdentificationSCT1 getUltmtDbtr() {
        return ultmtDbtr;
    }

    /**
     * Legt den Wert der ultmtDbtr-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PartyIdentificationSCT1 }
     *     
     */
    public void setUltmtDbtr(PartyIdentificationSCT1 value) {
        this.ultmtDbtr = value;
    }

    /**
     * Ruft den Wert der chrgBr-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ChargeBearerTypeSCTCode }
     *     
     */
    public ChargeBearerTypeSCTCode getChrgBr() {
        return chrgBr;
    }

    /**
     * Legt den Wert der chrgBr-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ChargeBearerTypeSCTCode }
     *     
     */
    public void setChrgBr(ChargeBearerTypeSCTCode value) {
        this.chrgBr = value;
    }

    /**
     * Gets the value of the cdtTrfTxInf property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the cdtTrfTxInf property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCdtTrfTxInf().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CreditTransferTransactionInformationSCT }
     * 
     * 
     */
    public List<CreditTransferTransactionInformationSCT> getCdtTrfTxInf() {
        if (cdtTrfTxInf == null) {
            cdtTrfTxInf = new ArrayList<CreditTransferTransactionInformationSCT>();
        }
        return this.cdtTrfTxInf;
    }

}
