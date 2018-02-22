package com.springboot.rest.client;

import javax.ws.rs.core.MediaType;

import com.springboot.rest.data.CustomerData;
import com.springboot.rest.data.ErrorResponse;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class CustomerCreate {

	public static void main(String[] args) {

		final String endPoint = "http://localhost:8090/customer";
		final Client client = Client.create();
		WebResource resource = client.resource(endPoint);
		final CustomerData requestEntity = new CustomerData();
		requestEntity.setFirstName(null);
		requestEntity.setLastName("Li");
		WebResource.Builder rb = resource.accept(MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML);
		rb = rb.type(MediaType.APPLICATION_JSON);

		final ClientResponse response = rb.post(ClientResponse.class, requestEntity);

		System.out.println("Status =" + response.getStatus());
		if (response.getStatus() >= 200 && response.getStatus() <= 299) {
			final CustomerData result = response.getEntity(CustomerData.class);
			System.out.println(result);
		} else {
			final ErrorResponse result = response.getEntity(ErrorResponse.class);
			System.out.println(result);
		}
	}

}
