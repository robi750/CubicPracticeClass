package com.cubic.spring.test;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cubic.spring.service.ProductService;
import com.cubic.spring.service.ProductVO;

public class SpringTest4 {

	public static void main(String[] args) {

		final ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("AppConfig.xml");
		final ProductService impl = context.getBean("psv4", ProductService.class);
		final ProductVO result = impl.create(new ProductVO("Dell Laptop"));
		System.out.println("Result = " + result);
		context.close();
	}

}
