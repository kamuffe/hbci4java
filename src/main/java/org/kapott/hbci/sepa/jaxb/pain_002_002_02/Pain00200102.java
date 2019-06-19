//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2019.06.19 um 02:07:01 PM CEST 
//


package org.kapott.hbci.sepa.jaxb.pain_002_002_02;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für pain.002.001.02 complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="pain.002.001.02"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="GrpHdr" type="{urn:swift:xsd:$pain.002.002.02}GroupHeaderSEPA"/&gt;
 *         &lt;element name="OrgnlGrpInfAndSts" type="{urn:swift:xsd:$pain.002.002.02}OriginalGroupInformationSEPA"/&gt;
 *         &lt;element name="TxInfAndSts" type="{urn:swift:xsd:$pain.002.002.02}PaymentTransactionInformationSEPA" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "pain.002.001.02", propOrder = {
    "grpHdr",
    "orgnlGrpInfAndSts",
    "txInfAndSts"
})
public class Pain00200102 {

    @XmlElement(name = "GrpHdr", required = true)
    protected GroupHeaderSEPA grpHdr;
    @XmlElement(name = "OrgnlGrpInfAndSts", required = true)
    protected OriginalGroupInformationSEPA orgnlGrpInfAndSts;
    @XmlElement(name = "TxInfAndSts")
    protected List<PaymentTransactionInformationSEPA> txInfAndSts;

    /**
     * Ruft den Wert der grpHdr-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link GroupHeaderSEPA }
     *     
     */
    public GroupHeaderSEPA getGrpHdr() {
        return grpHdr;
    }

    /**
     * Legt den Wert der grpHdr-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link GroupHeaderSEPA }
     *     
     */
    public void setGrpHdr(GroupHeaderSEPA value) {
        this.grpHdr = value;
    }

    /**
     * Ruft den Wert der orgnlGrpInfAndSts-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link OriginalGroupInformationSEPA }
     *     
     */
    public OriginalGroupInformationSEPA getOrgnlGrpInfAndSts() {
        return orgnlGrpInfAndSts;
    }

    /**
     * Legt den Wert der orgnlGrpInfAndSts-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link OriginalGroupInformationSEPA }
     *     
     */
    public void setOrgnlGrpInfAndSts(OriginalGroupInformationSEPA value) {
        this.orgnlGrpInfAndSts = value;
    }

    /**
     * Gets the value of the txInfAndSts property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the txInfAndSts property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTxInfAndSts().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PaymentTransactionInformationSEPA }
     * 
     * 
     */
    public List<PaymentTransactionInformationSEPA> getTxInfAndSts() {
        if (txInfAndSts == null) {
            txInfAndSts = new ArrayList<PaymentTransactionInformationSEPA>();
        }
        return this.txInfAndSts;
    }

}
