package com.springboot.rest.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springboot.rest.service.CustomerTransaction;

public class TransactionTest {

	public static void main(String[] agrs) {
		ApplicationContext context = new ClassPathXmlApplicationContext("SpringJpa.xml");
		CustomerTransaction pt = context.getBean("pt", CustomerTransaction.class);
		pt.createCustomer();
	}

}
