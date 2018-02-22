package com.cubic.spring.test;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cubic.spring.service.ProductServiceImpl;
import com.cubic.spring.service.ProductVO;

public class SpringTest2 {

	public static void main(String[] args) {

		final ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("AppConfig.xml");
		final ProductServiceImpl impl1 = context.getBean(ProductServiceImpl.class);
		impl1.setVersion("" + 3.44);

		final ProductServiceImpl impl2 = (ProductServiceImpl) context.getBean("psv1");
		final ProductVO result1 = impl1.create(new ProductVO("Dell Laptop"));
		final ProductVO result2 = impl2.create(new ProductVO("Dell Laptop"));

		System.out.println("Result 1= " + result1);
		System.out.println("Result 2= " + result2);

		context.close();
	}

}
