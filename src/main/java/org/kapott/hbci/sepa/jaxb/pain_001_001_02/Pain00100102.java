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
 * <p>Java-Klasse für pain.001.001.02 complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="pain.001.001.02"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="GrpHdr" type="{urn:sepade:xsd:pain.001.001.02}GroupHeader20"/&gt;
 *         &lt;element name="PmtInf" type="{urn:sepade:xsd:pain.001.001.02}PaymentInstructionInformation4"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "pain.001.001.02", propOrder = {
    "grpHdr",
    "pmtInf"
})
public class Pain00100102 {

    @XmlElement(name = "GrpHdr", required = true)
    protected GroupHeader20 grpHdr;
    @XmlElement(name = "PmtInf", required = true)
    protected PaymentInstructionInformation4 pmtInf;

    /**
     * Ruft den Wert der grpHdr-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link GroupHeader20 }
     *     
     */
    public GroupHeader20 getGrpHdr() {
        return grpHdr;
    }

    /**
     * Legt den Wert der grpHdr-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link GroupHeader20 }
     *     
     */
    public void setGrpHdr(GroupHeader20 value) {
        this.grpHdr = value;
    }

    /**
     * Ruft den Wert der pmtInf-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PaymentInstructionInformation4 }
     *     
     */
    public PaymentInstructionInformation4 getPmtInf() {
        return pmtInf;
    }

    /**
     * Legt den Wert der pmtInf-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PaymentInstructionInformation4 }
     *     
     */
    public void setPmtInf(PaymentInstructionInformation4 value) {
        this.pmtInf = value;
    }

}
