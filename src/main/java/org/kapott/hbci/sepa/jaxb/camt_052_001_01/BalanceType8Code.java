//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2019.06.19 um 02:07:00 PM CEST 
//


package org.kapott.hbci.sepa.jaxb.camt_052_001_01;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für BalanceType8Code.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="BalanceType8Code"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="OPBD"/&gt;
 *     &lt;enumeration value="ITBD"/&gt;
 *     &lt;enumeration value="CLBD"/&gt;
 *     &lt;enumeration value="XPCD"/&gt;
 *     &lt;enumeration value="OPAV"/&gt;
 *     &lt;enumeration value="ITAV"/&gt;
 *     &lt;enumeration value="CLAV"/&gt;
 *     &lt;enumeration value="FWAV"/&gt;
 *     &lt;enumeration value="PRCD"/&gt;
 *     &lt;enumeration value="IOPA"/&gt;
 *     &lt;enumeration value="IITA"/&gt;
 *     &lt;enumeration value="ICLA"/&gt;
 *     &lt;enumeration value="IFWA"/&gt;
 *     &lt;enumeration value="ICLB"/&gt;
 *     &lt;enumeration value="IITB"/&gt;
 *     &lt;enumeration value="IOPB"/&gt;
 *     &lt;enumeration value="IXPC"/&gt;
 *     &lt;enumeration value="DOPA"/&gt;
 *     &lt;enumeration value="DITA"/&gt;
 *     &lt;enumeration value="DCLA"/&gt;
 *     &lt;enumeration value="DFWA"/&gt;
 *     &lt;enumeration value="DCLB"/&gt;
 *     &lt;enumeration value="DITB"/&gt;
 *     &lt;enumeration value="DOPB"/&gt;
 *     &lt;enumeration value="DXPC"/&gt;
 *     &lt;enumeration value="COPA"/&gt;
 *     &lt;enumeration value="CITA"/&gt;
 *     &lt;enumeration value="CCLA"/&gt;
 *     &lt;enumeration value="CFWA"/&gt;
 *     &lt;enumeration value="CCLB"/&gt;
 *     &lt;enumeration value="CITB"/&gt;
 *     &lt;enumeration value="COPB"/&gt;
 *     &lt;enumeration value="CXPC"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "BalanceType8Code")
@XmlEnum
public enum BalanceType8Code {

    OPBD,
    ITBD,
    CLBD,
    XPCD,
    OPAV,
    ITAV,
    CLAV,
    FWAV,
    PRCD,
    IOPA,
    IITA,
    ICLA,
    IFWA,
    ICLB,
    IITB,
    IOPB,
    IXPC,
    DOPA,
    DITA,
    DCLA,
    DFWA,
    DCLB,
    DITB,
    DOPB,
    DXPC,
    COPA,
    CITA,
    CCLA,
    CFWA,
    CCLB,
    CITB,
    COPB,
    CXPC;

    public String value() {
        return name();
    }

    public static BalanceType8Code fromValue(String v) {
        return valueOf(v);
    }

}
