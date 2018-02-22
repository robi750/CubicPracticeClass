package com.cubic.spring.config;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;

import com.cubic.spring.service.PrinterUtil;

@Configuration
public class ApplicationConfig {

	@Bean
	public PrinterUtil printerUtil() {
		return new PrinterUtil();
	}

	@Bean
	public PropertyPlaceholderConfigurer propertyPlaceholderConfigurer() {
		final FileSystemResource dbResource = new FileSystemResource("C:\\Develop\\config\\db.properties");
		final ClassPathResource appResource = new ClassPathResource("app.properties");
		final PropertyPlaceholderConfigurer ppConfig = new PropertyPlaceholderConfigurer();
		ppConfig.setLocations(dbResource, appResource);
		return ppConfig;
	}

}
