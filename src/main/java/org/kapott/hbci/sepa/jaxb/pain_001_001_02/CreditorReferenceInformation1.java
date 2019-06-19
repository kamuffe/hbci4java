//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2019.06.19 um 02:07:00 PM CEST 
//


package org.kapott.hbci.sepa.jaxb.pain_001_001_02;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für CreditorReferenceInformation1 complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="CreditorReferenceInformation1"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="CdtrRefTp" type="{urn:sepade:xsd:pain.001.001.02}CreditorReferenceType1" minOccurs="0"/&gt;
 *         &lt;element name="CdtrRef" type="{urn:sepade:xsd:pain.001.001.02}Max35Text" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CreditorReferenceInformation1", propOrder = {
    "cdtrRefTp",
    "cdtrRef"
})
public class CreditorReferenceInformation1 {

    @XmlElement(name = "CdtrRefTp")
    protected CreditorReferenceType1 cdtrRefTp;
    @XmlElement(name = "CdtrRef")
    protected String cdtrRef;

    /**
     * Ruft den Wert der cdtrRefTp-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CreditorReferenceType1 }
     *     
     */
    public CreditorReferenceType1 getCdtrRefTp() {
        return cdtrRefTp;
    }

    /**
     * Legt den Wert der cdtrRefTp-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CreditorReferenceType1 }
     *     
     */
    public void setCdtrRefTp(CreditorReferenceType1 value) {
        this.cdtrRefTp = value;
    }

    /**
     * Ruft den Wert der cdtrRef-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCdtrRef() {
        return cdtrRef;
    }

    /**
     * Legt den Wert der cdtrRef-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCdtrRef(String value) {
        this.cdtrRef = value;
    }

}
