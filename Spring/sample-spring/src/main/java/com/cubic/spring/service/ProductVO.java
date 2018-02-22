package com.cubic.spring.service;

public class ProductVO {

	private String id;
	private String name;
	private String version;
	private String vendor;
	private Long productNumber;

	public ProductVO() {
		// TODO Auto-generated constructor stub
	}

	public ProductVO(String name) {
		super();
		this.name = name;
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	public Long getProductNumber() {
		return productNumber;
	}

	public void setProductNumber(Long productNumber) {
		this.productNumber = productNumber;
	}

	@Override
	public String toString() {
		return "ProductVO [id=" + id + ", name=" + name + ", version=" + version + ", vendor=" + vendor
				+ ", productNumber=" + productNumber + "]";
	}

}
