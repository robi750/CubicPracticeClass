package com.cubic.spring.service;

import org.springframework.stereotype.Service;

@Service("emailNS")
public class EmailNotifyService implements NotifyService {

	@Override
	public void notifyCustomer() {
		System.out.println("Customer notified by email.");
	}

}
