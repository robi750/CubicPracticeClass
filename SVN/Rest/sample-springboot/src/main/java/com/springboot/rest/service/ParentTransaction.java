package com.springboot.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.rest.entity.CustomerEntity;
import com.springboot.rest.repo.CustomerRepo;

@Service("pt")
@Transactional(propagation = Propagation.SUPPORTS)
public class ParentTransaction implements CustomerTransaction {

	@Autowired
	private CustomerRepo repo;

	@Autowired
	@Qualifier("ctTransaction")
	private CustomerTransaction child;

	@Override
	@Transactional(propagation = Propagation.SUPPORTS)
	public void createCustomer() {
		save("parent", "Transaction");
		child.createCustomer();
		// throw new RuntimeException("roll back");

	}

	private void save(final String firstName, final String lastName) {
		CustomerEntity entity = new CustomerEntity();
		entity.setFirstName(firstName);
		entity.setLastName(lastName);
		repo.save(entity);
	}
}
