package com.springboot.rest.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import com.springboot.rest.handler.CustomerNotFoundHandler;
import com.springboot.rest.handler.GenericExceptionHandler;
import com.springboot.rest.handler.InvalidDataExceptionHandler;
import com.springboot.rest.resource.CustomerWS;
import com.springboot.rest.resource.HelloWorldRest;

@Configuration
public class SampleRestConfig extends ResourceConfig {

	public SampleRestConfig() {
		register(HelloWorldRest.class);
		register(CustomerWS.class);
		register(GenericExceptionHandler.class);
		register(CustomerNotFoundHandler.class);
		register(InvalidDataExceptionHandler.class);

	}
}
