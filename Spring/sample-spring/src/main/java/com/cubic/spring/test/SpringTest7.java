package com.cubic.spring.test;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cubic.spring.config.DBConfig;
import com.cubic.spring.config.ProductAppConfig;

public class SpringTest7 {

	public static void main(String[] args) {

		final ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("ProductConfig.xml",
				"CommonConfig.xml");
		final DBConfig dbConfig = context.getBean(DBConfig.class);
		final ProductAppConfig productAppConfig = context.getBean(ProductAppConfig.class);
		System.out.println(dbConfig);
		System.out.println(productAppConfig);
	}

}
