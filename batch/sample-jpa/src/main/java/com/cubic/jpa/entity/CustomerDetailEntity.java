package com.cubic.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "CUSTOMER_INFO")
public class CustomerDetailEntity {

	@Id
	@Column(name = "ID")
	@GenericGenerator(name = "detailSeq", strategy = "foreign", parameters = {
			@Parameter(name = "property", value = "customer") })

	// @GeneratedValue(generator = "detailSeq")
	private long detailpk;

	@Column(name = "DESCRIPTION")
	private String description;

	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	private CustomerEntity customer;

	public long getDetailpk() {
		return detailpk;
	}

	public void setDetailpk(long detailpk) {
		this.detailpk = detailpk;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public CustomerEntity getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerEntity customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "CustomerDetailEntity [detailpk=" + detailpk + ", description=" + description + ", customer=" + customer
				+ "]";
	}

}
