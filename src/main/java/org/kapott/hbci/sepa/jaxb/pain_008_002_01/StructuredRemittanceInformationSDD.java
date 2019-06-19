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
 * <p>Java-Klasse für StructuredRemittanceInformationSDD complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="StructuredRemittanceInformationSDD"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="CdtrRefInf" type="{urn:swift:xsd:$pain.008.002.01}CreditorReferenceInformationSDD" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "StructuredRemittanceInformationSDD", propOrder = {
    "cdtrRefInf"
})
public class StructuredRemittanceInformationSDD {

    @XmlElement(name = "CdtrRefInf")
    protected CreditorReferenceInformationSDD cdtrRefInf;

    /**
     * Ruft den Wert der cdtrRefInf-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CreditorReferenceInformationSDD }
     *     
     */
    public CreditorReferenceInformationSDD getCdtrRefInf() {
        return cdtrRefInf;
    }

    /**
     * Legt den Wert der cdtrRefInf-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CreditorReferenceInformationSDD }
     *     
     */
    public void setCdtrRefInf(CreditorReferenceInformationSDD value) {
        this.cdtrRefInf = value;
    }

}
