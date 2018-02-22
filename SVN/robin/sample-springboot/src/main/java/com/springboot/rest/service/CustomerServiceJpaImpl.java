package com.springboot.rest.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.springboot.rest.data.CustomerData;
import com.springboot.rest.entity.CustomerEntity;
import com.springboot.rest.exception.CustomerNotfoundException;
import com.springboot.rest.exception.InvalidDataException;

@Service("csJpa")
@Transactional
public class CustomerServiceJpaImpl implements CustomerService {

	@PersistenceContext
	private EntityManager em;

	@Autowired
	private CustomerMapper mapper;

	@Override
	public CustomerData createCustomer(final CustomerData customer) {

		if (customer == null || StringUtils.isEmpty(customer.getFirstName())
				|| StringUtils.isEmpty(customer.getLastName())) {
			throw new InvalidDataException("Customer creation failed. A valid first name and last name is required.");
		}
		final CustomerEntity entity = mapper.mapToCustomerEntity(customer);
		em.persist(entity);
		customer.setId(entity.getPk());
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
		em.persist(entity);
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeCustomer(Long id) {
		if (id == null) {
			throw new InvalidDataException("Id is required to remove customer.");
		}
		final CustomerEntity entity = findCustomerEntity(id);
		em.remove(entity);

	}

	private CustomerEntity findCustomerEntity(final Long id) {
		CustomerEntity entity = em.find(CustomerEntity.class, id);
		if (entity == null) {
			throw new CustomerNotfoundException("Customer was not found in the System.");
		}
		return entity;
	}

}
