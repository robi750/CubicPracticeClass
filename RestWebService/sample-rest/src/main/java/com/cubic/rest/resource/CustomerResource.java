package com.cubic.rest.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Service;

import com.cubic.rest.service.CustomerVO;

@Path("/Customer")
@Service
public class CustomerResource {

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response create(final CustomerVO customer) {
		customer.setPk(new Long(1000));
		return Response.ok().entity(customer).build();
	}
}
