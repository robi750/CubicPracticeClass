package com.springboot.rest.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.springboot.rest.data.CustomerData;
import com.springboot.rest.entity.CustomerEntity;
import com.springboot.rest.entity.QueryConstant1;
import com.springboot.rest.exception.CustomerNotFoundException;
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
		// TODO Auto-generated method stub

		if (customer == null || StringUtils.isEmpty(customer.getFirstName())
				|| StringUtils.isEmpty(customer.getLastName())) {
			throw new InvalidDataException("Customer creation failed, A valid first name and last name is required");
		}
		final CustomerEntity entity = mapper.mapToCustomerEntity(customer);
		em.persist(entity);
		customer.setId(entity.getPk());
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
		em.persist(entity);
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
		// TODO Auto-generated method stub
		final String fName = (firstName == null) ? "%" : firstName.trim() + "%";
		final String lName = (lastName == null) ? "%" : lastName.trim() + "%";

		final TypedQuery<CustomerEntity> query = em.createNamedQuery(QueryConstant1.CUSTOMER_SEARCH,
				CustomerEntity.class);
		query.setParameter("fName", fName);
		query.setParameter("lName", lName);
		final List<CustomerEntity> resultList = query.getResultList();
		return mapper.mapToCustomerDataList(resultList);
	}

	@Override
	public void removeCustomer(Long id) {
		// TODO Auto-generated method stub
		if (id == null) {
			throw new InvalidDataException("Id is required to remove Customer");
		}
		final CustomerEntity entity = findCustomerEntity(id);
		em.remove(entity);

	}

	private CustomerEntity findCustomerEntity(final Long id) {
		CustomerEntity entity = em.find(CustomerEntity.class, id);
		if (entity == null) {
			throw new CustomerNotFoundException("Customer was not found in the system");
		}
		return entity;
	}

}
