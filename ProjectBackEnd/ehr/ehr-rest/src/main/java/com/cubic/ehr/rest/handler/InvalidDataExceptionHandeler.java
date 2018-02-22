package com.cubic.ehr.rest.handler;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;

import com.cubic.ehr.common.ErrorResponse;
import com.sun.media.sound.InvalidDataException;

public class InvalidDataExceptionHandeler implements ExceptionMapper<InvalidDataException>{

	public Response toResponse(InvalidDataException exception) {
		final ErrorResponse entity = new ErrorResponse("Error-510", exception.getMessage());
		return Response.status(Status.NOT_FOUND).type(MediaType.APPLICATION_JSON).entity(entity).build();
	}
}
