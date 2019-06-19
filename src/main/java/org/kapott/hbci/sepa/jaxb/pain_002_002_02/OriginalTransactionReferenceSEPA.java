//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2019.06.19 um 02:07:01 PM CEST 
//


package org.kapott.hbci.sepa.jaxb.pain_002_002_02;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java-Klasse für OriginalTransactionReferenceSEPA complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="OriginalTransactionReferenceSEPA"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Amt" type="{urn:swift:xsd:$pain.002.002.02}AmountTypeSEPA" minOccurs="0"/&gt;
 *         &lt;choice&gt;
 *           &lt;element name="ReqdExctnDt" type="{urn:swift:xsd:$pain.002.002.02}ISODate" minOccurs="0"/&gt;
 *           &lt;element name="ReqdColltnDt" type="{urn:swift:xsd:$pain.002.002.02}ISODate" minOccurs="0"/&gt;
 *         &lt;/choice&gt;
 *         &lt;element name="CdtrSchmeId" type="{urn:swift:xsd:$pain.002.002.02}PartyIdentificationSEPA2" minOccurs="0"/&gt;
 *         &lt;element name="PmtTpInf" type="{urn:swift:xsd:$pain.002.002.02}PaymentTypeInformationSEPA" minOccurs="0"/&gt;
 *         &lt;element name="PmtMtd" type="{urn:swift:xsd:$pain.002.002.02}PaymentMethodSEPACode" minOccurs="0"/&gt;
 *         &lt;element name="MndtRltdInf" type="{urn:swift:xsd:$pain.002.002.02}MandateRelatedInformationSEPA" minOccurs="0"/&gt;
 *         &lt;element name="RmtInf" type="{urn:swift:xsd:$pain.002.002.02}RemittanceInformationSEPAChoice" minOccurs="0"/&gt;
 *         &lt;element name="UltmtDbtr" type="{urn:swift:xsd:$pain.002.002.02}PartyIdentificationSEPA4" minOccurs="0"/&gt;
 *         &lt;element name="Dbtr" type="{urn:swift:xsd:$pain.002.002.02}PartyIdentificationSEPA5" minOccurs="0"/&gt;
 *         &lt;element name="DbtrAcct" type="{urn:swift:xsd:$pain.002.002.02}CashAccountSEPA1" minOccurs="0"/&gt;
 *         &lt;element name="DbtrAgt" type="{urn:swift:xsd:$pain.002.002.02}BranchAndFinancialInstitutionIdentificationSEPA1" minOccurs="0"/&gt;
 *         &lt;element name="CdtrAgt" type="{urn:swift:xsd:$pain.002.002.02}BranchAndFinancialInstitutionIdentificationSEPA1" minOccurs="0"/&gt;
 *         &lt;element name="Cdtr" type="{urn:swift:xsd:$pain.002.002.02}PartyIdentificationSEPA5" minOccurs="0"/&gt;
 *         &lt;element name="CdtrAcct" type="{urn:swift:xsd:$pain.002.002.02}CashAccountSEPA1" minOccurs="0"/&gt;
 *         &lt;element name="UltmtCdtr" type="{urn:swift:xsd:$pain.002.002.02}PartyIdentificationSEPA4" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OriginalTransactionReferenceSEPA", propOrder = {
    "amt",
    "reqdExctnDt",
    "reqdColltnDt",
    "cdtrSchmeId",
    "pmtTpInf",
    "pmtMtd",
    "mndtRltdInf",
    "rmtInf",
    "ultmtDbtr",
    "dbtr",
    "dbtrAcct",
    "dbtrAgt",
    "cdtrAgt",
    "cdtr",
    "cdtrAcct",
    "ultmtCdtr"
})
public class OriginalTransactionReferenceSEPA {

    @XmlElement(name = "Amt")
    protected AmountTypeSEPA amt;
    @XmlElement(name = "ReqdExctnDt")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar reqdExctnDt;
    @XmlElement(name = "ReqdColltnDt")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar reqdColltnDt;
    @XmlElement(name = "CdtrSchmeId")
    protected PartyIdentificationSEPA2 cdtrSchmeId;
    @XmlElement(name = "PmtTpInf")
    protected PaymentTypeInformationSEPA pmtTpInf;
    @XmlElement(name = "PmtMtd")
    @XmlSchemaType(name = "string")
    protected PaymentMethodSEPACode pmtMtd;
    @XmlElement(name = "MndtRltdInf")
    protected MandateRelatedInformationSEPA mndtRltdInf;
    @XmlElement(name = "RmtInf")
    protected RemittanceInformationSEPAChoice rmtInf;
    @XmlElement(name = "UltmtDbtr")
    protected PartyIdentificationSEPA4 ultmtDbtr;
    @XmlElement(name = "Dbtr")
    protected PartyIdentificationSEPA5 dbtr;
    @XmlElement(name = "DbtrAcct")
    protected CashAccountSEPA1 dbtrAcct;
    @XmlElement(name = "DbtrAgt")
    protected BranchAndFinancialInstitutionIdentificationSEPA1 dbtrAgt;
    @XmlElement(name = "CdtrAgt")
    protected BranchAndFinancialInstitutionIdentificationSEPA1 cdtrAgt;
    @XmlElement(name = "Cdtr")
    protected PartyIdentificationSEPA5 cdtr;
    @XmlElement(name = "CdtrAcct")
    protected CashAccountSEPA1 cdtrAcct;
    @XmlElement(name = "UltmtCdtr")
    protected PartyIdentificationSEPA4 ultmtCdtr;

