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
 * <p>Java-Klasse für CardDataReading1Code.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="CardDataReading1Code"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="TAGC"/&gt;
 *     &lt;enumeration value="PHYS"/&gt;
 *     &lt;enumeration value="BRCD"/&gt;
 *     &lt;enumeration value="MGST"/&gt;
 *     &lt;enumeration value="CICC"/&gt;
 *     &lt;enumeration value="DFLE"/&gt;
 *     &lt;enumeration value="CTLS"/&gt;
 *     &lt;enumeration value="ECTL"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "CardDataReading1Code")
@XmlEnum
public enum CardDataReading1Code {

    TAGC,
    PHYS,
    BRCD,
    MGST,
    CICC,
    DFLE,
    CTLS,
    ECTL;

    public String value() {
        return name();
    }

    public static CardDataReading1Code fromValue(String v) {
        return valueOf(v);
    }

}
