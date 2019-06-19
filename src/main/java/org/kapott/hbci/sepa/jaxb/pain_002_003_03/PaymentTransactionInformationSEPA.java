//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2019.06.19 um 02:07:01 PM CEST 
//


package org.kapott.hbci.sepa.jaxb.pain_002_003_03;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für PaymentTransactionInformationSEPA complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="PaymentTransactionInformationSEPA"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="StsId" type="{urn:iso:std:iso:20022:tech:xsd:pain.002.003.03}RestrictedIdentificationSEPA1" minOccurs="0"/&gt;
 *         &lt;element name="OrgnlInstrId" type="{urn:iso:std:iso:20022:tech:xsd:pain.002.003.03}Max35Text" minOccurs="0"/&gt;
 *         &lt;element name="OrgnlEndToEndId" type="{urn:iso:std:iso:20022:tech:xsd:pain.002.003.03}Max35Text" minOccurs="0"/&gt;
 *         &lt;element name="TxSts" type="{urn:iso:std:iso:20022:tech:xsd:pain.002.003.03}TransactionIndividualStatusCodeSEPA" minOccurs="0"/&gt;
 *         &lt;element name="StsRsnInf" type="{urn:iso:std:iso:20022:tech:xsd:pain.002.003.03}StatusReasonInformationSEPA" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="OrgnlTxRef" type="{urn:iso:std:iso:20022:tech:xsd:pain.002.003.03}OriginalTransactionReferenceSEPA"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PaymentTransactionInformationSEPA", propOrder = {
    "stsId",
    "orgnlInstrId",
    "orgnlEndToEndId",
    "txSts",
    "stsRsnInf",
    "orgnlTxRef"
})
public class PaymentTransactionInformationSEPA {

    @XmlElement(name = "StsId")
    protected String stsId;
    @XmlElement(name = "OrgnlInstrId")
    protected String orgnlInstrId;
    @XmlElement(name = "OrgnlEndToEndId")
    protected String orgnlEndToEndId;
    @XmlElement(name = "TxSts")
    @XmlSchemaType(name = "string")
    protected TransactionIndividualStatusCodeSEPA txSts;
    @XmlElement(name = "StsRsnInf")
    protected List<StatusReasonInformationSEPA> stsRsnInf;
    @XmlElement(name = "OrgnlTxRef", required = true)
    protected OriginalTransactionReferenceSEPA orgnlTxRef;

    /**
     * Ruft den Wert der stsId-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStsId() {
        return stsId;
    }

    /**
     * Legt den Wert der stsId-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStsId(String value) {
        this.stsId = value;
    }

    /**
     * Ruft den Wert der orgnlInstrId-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrgnlInstrId() {
        return orgnlInstrId;
    }

    /**
     * Legt den Wert der orgnlInstrId-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrgnlInstrId(String value) {
        this.orgnlInstrId = value;
    }

    /**
     * Ruft den Wert der orgnlEndToEndId-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrgnlEndToEndId() {
        return orgnlEndToEndId;
    }

    /**
     * Legt den Wert der orgnlEndToEndId-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrgnlEndToEndId(String value) {
        this.orgnlEndToEndId = value;
    }

    /**
     * Ruft den Wert der txSts-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TransactionIndividualStatusCodeSEPA }
     *     
     */
    public TransactionIndividualStatusCodeSEPA getTxSts() {
        return txSts;
    }

    /**
     * Legt den Wert der txSts-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TransactionIndividualStatusCodeSEPA }
     *     
     */
    public void setTxSts(TransactionIndividualStatusCodeSEPA value) {
        this.txSts = value;
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
     * Ruft den Wert der orgnlTxRef-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link OriginalTransactionReferenceSEPA }
     *     
     */
    public OriginalTransactionReferenceSEPA getOrgnlTxRef() {
        return orgnlTxRef;
    }

    /**
     * Legt den Wert der orgnlTxRef-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link OriginalTransactionReferenceSEPA }
     *     
     */
    public void setOrgnlTxRef(OriginalTransactionReferenceSEPA value) {
        this.orgnlTxRef = value;
    }

}
