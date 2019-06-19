//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2019.06.19 um 02:07:01 PM CEST 
//


package org.kapott.hbci.sepa.jaxb.pain_008_001_01;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für PersonIdentification4 complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="PersonIdentification4"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="OthrId" type="{urn:sepade:xsd:pain.008.001.01}RestrictedIdentification2"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PersonIdentification4", propOrder = {
    "othrId"
})
public class PersonIdentification4 {

    @XmlElement(name = "OthrId", required = true)
    protected RestrictedIdentification2 othrId;

    /**
     * Ruft den Wert der othrId-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link RestrictedIdentification2 }
     *     
     */
    public RestrictedIdentification2 getOthrId() {
        return othrId;
    }

    /**
     * Legt den Wert der othrId-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link RestrictedIdentification2 }
     *     
     */
    public void setOthrId(RestrictedIdentification2 value) {
        this.othrId = value;
    }

}
