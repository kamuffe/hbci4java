//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2019.06.19 um 02:07:00 PM CEST 
//


package org.kapott.hbci.sepa.jaxb.camt_052_001_02;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für BankToCustomerAccountReportV02 complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="BankToCustomerAccountReportV02"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="GrpHdr" type="{urn:iso:std:iso:20022:tech:xsd:camt.052.001.02}GroupHeader42"/&gt;
 *         &lt;element name="Rpt" type="{urn:iso:std:iso:20022:tech:xsd:camt.052.001.02}AccountReport11" maxOccurs="unbounded"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BankToCustomerAccountReportV02", propOrder = {
    "grpHdr",
    "rpt"
})
public class BankToCustomerAccountReportV02 {

    @XmlElement(name = "GrpHdr", required = true)
    protected GroupHeader42 grpHdr;
    @XmlElement(name = "Rpt", required = true)
    protected List<AccountReport11> rpt;

    /**
     * Ruft den Wert der grpHdr-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link GroupHeader42 }
     *     
     */
    public GroupHeader42 getGrpHdr() {
        return grpHdr;
    }

    /**
     * Legt den Wert der grpHdr-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link GroupHeader42 }
     *     
     */
    public void setGrpHdr(GroupHeader42 value) {
        this.grpHdr = value;
    }

    /**
     * Gets the value of the rpt property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the rpt property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRpt().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AccountReport11 }
     * 
     * 
     */
    public List<AccountReport11> getRpt() {
        if (rpt == null) {
            rpt = new ArrayList<AccountReport11>();
        }
        return this.rpt;
    }

}
