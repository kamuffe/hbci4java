//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2019.06.19 um 02:07:01 PM CEST 
//


package org.kapott.hbci.sepa.jaxb.pain_002_002_02;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für OriginalGroupInformationSEPA complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="OriginalGroupInformationSEPA"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;choice&gt;
 *           &lt;element name="OrgnlMsgId" type="{urn:swift:xsd:$pain.002.002.02}RestrictedIdentification1"/&gt;
 *           &lt;element name="NtwkFileNm" type="{urn:swift:xsd:$pain.002.002.02}Max35Text"/&gt;
 *         &lt;/choice&gt;
 *         &lt;element name="OrgnlMsgNmId" type="{urn:swift:xsd:$pain.002.002.02}Max35Text"/&gt;
 *         &lt;element name="GrpSts" type="{urn:swift:xsd:$pain.002.002.02}TransactionGroupStatus1CodeSEPA" minOccurs="0"/&gt;
 *         &lt;element name="StsRsnInf" type="{urn:swift:xsd:$pain.002.002.02}StatusReasonInformationSEPA" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OriginalGroupInformationSEPA", propOrder = {
    "orgnlMsgId",
    "ntwkFileNm",
    "orgnlMsgNmId",
    "grpSts",
    "stsRsnInf"
})
public class OriginalGroupInformationSEPA {

    @XmlElement(name = "OrgnlMsgId")
    protected String orgnlMsgId;
    @XmlElement(name = "NtwkFileNm")
    protected String ntwkFileNm;
    @XmlElement(name = "OrgnlMsgNmId", required = true)
    protected String orgnlMsgNmId;
    @XmlElement(name = "GrpSts")
    @XmlSchemaType(name = "string")
    protected TransactionGroupStatus1CodeSEPA grpSts;
    @XmlElement(name = "StsRsnInf")
    protected List<StatusReasonInformationSEPA> stsRsnInf;

    /**
     * Ruft den Wert der orgnlMsgId-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrgnlMsgId() {
        return orgnlMsgId;
    }

    /**
     * Legt den Wert der orgnlMsgId-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrgnlMsgId(String value) {
        this.orgnlMsgId = value;
    }

    /**
     * Ruft den Wert der ntwkFileNm-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNtwkFileNm() {
        return ntwkFileNm;
    }

    /**
     * Legt den Wert der ntwkFileNm-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNtwkFileNm(String value) {
        this.ntwkFileNm = value;
    }

    /**
     * Ruft den Wert der orgnlMsgNmId-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrgnlMsgNmId() {
        return orgnlMsgNmId;
    }

    /**
     * Legt den Wert der orgnlMsgNmId-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrgnlMsgNmId(String value) {
        this.orgnlMsgNmId = value;
    }

    /**
     * Ruft den Wert der grpSts-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TransactionGroupStatus1CodeSEPA }
     *     
     */
    public TransactionGroupStatus1CodeSEPA getGrpSts() {
        return grpSts;
    }

    /**
     * Legt den Wert der grpSts-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TransactionGroupStatus1CodeSEPA }
     *     
     */
    public void setGrpSts(TransactionGroupStatus1CodeSEPA value) {
        this.grpSts = value;
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

}
