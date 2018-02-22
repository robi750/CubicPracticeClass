package com.cubic.spring.test;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cubic.spring.service.ProductService;
import com.cubic.spring.service.ProductServiceImpl;
import com.cubic.spring.service.ProductVO;

public class SpringTest1 {

	public static void main(String[] args) {

		final ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("AppConfig.xml");
		final ProductService impl = (ProductServiceImpl) context.getBean("psv1");
		final ProductVO result = impl.create(new ProductVO("Dell Laptop"));
		System.out.println(result);
		context.close();
	}

}
