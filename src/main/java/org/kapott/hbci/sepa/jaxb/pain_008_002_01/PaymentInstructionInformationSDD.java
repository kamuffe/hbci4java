//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2019.06.19 um 02:07:01 PM CEST 
//


package org.kapott.hbci.sepa.jaxb.pain_008_002_01;

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
 *         &lt;element name="PmtInfId" type="{urn:swift:xsd:$pain.008.002.01}RestrictedIdentification1" minOccurs="0"/&gt;
 *         &lt;element name="PmtMtd" type="{urn:swift:xsd:$pain.008.002.01}PaymentMethod2Code"/&gt;
 *         &lt;element name="PmtTpInf" type="{urn:swift:xsd:$pain.008.002.01}PaymentTypeInformationSDD"/&gt;
 *         &lt;element name="ReqdColltnDt" type="{urn:swift:xsd:$pain.008.002.01}ISODate"/&gt;
 *         &lt;element name="Cdtr" type="{urn:swift:xsd:$pain.008.002.01}PartyIdentificationSDD2"/&gt;
 *         &lt;element name="CdtrAcct" type="{urn:swift:xsd:$pain.008.002.01}CashAccountSDD1"/&gt;
 *         &lt;element name="CdtrAgt" type="{urn:swift:xsd:$pain.008.002.01}BranchAndFinancialInstitutionIdentificationSDD1"/&gt;
 *         &lt;element name="UltmtCdtr" type="{urn:swift:xsd:$pain.008.002.01}PartyIdentificationSDD1" minOccurs="0"/&gt;
 *         &lt;element name="ChrgBr" type="{urn:swift:xsd:$pain.008.002.01}ChargeBearerTypeSDDCode" minOccurs="0"/&gt;
 *         &lt;element name="DrctDbtTxInf" type="{urn:swift:xsd:$pain.008.002.01}DirectDebitTransactionInformationSDD" maxOccurs="unbounded"/&gt;
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
    "pmtTpInf",
    "reqdColltnDt",
    "cdtr",
    "cdtrAcct",
    "cdtrAgt",
    "ultmtCdtr",
    "chrgBr",
    "drctDbtTxInf"
})
public class PaymentInstructionInformationSDD {

    @XmlElement(name = "PmtInfId")
    protected String pmtInfId;
    @XmlElement(name = "PmtMtd", required = true)
    @XmlSchemaType(name = "string")
    protected PaymentMethod2Code pmtMtd;
    @XmlElement(name = "PmtTpInf", required = true)
    protected PaymentTypeInformationSDD pmtTpInf;
    @XmlElement(name = "ReqdColltnDt", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar reqdColltnDt;
    @XmlElement(name = "Cdtr", required = true)
    protected PartyIdentificationSDD2 cdtr;
    @XmlElement(name = "CdtrAcct", required = true)
    protected CashAccountSDD1 cdtrAcct;
    @XmlElement(name = "CdtrAgt", required = true)
    protected BranchAndFinancialInstitutionIdentificationSDD1 cdtrAgt;
    @XmlElement(name = "UltmtCdtr")
    protected PartyIdentificationSDD1 ultmtCdtr;
    @XmlElement(name = "ChrgBr")
    @XmlSchemaType(name = "string")
    protected ChargeBearerTypeSDDCode chrgBr;
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
     *     {@link PartyIdentificationSDD2 }
     *     
     */
    public PartyIdentificationSDD2 getCdtr() {
        return cdtr;
    }

    /**
     * Legt den Wert der cdtr-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PartyIdentificationSDD2 }
     *     
     */
    public void setCdtr(PartyIdentificationSDD2 value) {
        this.cdtr = value;
    }

    /**
     * Ruft den Wert der cdtrAcct-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CashAccountSDD1 }
     *     
     */
    public CashAccountSDD1 getCdtrAcct() {
        return cdtrAcct;
    }

    /**
     * Legt den Wert der cdtrAcct-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CashAccountSDD1 }
     *     
     */
    public void setCdtrAcct(CashAccountSDD1 value) {
        this.cdtrAcct = value;
    }

    /**
     * Ruft den Wert der cdtrAgt-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link BranchAndFinancialInstitutionIdentificationSDD1 }
     *     
     */
    public BranchAndFinancialInstitutionIdentificationSDD1 getCdtrAgt() {
        return cdtrAgt;
    }

    /**
     * Legt den Wert der cdtrAgt-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link BranchAndFinancialInstitutionIdentificationSDD1 }
     *     
     */
    public void setCdtrAgt(BranchAndFinancialInstitutionIdentificationSDD1 value) {
        this.cdtrAgt = value;
    }

    /**
     * Ruft den Wert der ultmtCdtr-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PartyIdentificationSDD1 }
     *     
     */
    public PartyIdentificationSDD1 getUltmtCdtr() {
        return ultmtCdtr;
    }

    /**
     * Legt den Wert der ultmtCdtr-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PartyIdentificationSDD1 }
     *     
     */
    public void setUltmtCdtr(PartyIdentificationSDD1 value) {
        this.ultmtCdtr = value;
    }

    /**
     * Ruft den Wert der chrgBr-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ChargeBearerTypeSDDCode }
     *     
     */
    public ChargeBearerTypeSDDCode getChrgBr() {
        return chrgBr;
    }

    /**
     * Legt den Wert der chrgBr-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ChargeBearerTypeSDDCode }
     *     
     */
    public void setChrgBr(ChargeBearerTypeSDDCode value) {
        this.chrgBr = value;
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
