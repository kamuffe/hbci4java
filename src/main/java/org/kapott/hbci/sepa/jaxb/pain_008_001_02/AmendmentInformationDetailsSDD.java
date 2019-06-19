//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2019.06.19 um 02:07:02 PM CEST 
//


package org.kapott.hbci.sepa.jaxb.pain_008_001_02;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für AmendmentInformationDetailsSDD complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="AmendmentInformationDetailsSDD"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="OrgnlMndtId" type="{urn:iso:std:iso:20022:tech:xsd:pain.008.001.02}RestrictedIdentificationSEPA1" minOccurs="0"/&gt;
 *         &lt;element name="OrgnlCdtrSchmeId" type="{urn:iso:std:iso:20022:tech:xsd:pain.008.001.02}PartyIdentificationSEPA4" minOccurs="0"/&gt;
 *         &lt;element name="OrgnlDbtrAcct" type="{urn:iso:std:iso:20022:tech:xsd:pain.008.001.02}CashAccountSEPAMandate" minOccurs="0"/&gt;
 *         &lt;element name="OrgnlDbtrAgt" type="{urn:iso:std:iso:20022:tech:xsd:pain.008.001.02}BranchAndFinancialInstitutionIdentificationSEPA2" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AmendmentInformationDetailsSDD", propOrder = {
    "orgnlMndtId",
    "orgnlCdtrSchmeId",
    "orgnlDbtrAcct",
    "orgnlDbtrAgt"
})
public class AmendmentInformationDetailsSDD {

    @XmlElement(name = "OrgnlMndtId")
    protected String orgnlMndtId;
    @XmlElement(name = "OrgnlCdtrSchmeId")
    protected PartyIdentificationSEPA4 orgnlCdtrSchmeId;
    @XmlElement(name = "OrgnlDbtrAcct")
    protected CashAccountSEPAMandate orgnlDbtrAcct;
    @XmlElement(name = "OrgnlDbtrAgt")
    protected BranchAndFinancialInstitutionIdentificationSEPA2 orgnlDbtrAgt;

    /**
     * Ruft den Wert der orgnlMndtId-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrgnlMndtId() {
        return orgnlMndtId;
    }

    /**
     * Legt den Wert der orgnlMndtId-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrgnlMndtId(String value) {
        this.orgnlMndtId = value;
    }

    /**
     * Ruft den Wert der orgnlCdtrSchmeId-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PartyIdentificationSEPA4 }
     *     
     */
    public PartyIdentificationSEPA4 getOrgnlCdtrSchmeId() {
        return orgnlCdtrSchmeId;
    }

    /**
     * Legt den Wert der orgnlCdtrSchmeId-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PartyIdentificationSEPA4 }
     *     
     */
    public void setOrgnlCdtrSchmeId(PartyIdentificationSEPA4 value) {
        this.orgnlCdtrSchmeId = value;
    }

    /**
     * Ruft den Wert der orgnlDbtrAcct-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CashAccountSEPAMandate }
     *     
     */
    public CashAccountSEPAMandate getOrgnlDbtrAcct() {
        return orgnlDbtrAcct;
    }

    /**
     * Legt den Wert der orgnlDbtrAcct-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CashAccountSEPAMandate }
     *     
     */
    public void setOrgnlDbtrAcct(CashAccountSEPAMandate value) {
        this.orgnlDbtrAcct = value;
    }

    /**
     * Ruft den Wert der orgnlDbtrAgt-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link BranchAndFinancialInstitutionIdentificationSEPA2 }
     *     
     */
    public BranchAndFinancialInstitutionIdentificationSEPA2 getOrgnlDbtrAgt() {
        return orgnlDbtrAgt;
    }

    /**
     * Legt den Wert der orgnlDbtrAgt-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link BranchAndFinancialInstitutionIdentificationSEPA2 }
     *     
     */
    public void setOrgnlDbtrAgt(BranchAndFinancialInstitutionIdentificationSEPA2 value) {
        this.orgnlDbtrAgt = value;
    }

}
