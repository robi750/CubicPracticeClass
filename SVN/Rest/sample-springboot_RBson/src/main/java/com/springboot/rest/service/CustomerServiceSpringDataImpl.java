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
import com.springboot.rest.exception.CustomerNotFoundException;
import com.springboot.rest.exception.InvalidDataException;
import com.springboot.rest.repo.CustomerRepo;

@Service("csSpringData")
@Transactional
public class CustomerServiceSpringDataImpl implements CustomerService {

	private final static Logger Logger = LoggerFactory.getLogger(CustomerServiceSpringDataImpl.class);
	
	@Autowired
	private CustomerRepo repo;

	@Autowired
	private CustomerMapper mapper;

	@Override
	public CustomerData createCustomer(final CustomerData customer) {
		// TODO Auto-generated method stub
		Logger.debug("Entering CustomerServiceSpringDataImpl.createCustomer");
		if (customer == null || StringUtils.isEmpty(customer.getFirstName())
				|| StringUtils.isEmpty(customer.getLastName())) {
			Logger.debug("Invalid input values, throwing Exception");
			throw new InvalidDataException("Customer creation failed, A valid first name and last name is required");
		}
		final CustomerEntity entity = mapper.mapToCustomerEntity(customer);
		repo.save(entity);
		customer.setId(entity.getPk());
		Logger.info("Customer Created. PK = {};", customer.getId());
		Logger.info("Existing CustomerServiceSpringDataImpl.createCustomer");
		return customer;
	}

	@Override
	public void modifyCustomer(final CustomerData customer) {
		// TODO Auto-generated method stub
		if (customer == null || customer.getId() == null || StringUtils.isEmpty(customer.getFirstName())
				|| StringUtils.isEmpty(customer.getLastName())) {
			throw new InvalidDataException("Customer creation failed, A valid first name and last name is required");
		}

		CustomerEntity entity = findCustomerEntity(customer.getId());
		repo.save(entity);
		entity = mapper.mapToCustomerEntity(entity, customer);
	}

	@Override
	public CustomerData findCustomer(Long id) {
		// TODO Auto-generated method stub

		if (id == null) {
			throw new InvalidDataException("Id is required to find Customer");
		}
		final CustomerEntity entity = findCustomerEntity(id);

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
		// TODO Auto-generated method stub
		if (id == null) {
			throw new InvalidDataException("Id is required to remove Customer");
		}
		final CustomerEntity entity = findCustomerEntity(id);
		repo.delete(entity);

	}

	private CustomerEntity findCustomerEntity(final Long id) {
		CustomerEntity entity = repo.findOne(id);
		if (entity == null) {
			throw new CustomerNotFoundException("Customer was not found in the system");
		}
		return entity;
	}

}
