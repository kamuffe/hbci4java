//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2019.06.19 um 02:07:02 PM CEST 
//


package org.kapott.hbci.sepa.jaxb.pain_008_003_02;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für OrganisationIdentificationSEPAChoice complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="OrganisationIdentificationSEPAChoice"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;choice&gt;
 *           &lt;element name="BICOrBEI" type="{urn:iso:std:iso:20022:tech:xsd:pain.008.003.02}AnyBICIdentifier"/&gt;
 *           &lt;element name="Othr" type="{urn:iso:std:iso:20022:tech:xsd:pain.008.003.02}GenericOrganisationIdentification1"/&gt;
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
@XmlType(name = "OrganisationIdentificationSEPAChoice", propOrder = {
    "bicOrBEI",
    "othr"
})
public class OrganisationIdentificationSEPAChoice {

    @XmlElement(name = "BICOrBEI")
    protected String bicOrBEI;
    @XmlElement(name = "Othr")
    protected GenericOrganisationIdentification1 othr;

    /**
     * Ruft den Wert der bicOrBEI-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBICOrBEI() {
        return bicOrBEI;
    }

    /**
     * Legt den Wert der bicOrBEI-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBICOrBEI(String value) {
        this.bicOrBEI = value;
    }

    /**
     * Ruft den Wert der othr-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link GenericOrganisationIdentification1 }
     *     
     */
    public GenericOrganisationIdentification1 getOthr() {
        return othr;
    }

    /**
     * Legt den Wert der othr-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link GenericOrganisationIdentification1 }
     *     
     */
    public void setOthr(GenericOrganisationIdentification1 value) {
        this.othr = value;
    }

}
