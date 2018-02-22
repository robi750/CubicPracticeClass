package com.springboot.rest.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.springboot.rest.data.CustomerData;
import com.springboot.rest.entity.CustomerEntity;
import com.springboot.rest.exception.CustomerNotfoundException;
import com.springboot.rest.exception.InvalidDataException;
import com.springboot.rest.repo.CustomerRepo;
import com.springboot.rest.resource.CustomerWS;

@Service("csSpringData")
@Transactional
public class CustomerServiceSpringDataImpl implements CustomerService {
	
	private Logger logger = LoggerFactory.getLogger(CustomerServiceSpringDataImpl.class);

	@Autowired
	private CustomerRepo repo;

	@Autowired
	private CustomerMapper mapper;

	@Override
	public CustomerData createCustomer(final CustomerData customer) {
		
		logger.debug("Entering CustomerServiceSpringDataImpl.createCustomer");

		if (customer == null || StringUtils.isEmpty(customer.getFirstName())
				|| StringUtils.isEmpty(customer.getLastName())) {
			logger.debug("Invalid input values. Throwing exception");
			throw new InvalidDataException("Customer creation failed. A valid first name and last name is required.");
		}
		final CustomerEntity entity = mapper.mapToCustomerEntity(customer);
		repo.save(entity);
		customer.setId(entity.getPk());
		logger.debug("Customer Created. PK =();",customer.getId());
		logger.debug("Existing CustomerServiceSpringDataImpl.createCustomer");
		return customer;
	}

	@Override
	public void modifyCustomer(final CustomerData customer) {
		if (customer == null || customer.getId() == null || StringUtils.isEmpty(customer.getFirstName())
				|| StringUtils.isEmpty(customer.getLastName())) {
			throw new InvalidDataException("Customer creation failed. A valid first name and last name is required.");
		}

		CustomerEntity entity = findCustomerEntity(customer.getId());
		entity = mapper.mapToCustomerEntity(entity, customer);
		repo.save(entity);
	}

	@Override
	public CustomerData findCustomer(Long id) {
		if (id == null) {
			throw new InvalidDataException("Id is required to find customer.");
		}
		CustomerEntity entity = findCustomerEntity(id);
		return mapper.mapToCustomerData(entity);
	}

	@Override
	public List<CustomerData> searchCustomer(String firstName, String lastName) {

		final String fName = (firstName == null) ? "%" : firstName.trim() + "%";
		final String lName = (lastName == null) ? "%" : lastName.trim() + "%";

		final List<CustomerEntity> entities = repo.search(fName, lName);
		return mapper.mapToCustomerDataList(entities);
	}

	@Override
	public void removeCustomer(Long id) {
		if (id == null) {
			throw new InvalidDataException("Id is required to remove customer.");
		}
		repo.delete(id);

	}

	private CustomerEntity findCustomerEntity(final Long id) {
		CustomerEntity entity = repo.findOne(id);
		if (entity == null) {
			throw new CustomerNotfoundException("Customer was not found in the System.");
		}
		return entity;
	}

}
