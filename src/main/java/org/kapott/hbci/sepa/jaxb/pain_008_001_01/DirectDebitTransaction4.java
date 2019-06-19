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
 * <p>Java-Klasse für DirectDebitTransaction4 complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="DirectDebitTransaction4"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="MndtRltdInf" type="{urn:sepade:xsd:pain.008.001.01}MandateRelatedInformation4"/&gt;
 *         &lt;element name="CdtrSchmeId" type="{urn:sepade:xsd:pain.008.001.01}PartyIdentification11"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DirectDebitTransaction4", propOrder = {
    "mndtRltdInf",
    "cdtrSchmeId"
})
public class DirectDebitTransaction4 {

    @XmlElement(name = "MndtRltdInf", required = true)
    protected MandateRelatedInformation4 mndtRltdInf;
    @XmlElement(name = "CdtrSchmeId", required = true)
    protected PartyIdentification11 cdtrSchmeId;

    /**
     * Ruft den Wert der mndtRltdInf-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link MandateRelatedInformation4 }
     *     
     */
    public MandateRelatedInformation4 getMndtRltdInf() {
        return mndtRltdInf;
    }

    /**
     * Legt den Wert der mndtRltdInf-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link MandateRelatedInformation4 }
     *     
     */
    public void setMndtRltdInf(MandateRelatedInformation4 value) {
        this.mndtRltdInf = value;
    }

    /**
     * Ruft den Wert der cdtrSchmeId-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PartyIdentification11 }
     *     
     */
    public PartyIdentification11 getCdtrSchmeId() {
        return cdtrSchmeId;
    }

    /**
     * Legt den Wert der cdtrSchmeId-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PartyIdentification11 }
     *     
     */
    public void setCdtrSchmeId(PartyIdentification11 value) {
        this.cdtrSchmeId = value;
    }

}
