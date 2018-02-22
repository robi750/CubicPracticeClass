
package com.cubic.soap.product.service;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.cubic.soap.product.service package. 
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

    private final static QName _ProductSearchRequest_QNAME = new QName("http://com.cubic.net/productservice/1.0", "ProductSearchRequest");
    private final static QName _ProductSearchResponse_QNAME = new QName("http://com.cubic.net/productservice/1.0", "ProductSearchResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.cubic.soap.product.service
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ProductSearchCriteria }
     * 
     */
    public ProductSearchCriteria createProductSearchCriteria() {
        return new ProductSearchCriteria();
    }

    /**
     * Create an instance of {@link ProductSearchResponseType }
     * 
     */
    public ProductSearchResponseType createProductSearchResponseType() {
        return new ProductSearchResponseType();
    }

    /**
     * Create an instance of {@link ProductInfo }
     * 
     */
    public ProductInfo createProductInfo() {
        return new ProductInfo();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ProductSearchCriteria }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://com.cubic.net/productservice/1.0", name = "ProductSearchRequest")
    public JAXBElement<ProductSearchCriteria> createProductSearchRequest(ProductSearchCriteria value) {
        return new JAXBElement<ProductSearchCriteria>(_ProductSearchRequest_QNAME, ProductSearchCriteria.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ProductSearchResponseType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://com.cubic.net/productservice/1.0", name = "ProductSearchResponse")
    public JAXBElement<ProductSearchResponseType> createProductSearchResponse(ProductSearchResponseType value) {
        return new JAXBElement<ProductSearchResponseType>(_ProductSearchResponse_QNAME, ProductSearchResponseType.class, null, value);
    }

}
