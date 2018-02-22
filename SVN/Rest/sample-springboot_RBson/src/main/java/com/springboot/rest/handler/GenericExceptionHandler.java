package com.springboot.rest.handler;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.springboot.rest.data.ErrorResponse;

@Provider
@Produces({ MediaType.APPLICATION_JSON })
public class GenericExceptionHandler implements ExceptionMapper<Exception> {

	@Override
	public Response toResponse(Exception exception) {
		final ErrorResponse entity = new ErrorResponse("ERR-500", exception.getMessage());
		return Response.serverError().type(MediaType.APPLICATION_XML).entity(entity).build();

	}

}
