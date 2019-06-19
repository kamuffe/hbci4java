//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2019.06.19 um 02:07:01 PM CEST 
//


package org.kapott.hbci.sepa.jaxb.pain_008_001_01;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java-Klasse für PaymentInstructionInformation5 complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="PaymentInstructionInformation5"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="PmtInfId" type="{urn:sepade:xsd:pain.008.001.01}Max35Text" minOccurs="0"/&gt;
 *         &lt;element name="PmtMtd" type="{urn:sepade:xsd:pain.008.001.01}PaymentMethod2Code"/&gt;
 *         &lt;element name="PmtTpInf" type="{urn:sepade:xsd:pain.008.001.01}PaymentTypeInformation8"/&gt;
 *         &lt;element name="ReqdColltnDt" type="{urn:sepade:xsd:pain.008.001.01}ISODate"/&gt;
 *         &lt;element name="Cdtr" type="{urn:sepade:xsd:pain.008.001.01}PartyIdentification22"/&gt;
 *         &lt;element name="CdtrAcct" type="{urn:sepade:xsd:pain.008.001.01}CashAccount8"/&gt;
 *         &lt;element name="CdtrAgt" type="{urn:sepade:xsd:pain.008.001.01}FinancialInstitution2"/&gt;
 *         &lt;element name="ChrgBr" type="{urn:sepade:xsd:pain.008.001.01}ChargeBearerType2Code"/&gt;
 *         &lt;element name="DrctDbtTxInf" type="{urn:sepade:xsd:pain.008.001.01}DirectDebitTransactionInformation2" maxOccurs="unbounded"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PaymentInstructionInformation5", propOrder = {
    "pmtInfId",
    "pmtMtd",
    "pmtTpInf",
    "reqdColltnDt",
    "cdtr",
    "cdtrAcct",
    "cdtrAgt",
    "chrgBr",
    "drctDbtTxInf"
})
public class PaymentInstructionInformation5 {

    @XmlElement(name = "PmtInfId")
    protected String pmtInfId;
    @XmlElement(name = "PmtMtd", required = true)
    @XmlSchemaType(name = "string")
    protected PaymentMethod2Code pmtMtd;
    @XmlElement(name = "PmtTpInf", required = true)
    protected PaymentTypeInformation8 pmtTpInf;
    @XmlElement(name = "ReqdColltnDt", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar reqdColltnDt;
    @XmlElement(name = "Cdtr", required = true)
    protected PartyIdentification22 cdtr;
    @XmlElement(name = "CdtrAcct", required = true)
    protected CashAccount8 cdtrAcct;
    @XmlElement(name = "CdtrAgt", required = true)
    protected FinancialInstitution2 cdtrAgt;
    @XmlElement(name = "ChrgBr", required = true)
    @XmlSchemaType(name = "string")
    protected ChargeBearerType2Code chrgBr;
    @XmlElement(name = "DrctDbtTxInf", required = true)
    protected List<DirectDebitTransactionInformation2> drctDbtTxInf;

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
     *     {@link PaymentTypeInformation8 }
     *     
     */
    public PaymentTypeInformation8 getPmtTpInf() {
        return pmtTpInf;
    }

    /**
     * Legt den Wert der pmtTpInf-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PaymentTypeInformation8 }
     *     
     */
    public void setPmtTpInf(PaymentTypeInformation8 value) {
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
     *     {@link PartyIdentification22 }
     *     
     */
    public PartyIdentification22 getCdtr() {
        return cdtr;
    }

    /**
     * Legt den Wert der cdtr-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PartyIdentification22 }
     *     
     */
    public void setCdtr(PartyIdentification22 value) {
        this.cdtr = value;
    }

    /**
     * Ruft den Wert der cdtrAcct-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CashAccount8 }
     *     
     */
    public CashAccount8 getCdtrAcct() {
        return cdtrAcct;
    }

    /**
     * Legt den Wert der cdtrAcct-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CashAccount8 }
     *     
     */
    public void setCdtrAcct(CashAccount8 value) {
        this.cdtrAcct = value;
    }

    /**
     * Ruft den Wert der cdtrAgt-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link FinancialInstitution2 }
     *     
     */
    public FinancialInstitution2 getCdtrAgt() {
        return cdtrAgt;
    }

    /**
     * Legt den Wert der cdtrAgt-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link FinancialInstitution2 }
     *     
     */
    public void setCdtrAgt(FinancialInstitution2 value) {
        this.cdtrAgt = value;
    }

    /**
     * Ruft den Wert der chrgBr-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ChargeBearerType2Code }
     *     
     */
    public ChargeBearerType2Code getChrgBr() {
        return chrgBr;
    }

    /**
     * Legt den Wert der chrgBr-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ChargeBearerType2Code }
     *     
     */
    public void setChrgBr(ChargeBearerType2Code value) {
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
     * {@link DirectDebitTransactionInformation2 }
     * 
     * 
     */
    public List<DirectDebitTransactionInformation2> getDrctDbtTxInf() {
        if (drctDbtTxInf == null) {
            drctDbtTxInf = new ArrayList<DirectDebitTransactionInformation2>();
        }
        return this.drctDbtTxInf;
    }

}
