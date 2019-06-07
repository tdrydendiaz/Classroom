package com.qa.rest;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.qa.business.service.ClassroomService;
import com.qa.business.service.TraineeService;

@Path("/trainee")
public class TraineeController {
	
	@Inject
	private TraineeService service;

	@Path("/getAllTrainees")
	@GET
	@Produces({ "application/json" })
	public String getAllClassrooms() {
		return service.getAllTrainees();
	}	

}
