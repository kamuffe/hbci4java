//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2019.06.19 um 02:06:58 PM CEST 
//


package org.kapott.hbci.sepa.jaxb.camt_052_001_06;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für DocumentType6Code.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="DocumentType6Code"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="MSIN"/&gt;
 *     &lt;enumeration value="CNFA"/&gt;
 *     &lt;enumeration value="DNFA"/&gt;
 *     &lt;enumeration value="CINV"/&gt;
 *     &lt;enumeration value="CREN"/&gt;
 *     &lt;enumeration value="DEBN"/&gt;
 *     &lt;enumeration value="HIRI"/&gt;
 *     &lt;enumeration value="SBIN"/&gt;
 *     &lt;enumeration value="CMCN"/&gt;
 *     &lt;enumeration value="SOAC"/&gt;
 *     &lt;enumeration value="DISP"/&gt;
 *     &lt;enumeration value="BOLD"/&gt;
 *     &lt;enumeration value="VCHR"/&gt;
 *     &lt;enumeration value="AROI"/&gt;
 *     &lt;enumeration value="TSUT"/&gt;
 *     &lt;enumeration value="PUOR"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "DocumentType6Code")
@XmlEnum
public enum DocumentType6Code {

    MSIN,
    CNFA,
    DNFA,
    CINV,
    CREN,
    DEBN,
    HIRI,
    SBIN,
    CMCN,
    SOAC,
    DISP,
    BOLD,
    VCHR,
    AROI,
    TSUT,
    PUOR;

    public String value() {
        return name();
    }

    public static DocumentType6Code fromValue(String v) {
        return valueOf(v);
    }

}
