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
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für GenericIdentificationSEPA complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="GenericIdentificationSEPA"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Id" type="{urn:swift:xsd:$pain.002.002.02}RestrictedIdentification3"/&gt;
 *         &lt;element name="IdTp" type="{urn:swift:xsd:$pain.002.002.02}RestrictedSEPACode"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GenericIdentificationSEPA", propOrder = {
    "id",
    "idTp"
})
public class GenericIdentificationSEPA {

    @XmlElement(name = "Id", required = true)
    protected String id;
    @XmlElement(name = "IdTp", required = true)
    @XmlSchemaType(name = "string")
    protected RestrictedSEPACode idTp;

    /**
     * Ruft den Wert der id-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Legt den Wert der id-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Ruft den Wert der idTp-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link RestrictedSEPACode }
     *     
     */
    public RestrictedSEPACode getIdTp() {
        return idTp;
    }

    /**
     * Legt den Wert der idTp-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link RestrictedSEPACode }
     *     
     */
    public void setIdTp(RestrictedSEPACode value) {
        this.idTp = value;
    }

}
