//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2019.06.19 um 02:07:01 PM CEST 
//


package org.kapott.hbci.sepa.jaxb.pain_008_002_01;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für LocalInstrumentCodeSDD.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="LocalInstrumentCodeSDD"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="B2B"/&gt;
 *     &lt;enumeration value="CORE"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "LocalInstrumentCodeSDD")
@XmlEnum
public enum LocalInstrumentCodeSDD {

    @XmlEnumValue("B2B")
    B_2_B("B2B"),
    CORE("CORE");
    private final String value;

    LocalInstrumentCodeSDD(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static LocalInstrumentCodeSDD fromValue(String v) {
        for (LocalInstrumentCodeSDD c: LocalInstrumentCodeSDD.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
