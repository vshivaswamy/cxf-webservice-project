
package org.abc.credit.service;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for creditBureauType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="creditBureauType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="TRANSUNION"/>
 *     &lt;enumeration value="EQUIFAX"/>
 *     &lt;enumeration value="EXPERIAN"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "creditBureauType")
@XmlEnum
public enum CreditBureauType {

    TRANSUNION,
    EQUIFAX,
    EXPERIAN;

    public String value() {
        return name();
    }

    public static CreditBureauType fromValue(String v) {
        return valueOf(v);
    }

}
