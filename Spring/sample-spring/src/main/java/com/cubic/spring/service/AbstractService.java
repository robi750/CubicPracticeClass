package com.cubic.spring.service;

public abstract class AbstractService {
	private String version = "1.0";
	private String vendor;

	public AbstractService() {
		// TODO Auto-generated constructor stub
	}

	public AbstractService(String version, String vendor) {
		super();
		this.version = version;
		this.vendor = vendor;
	}

	public AbstractService(String vendor) {
		super();
		this.vendor = vendor;
	}

	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

}