    /**
     * Ruft den Wert der amt-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link AmountTypeSEPA }
     *     
     */
    public AmountTypeSEPA getAmt() {
        return amt;
    }

    /**
     * Legt den Wert der amt-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link AmountTypeSEPA }
     *     
     */
    public void setAmt(AmountTypeSEPA value) {
        this.amt = value;
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
     * Ruft den Wert der cdtrSchmeId-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PartyIdentificationSEPA2 }
     *     
     */
    public PartyIdentificationSEPA2 getCdtrSchmeId() {
        return cdtrSchmeId;
    }

    /**
     * Legt den Wert der cdtrSchmeId-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PartyIdentificationSEPA2 }
     *     
     */
    public void setCdtrSchmeId(PartyIdentificationSEPA2 value) {
        this.cdtrSchmeId = value;
    }

    /**
     * Ruft den Wert der pmtTpInf-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PaymentTypeInformationSEPA }
     *     
     */
    public PaymentTypeInformationSEPA getPmtTpInf() {
        return pmtTpInf;
    }

    /**
     * Legt den Wert der pmtTpInf-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PaymentTypeInformationSEPA }
     *     
     */
    public void setPmtTpInf(PaymentTypeInformationSEPA value) {
        this.pmtTpInf = value;
    }

    /**
     * Ruft den Wert der pmtMtd-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PaymentMethodSEPACode }
     *     
     */
    public PaymentMethodSEPACode getPmtMtd() {
        return pmtMtd;
    }

    /**
     * Legt den Wert der pmtMtd-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PaymentMethodSEPACode }
     *     
     */
    public void setPmtMtd(PaymentMethodSEPACode value) {
        this.pmtMtd = value;
    }

    /**
     * Ruft den Wert der mndtRltdInf-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link MandateRelatedInformationSEPA }
     *     
     */
    public MandateRelatedInformationSEPA getMndtRltdInf() {
        return mndtRltdInf;
    }

    /**
     * Legt den Wert der mndtRltdInf-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link MandateRelatedInformationSEPA }
     *     
     */
    public void setMndtRltdInf(MandateRelatedInformationSEPA value) {
        this.mndtRltdInf = value;
    }

    /**
     * Ruft den Wert der rmtInf-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link RemittanceInformationSEPAChoice }
     *     
     */
    public RemittanceInformationSEPAChoice getRmtInf() {
        return rmtInf;
    }

    /**
     * Legt den Wert der rmtInf-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link RemittanceInformationSEPAChoice }
     *     
     */
    public void setRmtInf(RemittanceInformationSEPAChoice value) {
        this.rmtInf = value;
    }

    /**
     * Ruft den Wert der ultmtDbtr-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PartyIdentificationSEPA4 }
     *     
     */
    public PartyIdentificationSEPA4 getUltmtDbtr() {
        return ultmtDbtr;
    }

    /**
     * Legt den Wert der ultmtDbtr-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PartyIdentificationSEPA4 }
     *     
     */
    public void setUltmtDbtr(PartyIdentificationSEPA4 value) {
        this.ultmtDbtr = value;
    }

    /**
     * Ruft den Wert der dbtr-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PartyIdentificationSEPA5 }
     *     
     */
    public PartyIdentificationSEPA5 getDbtr() {
        return dbtr;
    }

    /**
     * Legt den Wert der dbtr-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PartyIdentificationSEPA5 }
     *     
     */
    public void setDbtr(PartyIdentificationSEPA5 value) {
        this.dbtr = value;
    }

    /**
     * Ruft den Wert der dbtrAcct-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CashAccountSEPA1 }
     *     
     */
    public CashAccountSEPA1 getDbtrAcct() {
        return dbtrAcct;
    }

    /**
     * Legt den Wert der dbtrAcct-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CashAccountSEPA1 }
     *     
     */
    public void setDbtrAcct(CashAccountSEPA1 value) {
        this.dbtrAcct = value;
    }

    /**
     * Ruft den Wert der dbtrAgt-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link BranchAndFinancialInstitutionIdentificationSEPA1 }
     *     
     */
    public BranchAndFinancialInstitutionIdentificationSEPA1 getDbtrAgt() {
        return dbtrAgt;
    }

    /**
     * Legt den Wert der dbtrAgt-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link BranchAndFinancialInstitutionIdentificationSEPA1 }
     *     
     */
    public void setDbtrAgt(BranchAndFinancialInstitutionIdentificationSEPA1 value) {
        this.dbtrAgt = value;
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
     * Ruft den Wert der ultmtCdtr-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PartyIdentificationSEPA4 }
     *     
     */
    public PartyIdentificationSEPA4 getUltmtCdtr() {
        return ultmtCdtr;
    }

    /**
     * Legt den Wert der ultmtCdtr-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PartyIdentificationSEPA4 }
     *     
     */
    public void setUltmtCdtr(PartyIdentificationSEPA4 value) {
        this.ultmtCdtr = value;
    }

}
