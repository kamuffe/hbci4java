//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2019.06.19 um 02:07:01 PM CEST 
//


package org.kapott.hbci.sepa.jaxb.pain_008_002_01;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für OrganisationIdentificationSDDChoice complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="OrganisationIdentificationSDDChoice"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;choice&gt;
 *           &lt;element name="BIC" type="{urn:swift:xsd:$pain.008.002.01}BICIdentifier"/&gt;
 *           &lt;element name="IBEI" type="{urn:swift:xsd:$pain.008.002.01}IBEIIdentifier"/&gt;
 *           &lt;element name="BEI" type="{urn:swift:xsd:$pain.008.002.01}BEIIdentifier"/&gt;
 *           &lt;element name="EANGLN" type="{urn:swift:xsd:$pain.008.002.01}EANGLNIdentifier"/&gt;
 *           &lt;element name="USCHU" type="{urn:swift:xsd:$pain.008.002.01}CHIPSUniversalIdentifier"/&gt;
 *           &lt;element name="DUNS" type="{urn:swift:xsd:$pain.008.002.01}DunsIdentifier"/&gt;
 *           &lt;element name="BkPtyId" type="{urn:swift:xsd:$pain.008.002.01}Max35Text"/&gt;
 *           &lt;element name="TaxIdNb" type="{urn:swift:xsd:$pain.008.002.01}Max35Text"/&gt;
 *           &lt;element name="PrtryId" type="{urn:swift:xsd:$pain.008.002.01}GenericIdentification3"/&gt;
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
@XmlType(name = "OrganisationIdentificationSDDChoice", propOrder = {
    "bic",
    "ibei",
    "bei",
    "eangln",
    "uschu",
    "duns",
    "bkPtyId",
    "taxIdNb",
    "prtryId"
})
public class OrganisationIdentificationSDDChoice {

    @XmlElement(name = "BIC")
    protected String bic;
    @XmlElement(name = "IBEI")
    protected String ibei;
    @XmlElement(name = "BEI")
    protected String bei;
    @XmlElement(name = "EANGLN")
    protected String eangln;
    @XmlElement(name = "USCHU")
    protected String uschu;
    @XmlElement(name = "DUNS")
    protected String duns;
    @XmlElement(name = "BkPtyId")
    protected String bkPtyId;
    @XmlElement(name = "TaxIdNb")
    protected String taxIdNb;
    @XmlElement(name = "PrtryId")
    protected GenericIdentification3 prtryId;

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
     * Ruft den Wert der ibei-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIBEI() {
        return ibei;
    }

    /**
     * Legt den Wert der ibei-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIBEI(String value) {
        this.ibei = value;
    }

    /**
     * Ruft den Wert der bei-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBEI() {
        return bei;
    }

    /**
     * Legt den Wert der bei-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBEI(String value) {
        this.bei = value;
    }

    /**
     * Ruft den Wert der eangln-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEANGLN() {
        return eangln;
    }

    /**
     * Legt den Wert der eangln-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEANGLN(String value) {
        this.eangln = value;
    }

    /**
     * Ruft den Wert der uschu-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUSCHU() {
        return uschu;
    }

    /**
     * Legt den Wert der uschu-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUSCHU(String value) {
        this.uschu = value;
    }

    /**
     * Ruft den Wert der duns-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDUNS() {
        return duns;
    }

    /**
     * Legt den Wert der duns-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDUNS(String value) {
        this.duns = value;
    }

    /**
     * Ruft den Wert der bkPtyId-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBkPtyId() {
        return bkPtyId;
    }

    /**
     * Legt den Wert der bkPtyId-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBkPtyId(String value) {
        this.bkPtyId = value;
    }

    /**
     * Ruft den Wert der taxIdNb-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTaxIdNb() {
        return taxIdNb;
    }

    /**
     * Legt den Wert der taxIdNb-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTaxIdNb(String value) {
        this.taxIdNb = value;
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

}
