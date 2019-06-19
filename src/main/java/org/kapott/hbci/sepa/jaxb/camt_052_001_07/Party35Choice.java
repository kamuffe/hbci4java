//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2019.06.19 um 02:06:57 PM CEST 
//


package org.kapott.hbci.sepa.jaxb.camt_052_001_07;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für Party35Choice complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="Party35Choice"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;choice&gt;
 *         &lt;element name="Pty" type="{urn:iso:std:iso:20022:tech:xsd:camt.052.001.07}PartyIdentification125"/&gt;
 *         &lt;element name="Agt" type="{urn:iso:std:iso:20022:tech:xsd:camt.052.001.07}BranchAndFinancialInstitutionIdentification5"/&gt;
 *       &lt;/choice&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Party35Choice", propOrder = {
    "pty",
    "agt"
})
public class Party35Choice {

    @XmlElement(name = "Pty")
    protected PartyIdentification125 pty;
    @XmlElement(name = "Agt")
    protected BranchAndFinancialInstitutionIdentification5 agt;

    /**
     * Ruft den Wert der pty-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PartyIdentification125 }
     *     
     */
    public PartyIdentification125 getPty() {
        return pty;
    }

    /**
     * Legt den Wert der pty-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PartyIdentification125 }
     *     
     */
    public void setPty(PartyIdentification125 value) {
        this.pty = value;
    }

    /**
     * Ruft den Wert der agt-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link BranchAndFinancialInstitutionIdentification5 }
     *     
     */
    public BranchAndFinancialInstitutionIdentification5 getAgt() {
        return agt;
    }

    /**
     * Legt den Wert der agt-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link BranchAndFinancialInstitutionIdentification5 }
     *     
     */
    public void setAgt(BranchAndFinancialInstitutionIdentification5 value) {
        this.agt = value;
    }

}
