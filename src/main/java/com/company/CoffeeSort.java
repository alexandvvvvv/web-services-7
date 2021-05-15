
package com.company;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for coffeeSort.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="coffeeSort">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="ARABIC"/>
 *     &lt;enumeration value="ROBUST"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "coffeeSort")
@XmlEnum
public enum CoffeeSort {

    ARABIC,
    ROBUST;

    public String value() {
        return name();
    }

    public static CoffeeSort fromValue(String v) {
        return valueOf(v);
    }

}
