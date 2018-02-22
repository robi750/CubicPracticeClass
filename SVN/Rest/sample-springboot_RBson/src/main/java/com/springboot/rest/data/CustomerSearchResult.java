package com.springboot.rest.data;

import java.util.List;

public class CustomerSearchResult {
	private List<CustomerData> customers;

	public CustomerSearchResult() {

	}

	public CustomerSearchResult(List<CustomerData> customers) {
		super();
		this.customers = customers;
	}

	public List<CustomerData> getCustomers() {
		return customers;
	}

	public void setCustomers(List<CustomerData> customers) {
		this.customers = customers;
	}

}
