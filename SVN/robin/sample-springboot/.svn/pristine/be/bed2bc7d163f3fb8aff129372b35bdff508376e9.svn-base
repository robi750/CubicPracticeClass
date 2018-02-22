package com.springboot.rest.handler;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.springboot.rest.data.ErrorResponse;

@Provider
public class GenericExceptionHandler implements ExceptionMapper<Exception> {

	@Override
	public Response toResponse(Exception exception) {
		final ErrorResponse entity = new ErrorResponse("ERR-500", exception.getMessage());
		return Response.serverError().entity(entity).build();
	}

}
