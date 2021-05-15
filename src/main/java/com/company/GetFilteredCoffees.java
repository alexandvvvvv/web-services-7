
package com.company;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getFilteredCoffees complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getFilteredCoffees">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="filter" type="{http://company.com/}coffeeFilter" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getFilteredCoffees", propOrder = {
    "filter"
})
public class GetFilteredCoffees {

    protected CoffeeFilter filter;

    /**
     * Gets the value of the filter property.
     * 
     * @return
     *     possible object is
     *     {@link CoffeeFilter }
     *     
     */
    public CoffeeFilter getFilter() {
        return filter;
    }

    /**
     * Sets the value of the filter property.
     * 
     * @param value
     *     allowed object is
     *     {@link CoffeeFilter }
     *     
     */
    public void setFilter(CoffeeFilter value) {
        this.filter = value;
    }

}
