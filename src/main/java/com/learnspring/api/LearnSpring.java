package com.learnspring.api;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.learnspring.resource.LearnSpringRequest;
import com.learnspring.resource.LearnSpringResponse;

import javax.ws.rs.Consumes;

/*
 * This is the starting point when RESTEasy is added as dependency in our pom.xml
 */

@Path("/learnspring")
public interface LearnSpring {
	
	@POST
	@Produces("application/json")
	@Consumes("application/json")
	LearnSpringResponse learnSpringOperations(LearnSpringRequest input);
	
	

}
