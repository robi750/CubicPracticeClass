package com.cubic.spring.service;

import org.springframework.stereotype.Service;

@Service("htmlEmailNS")
public class HtmlEmailNotifyService implements NotifyService {

	@Override
	public void notifyCustomer() {
		System.out.println("Customer notified by email in Html format.");
	}

}
