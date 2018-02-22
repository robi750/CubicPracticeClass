package com.cubic.spring.test;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cubic.spring.service.ProductServiceImpl;

public class SpringTest6 {

	public static void main(String[] args) {

		final ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("ProductConfig.xml",
				"CommonConfig.xml");
		final ProductServiceImpl impl = context.getBean("psv5", ProductServiceImpl.class);
		System.out.println("Price List: " + impl.getPriceList());
		System.out.println("Vendor List: " + impl.getVendors());
		System.out.println("Vendor Price List: " + impl.getVendorPriceMap());

		context.close();
	}

}
