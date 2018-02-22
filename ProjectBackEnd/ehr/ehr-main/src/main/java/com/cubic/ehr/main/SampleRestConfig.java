package com.cubic.ehr.main;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import com.cubic.ehr.common.exception.DuplicateDataFoundException;
import com.cubic.ehr.common.exception.InvalidDataException;
import com.cubic.ehr.prescriber.exception.PrescriberNotfoundException;
import com.cubic.ehr.rest.HelloWorldRest;
import com.cubic.ehr.rest.handler.DuplicateDataFoundExceptionHandler;
import com.cubic.ehr.rest.handler.GenericExceptionHandler;
import com.cubic.ehr.rest.handler.InvalidDataExceptionHandeler;
import com.cubic.ehr.rest.handler.PrescriberNotfoundExceptionHandler;
import com.cubic.ehr.rest.resource.PrescriberResource;

@Configuration
public class SampleRestConfig extends ResourceConfig {

	public SampleRestConfig() {
		register(HelloWorldRest.class);
		register(PrescriberResource.class);
		register(InvalidDataException.class);
		register(PrescriberNotfoundException.class);
		register(DuplicateDataFoundException.class);
		register(DuplicateDataFoundExceptionHandler.class);
		register(GenericExceptionHandler.class);
		register(InvalidDataExceptionHandeler.class);
		register(PrescriberNotfoundExceptionHandler.class);
	}
}
