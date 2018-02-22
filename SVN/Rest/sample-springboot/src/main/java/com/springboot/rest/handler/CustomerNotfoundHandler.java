package com.springboot.rest.handler;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.springboot.rest.data.ErrorResponse;
import com.springboot.rest.exception.CustomerNotfoundException;

@Provider
public class CustomerNotfoundHandler implements ExceptionMapper<CustomerNotfoundException> {

	@Override
	public Response toResponse(CustomerNotfoundException exception) {
		final ErrorResponse entity = new ErrorResponse("ERR-400", exception.getMessage());
		return Response.status(Status.NOT_FOUND).type(MediaType.APPLICATION_XML).entity(entity).build();
	}

}
