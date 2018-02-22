package com.springboot.rest.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.springboot.rest.data.CustomerData;

@Service
public class CustomerSeviceInMemoryimpl implements CustomerService {

	private Map<Long, CustomerData> customerDBMap = new HashMap<Long, CustomerData>();

	@Override
	public CustomerData createCustomer(final CustomerData customer) {
		if (customer != null) {
			customer.setId(System.currentTimeMillis());
			customerDBMap.put(customer.getId(), customer);
		}
		return customer;
	}

	@Override
	public void modifyCustomer(final CustomerData customer) {

		if (customerDBMap.containsKey(customer.getId())) {
			customerDBMap.put(customer.getId(), customer);
		} else {
			throw new RuntimeException("No Customer Found in the database");
		}
	}

	@Override
	public CustomerData findCustomer(Long key) {

		return customerDBMap.get(key);
	}

	@Override
	public List<CustomerData> searchCustomer(String firstName, String lastName) {
		// TODO Auto-generated method stub
		final List<CustomerData> result = new ArrayList<CustomerData>();
		final Collection<CustomerData> allCustomers = customerDBMap.values();
		for (CustomerData cData : allCustomers) {
			if (cData.getFirstName().toLowerCase().startsWith(firstName.toLowerCase())
					|| cData.getLastName().toLowerCase().startsWith(lastName.toLowerCase())) {
				result.add(cData);
			}
		}

		return result;

	}

	@Override
	public void removeCustomer(final Long key) {

		if (customerDBMap.containsKey(key)) {
			customerDBMap.remove(key);
		} else {
			throw new RuntimeException("NNo Customer Found in the database");
		}
		// TODO Auto-generated method stub

	}

}
