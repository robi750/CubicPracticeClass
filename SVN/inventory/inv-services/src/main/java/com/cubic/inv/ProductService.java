package com.cubic.inv;

public class ProductService {

	private String productDetail;
	private String productMapper;
	private String productId;

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductDetail() {
		return productDetail;
	}

	public void setProductDetail(String productDetail) {
		this.productDetail = productDetail;
	}

	public String getProductMapper() {
		return productMapper;
	}

	public void setProductMapper(String productMapper) {
		this.productMapper = productMapper;
	}

	@Override
	public String toString() {
		return "ProductService [productDetail=" + productDetail + ", productMapper=" + productMapper + "]";
	}

}
