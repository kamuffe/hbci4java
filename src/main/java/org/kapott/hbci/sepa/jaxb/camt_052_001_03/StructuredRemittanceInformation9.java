//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2019.06.19 um 02:06:59 PM CEST 
//


package org.kapott.hbci.sepa.jaxb.camt_052_001_03;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für StructuredRemittanceInformation9 complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="StructuredRemittanceInformation9"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="RfrdDocInf" type="{urn:iso:std:iso:20022:tech:xsd:camt.052.001.03}ReferredDocumentInformation3" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="RfrdDocAmt" type="{urn:iso:std:iso:20022:tech:xsd:camt.052.001.03}RemittanceAmount2" minOccurs="0"/&gt;
 *         &lt;element name="CdtrRefInf" type="{urn:iso:std:iso:20022:tech:xsd:camt.052.001.03}CreditorReferenceInformation2" minOccurs="0"/&gt;
 *         &lt;element name="Invcr" type="{urn:iso:std:iso:20022:tech:xsd:camt.052.001.03}PartyIdentification43" minOccurs="0"/&gt;
 *         &lt;element name="Invcee" type="{urn:iso:std:iso:20022:tech:xsd:camt.052.001.03}PartyIdentification43" minOccurs="0"/&gt;
 *         &lt;element name="AddtlRmtInf" type="{urn:iso:std:iso:20022:tech:xsd:camt.052.001.03}Max140Text" maxOccurs="3" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "StructuredRemittanceInformation9", propOrder = {
    "rfrdDocInf",
    "rfrdDocAmt",
    "cdtrRefInf",
    "invcr",
    "invcee",
    "addtlRmtInf"
})
public class StructuredRemittanceInformation9 {

    @XmlElement(name = "RfrdDocInf")
    protected List<ReferredDocumentInformation3> rfrdDocInf;
    @XmlElement(name = "RfrdDocAmt")
    protected RemittanceAmount2 rfrdDocAmt;
    @XmlElement(name = "CdtrRefInf")
    protected CreditorReferenceInformation2 cdtrRefInf;
    @XmlElement(name = "Invcr")
    protected PartyIdentification43 invcr;
    @XmlElement(name = "Invcee")
    protected PartyIdentification43 invcee;
    @XmlElement(name = "AddtlRmtInf")
    protected List<String> addtlRmtInf;

    /**
     * Gets the value of the rfrdDocInf property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the rfrdDocInf property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRfrdDocInf().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ReferredDocumentInformation3 }
     * 
     * 
     */
    public List<ReferredDocumentInformation3> getRfrdDocInf() {
        if (rfrdDocInf == null) {
            rfrdDocInf = new ArrayList<ReferredDocumentInformation3>();
        }
        return this.rfrdDocInf;
    }

    /**
     * Ruft den Wert der rfrdDocAmt-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link RemittanceAmount2 }
     *     
     */
    public RemittanceAmount2 getRfrdDocAmt() {
        return rfrdDocAmt;
    }

    /**
     * Legt den Wert der rfrdDocAmt-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link RemittanceAmount2 }
     *     
     */
    public void setRfrdDocAmt(RemittanceAmount2 value) {
        this.rfrdDocAmt = value;
    }

    /**
     * Ruft den Wert der cdtrRefInf-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CreditorReferenceInformation2 }
     *     
     */
    public CreditorReferenceInformation2 getCdtrRefInf() {
        return cdtrRefInf;
    }

    /**
     * Legt den Wert der cdtrRefInf-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CreditorReferenceInformation2 }
     *     
     */
    public void setCdtrRefInf(CreditorReferenceInformation2 value) {
        this.cdtrRefInf = value;
    }

    /**
     * Ruft den Wert der invcr-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PartyIdentification43 }
     *     
     */
    public PartyIdentification43 getInvcr() {
        return invcr;
    }

    /**
     * Legt den Wert der invcr-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PartyIdentification43 }
     *     
     */
    public void setInvcr(PartyIdentification43 value) {
        this.invcr = value;
    }

    /**
     * Ruft den Wert der invcee-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PartyIdentification43 }
     *     
     */
    public PartyIdentification43 getInvcee() {
        return invcee;
    }

    /**
     * Legt den Wert der invcee-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PartyIdentification43 }
     *     
     */
    public void setInvcee(PartyIdentification43 value) {
        this.invcee = value;
    }

    /**
     * Gets the value of the addtlRmtInf property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the addtlRmtInf property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAddtlRmtInf().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getAddtlRmtInf() {
        if (addtlRmtInf == null) {
            addtlRmtInf = new ArrayList<String>();
        }
        return this.addtlRmtInf;
    }

}
