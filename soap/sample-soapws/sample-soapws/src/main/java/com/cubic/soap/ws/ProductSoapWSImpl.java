package com.cubic.soap.ws;


import java.math.BigInteger;

import javax.jws.WebService;

import com.cubic.soap.product.service.ProductInfo;
import com.cubic.soap.product.service.ProductSearchCriteria;
import com.cubic.soap.product.service.ProductSearchResponseType;
import com.cubic.soap.product.service.ProductServicePortType;

@WebService(name = "ProductService", serviceName = "ProductService", targetNamespace="http://com.cubic.net/productservice/1.0", portName="ProductServicePort", endpointInterface = "com.cubic.soap.product.service.ProductServicePortType", wsdlLocation = "WEB-INF/wsdl/ProductService.wsdl")
public class ProductSoapWSImpl implements ProductServicePortType {

	@Override
	public ProductSearchResponseType searchProduct(final ProductSearchCriteria searchCriteria) {
		// TODO Auto-generated method stub
		final ProductSearchResponseType response = new ProductSearchResponseType();
		response.getProductInfo().add(createProductInfo("Mouse", "Dell Optical Mouse", new BigInteger("1000")));
		response.getProductInfo().add(createProductInfo("Speaker", "Arman Speaker", new BigInteger("1001")));
		response.getProductInfo().add(createProductInfo("Laptop", "Sony Laptop", new BigInteger("1002")));
		response.getProductInfo().add(createProductInfo("Office Chair", "Office Chair", new BigInteger("1003")));
		return response;
	}

	private ProductInfo createProductInfo(final String productName, final String productDesc, final BigInteger id) {
		// TODO Auto-generated method stub
		final ProductInfo result = new ProductInfo();
		result.setProductName(productName);
		result.setProductDesc(productDesc);
		result.setProductId(id);
		return result;
	}

}
