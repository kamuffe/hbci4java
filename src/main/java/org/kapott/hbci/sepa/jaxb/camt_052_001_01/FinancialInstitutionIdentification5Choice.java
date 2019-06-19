//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2019.06.19 um 02:07:00 PM CEST 
//


package org.kapott.hbci.sepa.jaxb.camt_052_001_01;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für FinancialInstitutionIdentification5Choice complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="FinancialInstitutionIdentification5Choice"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;choice&gt;
 *           &lt;element name="BIC" type="{urn:iso:std:iso:20022:tech:xsd:camt.052.001.01}BICIdentifier"/&gt;
 *           &lt;element name="ClrSysMmbId" type="{urn:iso:std:iso:20022:tech:xsd:camt.052.001.01}ClearingSystemMemberIdentification3Choice"/&gt;
 *           &lt;element name="NmAndAdr" type="{urn:iso:std:iso:20022:tech:xsd:camt.052.001.01}NameAndAddress7"/&gt;
 *           &lt;element name="PrtryId" type="{urn:iso:std:iso:20022:tech:xsd:camt.052.001.01}GenericIdentification3"/&gt;
 *           &lt;element name="CmbndId" type="{urn:iso:std:iso:20022:tech:xsd:camt.052.001.01}FinancialInstitutionIdentification3"/&gt;
 *         &lt;/choice&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FinancialInstitutionIdentification5Choice", propOrder = {
    "bic",
    "clrSysMmbId",
    "nmAndAdr",
    "prtryId",
    "cmbndId"
})
public class FinancialInstitutionIdentification5Choice {

    @XmlElement(name = "BIC")
    protected String bic;
    @XmlElement(name = "ClrSysMmbId")
    protected ClearingSystemMemberIdentification3Choice clrSysMmbId;
    @XmlElement(name = "NmAndAdr")
    protected NameAndAddress7 nmAndAdr;
    @XmlElement(name = "PrtryId")
    protected GenericIdentification3 prtryId;
    @XmlElement(name = "CmbndId")
    protected FinancialInstitutionIdentification3 cmbndId;

    /**
     * Ruft den Wert der bic-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBIC() {
        return bic;
    }

    /**
     * Legt den Wert der bic-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBIC(String value) {
        this.bic = value;
    }

    /**
     * Ruft den Wert der clrSysMmbId-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ClearingSystemMemberIdentification3Choice }
     *     
     */
    public ClearingSystemMemberIdentification3Choice getClrSysMmbId() {
        return clrSysMmbId;
    }

    /**
     * Legt den Wert der clrSysMmbId-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ClearingSystemMemberIdentification3Choice }
     *     
     */
    public void setClrSysMmbId(ClearingSystemMemberIdentification3Choice value) {
        this.clrSysMmbId = value;
    }

    /**
     * Ruft den Wert der nmAndAdr-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link NameAndAddress7 }
     *     
     */
    public NameAndAddress7 getNmAndAdr() {
        return nmAndAdr;
    }

    /**
     * Legt den Wert der nmAndAdr-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link NameAndAddress7 }
     *     
     */
    public void setNmAndAdr(NameAndAddress7 value) {
        this.nmAndAdr = value;
    }

    /**
     * Ruft den Wert der prtryId-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link GenericIdentification3 }
     *     
     */
    public GenericIdentification3 getPrtryId() {
        return prtryId;
    }

    /**
     * Legt den Wert der prtryId-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link GenericIdentification3 }
     *     
     */
    public void setPrtryId(GenericIdentification3 value) {
        this.prtryId = value;
    }

    /**
     * Ruft den Wert der cmbndId-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link FinancialInstitutionIdentification3 }
     *     
     */
    public FinancialInstitutionIdentification3 getCmbndId() {
        return cmbndId;
    }

    /**
     * Legt den Wert der cmbndId-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link FinancialInstitutionIdentification3 }
     *     
     */
    public void setCmbndId(FinancialInstitutionIdentification3 value) {
        this.cmbndId = value;
    }

}
