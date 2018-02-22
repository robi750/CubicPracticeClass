package com.cubic.ehr.rest.handler;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;

import com.cubic.ehr.common.ErrorResponse;
import com.cubic.ehr.prescriber.exception.PrescriberNotfoundException;

public class PrescriberNotfoundExceptionHandler implements ExceptionMapper<PrescriberNotfoundException>{
	
	@Override
	public Response toResponse(PrescriberNotfoundException exception) {
		final ErrorResponse entity = new ErrorResponse("Error-400", exception.getMessage());
		return Response.status(Status.NOT_FOUND).type(MediaType.APPLICATION_JSON).entity(entity).build();
	}
}