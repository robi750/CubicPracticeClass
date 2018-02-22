package com.springboot.rest.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import com.springboot.rest.exception.InvalidDataException;
import com.springboot.rest.handler.CustomerNotfoundHandler;
import com.springboot.rest.handler.GenericExceptionHandler;
import com.springboot.rest.resource.CustomerWS;
import com.springboot.rest.resource.HelloWorldRest;

@Configuration
public class SampleRestConfig extends ResourceConfig {

	public SampleRestConfig() {
		register(HelloWorldRest.class);
		register(CustomerWS.class);
		register(GenericExceptionHandler.class);
		register(CustomerNotfoundHandler.class);
		register(InvalidDataException.class);
	}
}
