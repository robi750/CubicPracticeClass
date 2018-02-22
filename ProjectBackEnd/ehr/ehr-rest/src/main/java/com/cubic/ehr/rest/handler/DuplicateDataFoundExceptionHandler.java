package com.cubic.ehr.rest.handler;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;

import com.cubic.ehr.common.ErrorResponse;
import com.cubic.ehr.common.exception.DuplicateDataFoundException;

public class DuplicateDataFoundExceptionHandler implements ExceptionMapper<DuplicateDataFoundException>{

	public Response toResponse(DuplicateDataFoundException exception) {
		final ErrorResponse entity = new ErrorResponse("Error-510", exception.getMessage());
		return Response.status(Status.CONFLICT).type(MediaType.APPLICATION_JSON).entity(entity).build();
	}
}
