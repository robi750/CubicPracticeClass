package com.springboot.rest.handler;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.springboot.rest.data.ErrorResponse;
import com.springboot.rest.exception.InvalidDataException;

@Provider
public class InvalidDataExceptionHandler implements ExceptionMapper<InvalidDataException> {

	private Logger logger = LoggerFactory.getLogger(InvalidDataExceptionHandler.class);

	@Override
	public Response toResponse(InvalidDataException exception) {
		logger.error("Error occered creating or modifying Customer, Error = {}",exception);
		final ErrorResponse entity = new ErrorResponse("ERR-500", exception.getMessage());
		return Response.status(510).type(MediaType.APPLICATION_XML).entity(entity).build();
	}

}
