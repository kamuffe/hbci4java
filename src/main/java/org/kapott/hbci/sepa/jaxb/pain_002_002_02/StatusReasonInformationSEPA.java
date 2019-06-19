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
 * <p>Java-Klasse für StatusReasonInformationSEPA complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="StatusReasonInformationSEPA"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="StsOrgtr" type="{urn:swift:xsd:$pain.002.002.02}PartyIdentificationSEPA1" minOccurs="0"/&gt;
 *         &lt;element name="StsRsn" type="{urn:swift:xsd:$pain.002.002.02}StatusReason1Choice" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "StatusReasonInformationSEPA", propOrder = {
    "stsOrgtr",
    "stsRsn"
})
public class StatusReasonInformationSEPA {

    @XmlElement(name = "StsOrgtr")
    protected PartyIdentificationSEPA1 stsOrgtr;
    @XmlElement(name = "StsRsn")
    protected StatusReason1Choice stsRsn;

    /**
     * Ruft den Wert der stsOrgtr-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PartyIdentificationSEPA1 }
     *     
     */
    public PartyIdentificationSEPA1 getStsOrgtr() {
        return stsOrgtr;
    }

    /**
     * Legt den Wert der stsOrgtr-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PartyIdentificationSEPA1 }
     *     
     */
    public void setStsOrgtr(PartyIdentificationSEPA1 value) {
        this.stsOrgtr = value;
    }

    /**
     * Ruft den Wert der stsRsn-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link StatusReason1Choice }
     *     
     */
    public StatusReason1Choice getStsRsn() {
        return stsRsn;
    }

    /**
     * Legt den Wert der stsRsn-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link StatusReason1Choice }
     *     
     */
    public void setStsRsn(StatusReason1Choice value) {
        this.stsRsn = value;
    }

}
