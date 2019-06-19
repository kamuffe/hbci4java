//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2019.06.19 um 02:06:59 PM CEST 
//


package org.kapott.hbci.sepa.jaxb.camt_052_001_05;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für AuthenticationEntity1Code.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="AuthenticationEntity1Code"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="ICCD"/&gt;
 *     &lt;enumeration value="AGNT"/&gt;
 *     &lt;enumeration value="MERC"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "AuthenticationEntity1Code")
@XmlEnum
public enum AuthenticationEntity1Code {

    ICCD,
    AGNT,
    MERC;

    public String value() {
        return name();
    }

    public static AuthenticationEntity1Code fromValue(String v) {
        return valueOf(v);
    }

}
