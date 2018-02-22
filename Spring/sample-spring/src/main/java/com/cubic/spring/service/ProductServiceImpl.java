package com.cubic.spring.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class ProductServiceImpl extends AbstractService implements ProductService {

	private Long productNumber;

	@Autowired
	@Qualifier("emailNS")
	private NotifyService emailService;

	@Autowired
	@Qualifier("htmlEmailNS")
	private NotifyService ns;

	@Autowired
	private PrinterUtil util;

	private List<String> manufactures;

	private List<Double> priceList;

	private Set<Vendor> vendors;

	private Map<Vendor, Double> vendorPriceMap;

	public ProductServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	public ProductServiceImpl(String version, String vendor) {
		super(version, vendor);
	}

	public ProductServiceImpl(Long productNumber, String vendor) {
		super(vendor);
		this.productNumber = productNumber;

	}

	public ProductServiceImpl(Long productNumber, String version, String vendor) {
		super(version, vendor);
		this.productNumber = productNumber;
	}

	public void initialze() {
		System.out.println("Init method is called");
	}

	@Override
	public ProductVO create(final ProductVO vo) {
		vo.setId("" + System.currentTimeMillis());
		vo.setVersion(getVersion());
		vo.setVendor(getVendor());
		vo.setProductNumber(this.getProductNumber());
		emailService.notifyCustomer();
		ns.notifyCustomer();

		if (this.getManufactures() != null) {
			System.out.println("Manufacturers: " + this.getManufactures());
		}
		util.print(" util printed");
		return vo;
	}

	public void clean() {
		System.out.println("calling destroy method");

	}

	public Long getProductNumber() {
		return productNumber;
	}

	public void setProductNumber(Long productNumber) {
		this.productNumber = productNumber;
	}

	public NotifyService getEmailService() {
		return emailService;
	}

	public void setEmailService(NotifyService emailService) {
		this.emailService = emailService;
	}

	public List<String> getManufactures() {
		return manufactures;
	}

	public void setManufactures(List<String> manufactures) {
		this.manufactures = manufactures;
	}

	public List<Double> getPriceList() {
		return priceList;
	}

	public void setPriceList(List<Double> priceList) {
		this.priceList = priceList;
	}

	public Set<Vendor> getVendors() {
		return vendors;
	}

	public void setVendors(Set<Vendor> vendors) {
		this.vendors = vendors;
	}

	public Map<Vendor, Double> getVendorPriceMap() {
		return vendorPriceMap;
	}

	public void setVendorPriceMap(Map<Vendor, Double> vendorPriceMap) {
		this.vendorPriceMap = vendorPriceMap;
	}

}
