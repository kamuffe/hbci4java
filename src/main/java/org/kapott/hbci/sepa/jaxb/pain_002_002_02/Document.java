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
 * <p>Java-Klasse für Document complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="Document"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="pain.002.001.02" type="{urn:swift:xsd:$pain.002.002.02}pain.002.001.02"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Document", propOrder = {
    "pain00200102"
})
public class Document {

    @XmlElement(name = "pain.002.001.02", required = true)
    protected Pain00200102 pain00200102;

    /**
     * Ruft den Wert der pain00200102-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Pain00200102 }
     *     
     */
    public Pain00200102 getPain00200102() {
        return pain00200102;
    }

    /**
     * Legt den Wert der pain00200102-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Pain00200102 }
     *     
     */
    public void setPain00200102(Pain00200102 value) {
        this.pain00200102 = value;
    }

}
