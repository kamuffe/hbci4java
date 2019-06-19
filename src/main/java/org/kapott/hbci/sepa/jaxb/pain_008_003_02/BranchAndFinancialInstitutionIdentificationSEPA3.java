//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2019.06.19 um 02:07:02 PM CEST 
//


package org.kapott.hbci.sepa.jaxb.pain_008_003_02;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für BranchAndFinancialInstitutionIdentificationSEPA3 complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="BranchAndFinancialInstitutionIdentificationSEPA3"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="FinInstnId" type="{urn:iso:std:iso:20022:tech:xsd:pain.008.003.02}FinancialInstitutionIdentificationSEPA3"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BranchAndFinancialInstitutionIdentificationSEPA3", propOrder = {
    "finInstnId"
})
public class BranchAndFinancialInstitutionIdentificationSEPA3 {

    @XmlElement(name = "FinInstnId", required = true)
    protected FinancialInstitutionIdentificationSEPA3 finInstnId;

    /**
     * Ruft den Wert der finInstnId-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link FinancialInstitutionIdentificationSEPA3 }
     *     
     */
    public FinancialInstitutionIdentificationSEPA3 getFinInstnId() {
        return finInstnId;
    }

    /**
     * Legt den Wert der finInstnId-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link FinancialInstitutionIdentificationSEPA3 }
     *     
     */
    public void setFinInstnId(FinancialInstitutionIdentificationSEPA3 value) {
        this.finInstnId = value;
    }

}
