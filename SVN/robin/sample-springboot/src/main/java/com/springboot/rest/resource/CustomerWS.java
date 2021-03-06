package com.springboot.rest.resource;

import java.util.List;
import java.util.Set;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.springboot.rest.data.CustomerData;
import com.springboot.rest.data.CustomerSearchResult;
import com.springboot.rest.service.CustomerService;

@Service
@Path("/customer")
@Consumes({ MediaType.APPLICATION_JSON })
@Produces({ MediaType.APPLICATION_JSON })
public class CustomerWS {

	@Autowired
	@Qualifier("csJpa")
	private CustomerService cs;

	@POST
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response create(final CustomerData customer) {

		final CustomerData entity = cs.createCustomer(customer);
		final ResponseBuilder rb = Response.ok();

		if (customer.getLastName().startsWith("M")) {
			rb.type(MediaType.APPLICATION_XML);
		} else {
			rb.type(MediaType.APPLICATION_JSON);
		}
		return rb.entity(entity).build();

	}

	@PUT
	@Consumes({ MediaType.APPLICATION_XML })
	public Response modify(final CustomerData customer) {

		cs.modifyCustomer(customer);
		return Response.noContent().build();

	}

	@GET
	@Path("/{pk}")
	public Response find(@PathParam("pk") final Long customerId) {
		final CustomerData entity = cs.findCustomer(customerId);
		return Response.ok().entity(entity).build();
	}

	@DELETE
	@Path("/{pk}")
	public Response remove(@PathParam("pk") final Long customerId) {

		cs.removeCustomer(customerId);
		return Response.noContent().build();

	}

	@GET
	public Response search(@QueryParam("fName") final String firstName, @QueryParam("lName") final String lastName) {

		return searchCustomer(firstName, lastName);
	}

	@GET
	@Path("/matrix")
	public Response searchByMatrix(@MatrixParam("fName") final String firstName,
			@QueryParam("lName") final String lastName) {

		return searchCustomer(firstName, lastName);
	}

	private Response searchCustomer(final String firstName, final String lastName) {
		final List<CustomerData> customers = cs.searchCustomer(firstName, lastName);
		CustomerSearchResult entity = new CustomerSearchResult(customers);
		return Response.ok().entity(entity).build();
	}

	@GET
	@Path("/hdr")
	public Response Authenticate(@HeaderParam("auth-key") final String authKey,
			@HeaderParam("app-version") final String appVersion) throws JSONException {

		final JSONObject obj = new JSONObject();
		obj.put("auth-key", authKey);
		obj.put("app-version", appVersion);
		String entity = obj.toString();
		return Response.ok().entity(entity).build();

	}

	@GET
	@Path("/allhdr")
	public Response allHeaders(@Context HttpHeaders headers) throws JSONException {

		final MultivaluedMap<String, String> allHeaders = headers.getRequestHeaders();
		final Set<String> keys = allHeaders.keySet();
		final JSONObject obj = new JSONObject();

		for (String key : keys) {
			obj.put(key, headers.getHeaderString(key));
		}
		String entity = obj.toString();
		return Response.ok().entity(entity).build();

	}

}
