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
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für CreditorReferenceTypeSDD complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CreditorReferenceTypeSDD"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Cd" type="{urn:swift:xsd:$pain.008.002.01}DocumentType3CodeSDD"/&gt;
 *         &lt;element name="Issr" type="{urn:swift:xsd:$pain.008.002.01}Max35Text" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CreditorReferenceTypeSDD", propOrder = {
    "cd",
    "issr"
})
public class CreditorReferenceTypeSDD {

    @XmlElement(name = "Cd", required = true)
    @XmlSchemaType(name = "string")
    protected DocumentType3CodeSDD cd;
    @XmlElement(name = "Issr")
    protected String issr;

    /**
     * Ruft den Wert der cd-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link DocumentType3CodeSDD }
     *     
     */
    public DocumentType3CodeSDD getCd() {
        return cd;
    }

    /**
     * Legt den Wert der cd-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link DocumentType3CodeSDD }
     *     
     */
    public void setCd(DocumentType3CodeSDD value) {
        this.cd = value;
    }

    /**
     * Ruft den Wert der issr-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIssr() {
        return issr;
    }

    /**
     * Legt den Wert der issr-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIssr(String value) {
        this.issr = value;
    }

}
