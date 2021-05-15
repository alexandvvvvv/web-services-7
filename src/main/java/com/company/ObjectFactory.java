
package com.company;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.company package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetCoffees_QNAME = new QName("http://company.com/", "getCoffees");
    private final static QName _GetFilteredCoffees_QNAME = new QName("http://company.com/", "getFilteredCoffees");
    private final static QName _GetCoffeesResponse_QNAME = new QName("http://company.com/", "getCoffeesResponse");
    private final static QName _GetFilteredCoffeesResponse_QNAME = new QName("http://company.com/", "getFilteredCoffeesResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.company
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetFilteredCoffees }
     * 
     */
    public GetFilteredCoffees createGetFilteredCoffees() {
        return new GetFilteredCoffees();
    }

    /**
     * Create an instance of {@link GetCoffeesResponse }
     * 
     */
    public GetCoffeesResponse createGetCoffeesResponse() {
        return new GetCoffeesResponse();
    }

    /**
     * Create an instance of {@link GetFilteredCoffeesResponse }
     * 
     */
    public GetFilteredCoffeesResponse createGetFilteredCoffeesResponse() {
        return new GetFilteredCoffeesResponse();
    }

    /**
     * Create an instance of {@link GetCoffees }
     * 
     */
    public GetCoffees createGetCoffees() {
        return new GetCoffees();
    }

    /**
     * Create an instance of {@link Coffee }
     * 
     */
    public Coffee createCoffee() {
        return new Coffee();
    }

    /**
     * Create an instance of {@link CoffeeFilter }
     * 
     */
    public CoffeeFilter createCoffeeFilter() {
        return new CoffeeFilter();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCoffees }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://company.com/", name = "getCoffees")
    public JAXBElement<GetCoffees> createGetCoffees(GetCoffees value) {
        return new JAXBElement<GetCoffees>(_GetCoffees_QNAME, GetCoffees.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetFilteredCoffees }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://company.com/", name = "getFilteredCoffees")
    public JAXBElement<GetFilteredCoffees> createGetFilteredCoffees(GetFilteredCoffees value) {
        return new JAXBElement<GetFilteredCoffees>(_GetFilteredCoffees_QNAME, GetFilteredCoffees.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCoffeesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://company.com/", name = "getCoffeesResponse")
    public JAXBElement<GetCoffeesResponse> createGetCoffeesResponse(GetCoffeesResponse value) {
        return new JAXBElement<GetCoffeesResponse>(_GetCoffeesResponse_QNAME, GetCoffeesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetFilteredCoffeesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://company.com/", name = "getFilteredCoffeesResponse")
    public JAXBElement<GetFilteredCoffeesResponse> createGetFilteredCoffeesResponse(GetFilteredCoffeesResponse value) {
        return new JAXBElement<GetFilteredCoffeesResponse>(_GetFilteredCoffeesResponse_QNAME, GetFilteredCoffeesResponse.class, null, value);
    }

}
