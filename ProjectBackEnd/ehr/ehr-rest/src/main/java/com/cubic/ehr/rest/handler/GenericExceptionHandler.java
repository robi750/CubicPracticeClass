package com.cubic.ehr.rest.handler;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.cubic.ehr.common.ErrorResponse;

@Provider
public class GenericExceptionHandler implements ExceptionMapper<Exception>{
	
	@Override
	public Response toResponse(Exception exception) {
		final ErrorResponse entity = new ErrorResponse("ERR-500", exception.getMessage());
		return Response.serverError().entity(entity).build();
	}
}