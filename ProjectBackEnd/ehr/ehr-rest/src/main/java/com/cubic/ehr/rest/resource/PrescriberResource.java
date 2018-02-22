package com.cubic.ehr.rest.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.cubic.ehr.common.Status;
import com.cubic.ehr.prescriber.service.PrescriberService;
import com.cubic.ehr.prescriber.vo.PrescriberVO;

@Path("/prescriber")
@Consumes({ MediaType.APPLICATION_JSON })
@Produces({ MediaType.APPLICATION_JSON })
public class PrescriberResource {
	
	private Logger logger = LoggerFactory.getLogger(PrescriberResource.class);

	@Autowired
	private PrescriberService ps;

	@GET
	@Path("/{pk}")
	public Response find(@PathParam("pk") final Long prescriberId) {
		
		logger.debug("Entering PrescriberResource.find");
		logger.info("PrescriberId={}",(prescriberId));
		
		final PrescriberVO prescriber = ps.findPrescriber(prescriberId);
		return Response.ok().entity(prescriber).build();
	}

	@GET
	public Response searchPrescriber(@QueryParam("name") final String name,
			@QueryParam("deaNumber") final String deaNumber) {
		
		logger.debug("Entering PrescriberResource.searchPrescriber");
		logger.info("name={}",(name), "deaNumber={}",(name));
		
		final List<PrescriberVO> prescribers = ps.searchPrescriber(name, deaNumber);
		return Response.ok().entity(prescribers).build();
	}

	@POST
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response create(final PrescriberVO prescriber) { 

		logger.debug("Entering PrescriberResource.create");
		logger.info("PrescriberVO Object={}",(prescriber));
		
		final PrescriberVO prescriberData = ps.createPrescriber(prescriber);
		return Response.ok().entity(prescriberData).build();

	}

	@PUT
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response modify(final PrescriberVO prescriber) {
		
		logger.debug("Entering PrescriberResource.modify");
		logger.info("PrescriberVO Object={}",(prescriber));

		final PrescriberVO prescriberData = ps.modifyPrescriber(prescriber);
		return Response.ok().entity(prescriberData).build();

	}
	@PUT
	@Path("/{id}/{status}")
	public Response modifyStatus(@PathParam("id") final Long id, @PathParam("status") final Status status) {
		
		logger.debug("Entering PrescriberResource.modifyStatus");
		logger.info("id={}",(id), "status={}",status);
		
	//	final PrescriberVO entity = ps.modifyStatus(status, id);
		ps.modifyStatus(status, id);
		return Response.noContent().build();
		//return Response.ok().entity(entity).build();
	}

	@DELETE
	@Path("/{pk}")
	public Response remove(@PathParam("pk") final Long prescriberId) {
		
		logger.debug("Entering PrescriberResource.remove");
		logger.info("PrescriberId={}",(prescriberId));
		
		ps.removePrescriber(prescriberId);
		return Response.noContent().build();
	}
}