
package com.company;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for coffee complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="coffee">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="cost" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="country" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sort" type="{http://company.com/}coffeeSort" minOccurs="0"/>
 *         &lt;element name="strength" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "coffee", propOrder = {
    "cost",
    "country",
    "name",
    "sort",
    "strength"
})
public class Coffee {

    protected Integer cost;
    protected String country;
    protected String name;
    @XmlSchemaType(name = "string")
    protected CoffeeSort sort;
    protected Integer strength;

    /**
     * Gets the value of the cost property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCost() {
        return cost;
    }

    /**
     * Sets the value of the cost property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCost(Integer value) {
        this.cost = value;
    }

    /**
     * Gets the value of the country property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCountry() {
        return country;
    }

    /**
     * Sets the value of the country property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCountry(String value) {
        this.country = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the sort property.
     * 
     * @return
     *     possible object is
     *     {@link CoffeeSort }
     *     
     */
    public CoffeeSort getSort() {
        return sort;
    }

    /**
     * Sets the value of the sort property.
     * 
     * @param value
     *     allowed object is
     *     {@link CoffeeSort }
     *     
     */
    public void setSort(CoffeeSort value) {
        this.sort = value;
    }

    /**
     * Gets the value of the strength property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getStrength() {
        return strength;
    }

    /**
     * Sets the value of the strength property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setStrength(Integer value) {
        this.strength = value;
    }

}
