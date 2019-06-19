//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2019.06.19 um 02:07:01 PM CEST 
//


package org.kapott.hbci.sepa.jaxb.pain_002_003_03;

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
 *         &lt;element name="Orgtr" type="{urn:iso:std:iso:20022:tech:xsd:pain.002.003.03}PartyIdentificationSEPA6Choice" minOccurs="0"/&gt;
 *         &lt;element name="Rsn" type="{urn:iso:std:iso:20022:tech:xsd:pain.002.003.03}StatusReasonSEPA" minOccurs="0"/&gt;
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
    "orgtr",
    "rsn"
})
public class StatusReasonInformationSEPA {

    @XmlElement(name = "Orgtr")
    protected PartyIdentificationSEPA6Choice orgtr;
    @XmlElement(name = "Rsn")
    protected StatusReasonSEPA rsn;

    /**
     * Ruft den Wert der orgtr-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PartyIdentificationSEPA6Choice }
     *     
     */
    public PartyIdentificationSEPA6Choice getOrgtr() {
        return orgtr;
    }

    /**
     * Legt den Wert der orgtr-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PartyIdentificationSEPA6Choice }
     *     
     */
    public void setOrgtr(PartyIdentificationSEPA6Choice value) {
        this.orgtr = value;
    }

    /**
     * Ruft den Wert der rsn-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link StatusReasonSEPA }
     *     
     */
    public StatusReasonSEPA getRsn() {
        return rsn;
    }

    /**
     * Legt den Wert der rsn-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link StatusReasonSEPA }
     *     
     */
    public void setRsn(StatusReasonSEPA value) {
        this.rsn = value;
    }

}
