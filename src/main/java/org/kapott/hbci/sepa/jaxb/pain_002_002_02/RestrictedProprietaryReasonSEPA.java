//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2019.06.19 um 02:07:01 PM CEST 
//


package org.kapott.hbci.sepa.jaxb.pain_002_002_02;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für RestrictedProprietaryReasonSEPA.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="RestrictedProprietaryReasonSEPA"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="RR01"/&gt;
 *     &lt;enumeration value="SL01"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "RestrictedProprietaryReasonSEPA")
@XmlEnum
public enum RestrictedProprietaryReasonSEPA {

    @XmlEnumValue("RR01")
    RR_01("RR01"),
    @XmlEnumValue("SL01")
    SL_01("SL01");
    private final String value;

    RestrictedProprietaryReasonSEPA(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static RestrictedProprietaryReasonSEPA fromValue(String v) {
        for (RestrictedProprietaryReasonSEPA c: RestrictedProprietaryReasonSEPA.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
