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
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für PartySEPAChoice complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="PartySEPAChoice"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;choice&gt;
 *           &lt;element name="OrgId" type="{urn:swift:xsd:$pain.002.002.02}OrganisationIdentificationSEPAChoice"/&gt;
 *           &lt;element name="PrvtId" type="{urn:swift:xsd:$pain.002.002.02}PersonIdentification3"/&gt;
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
@XmlType(name = "PartySEPAChoice", propOrder = {
    "orgId",
    "prvtId"
})
public class PartySEPAChoice {

    @XmlElement(name = "OrgId")
    protected OrganisationIdentificationSEPAChoice orgId;
    @XmlElement(name = "PrvtId")
    protected PersonIdentification3 prvtId;

    /**
     * Ruft den Wert der orgId-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link OrganisationIdentificationSEPAChoice }
     *     
     */
    public OrganisationIdentificationSEPAChoice getOrgId() {
        return orgId;
    }

    /**
     * Legt den Wert der orgId-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link OrganisationIdentificationSEPAChoice }
     *     
     */
    public void setOrgId(OrganisationIdentificationSEPAChoice value) {
        this.orgId = value;
    }

    /**
     * Ruft den Wert der prvtId-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PersonIdentification3 }
     *     
     */
    public PersonIdentification3 getPrvtId() {
        return prvtId;
    }

    /**
     * Legt den Wert der prvtId-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PersonIdentification3 }
     *     
     */
    public void setPrvtId(PersonIdentification3 value) {
        this.prvtId = value;
    }

}
