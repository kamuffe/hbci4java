//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2019.06.19 um 02:06:59 PM CEST 
//


package org.kapott.hbci.sepa.jaxb.camt_052_001_04;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für CardholderVerificationCapability1Code.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="CardholderVerificationCapability1Code"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="MNSG"/&gt;
 *     &lt;enumeration value="NPIN"/&gt;
 *     &lt;enumeration value="FCPN"/&gt;
 *     &lt;enumeration value="FEPN"/&gt;
 *     &lt;enumeration value="FDSG"/&gt;
 *     &lt;enumeration value="FBIO"/&gt;
 *     &lt;enumeration value="MNVR"/&gt;
 *     &lt;enumeration value="FBIG"/&gt;
 *     &lt;enumeration value="APKI"/&gt;
 *     &lt;enumeration value="PKIS"/&gt;
 *     &lt;enumeration value="CHDT"/&gt;
 *     &lt;enumeration value="SCEC"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "CardholderVerificationCapability1Code")
@XmlEnum
public enum CardholderVerificationCapability1Code {

    MNSG,
    NPIN,
    FCPN,
    FEPN,
    FDSG,
    FBIO,
    MNVR,
    FBIG,
    APKI,
    PKIS,
    CHDT,
    SCEC;

    public String value() {
        return name();
    }

    public static CardholderVerificationCapability1Code fromValue(String v) {
        return valueOf(v);
    }

}
