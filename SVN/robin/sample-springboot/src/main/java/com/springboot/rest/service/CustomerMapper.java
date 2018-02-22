package com.springboot.rest.service;

import org.springframework.stereotype.Component;

import com.springboot.rest.data.CustomerData;
import com.springboot.rest.entity.CustomerEntity;

@Component
public class CustomerMapper {

	public CustomerEntity mapToCustomerEntity(final CustomerData data) {
		return mapToCustomerEntity(new CustomerEntity(), data);
	}

	public CustomerEntity mapToCustomerEntity(final CustomerEntity entity, final CustomerData data) {
		entity.setFirstName(data.getFirstName());
		entity.setLastName(data.getLastName());
		entity.setSsn(data.getSsn());
		return entity;
	}

	public CustomerData mapToCustomerData(final CustomerEntity entity) {
		final CustomerData result = new CustomerData();
		result.setFirstName(entity.getFirstName());
		result.setLastName(entity.getLastName());
		result.setSsn(entity.getSsn());
		result.setId(entity.getPk());
		return result;
	}

}
