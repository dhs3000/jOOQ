
package org.jooq.util.xml.jaxb;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TriggerActionTiming.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <pre>
 * &lt;simpleType name="TriggerActionTiming"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="BEFORE"/&gt;
 *     &lt;enumeration value="AFTER"/&gt;
 *     &lt;enumeration value="INSTEAD_OF"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "TriggerActionTiming")
@XmlEnum
public enum TriggerActionTiming {


    /**
     * Whether the trigger should fire BEFORE each {@link TriggerActionOrientation#ROW} or {@link TriggerActionOrientation#STATEMENT}.
     * 
     */
    BEFORE,

    /**
     * Whether the trigger should fire AFTER each {@link TriggerActionOrientation#ROW} or {@link TriggerActionOrientation#STATEMENT}.
     * 
     */
    AFTER,

    /**
     * Whether the trigger should fire INSTEAD OF each {@link TriggerActionOrientation#ROW} or {@link TriggerActionOrientation#STATEMENT}.
     * 
     */
    INSTEAD_OF;

    public String value() {
        return name();
    }

    public static TriggerActionTiming fromValue(String v) {
        return valueOf(v);
    }

}
