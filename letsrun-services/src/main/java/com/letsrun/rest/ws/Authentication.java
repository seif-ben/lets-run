package com.letsrun.rest.ws;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.letsrun.model.User;

@Path("/login")
public class Authentication {

	private final static Logger logger = LoggerFactory.getLogger(Authentication.class);

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public String authenticate(User user) {
		// TODO athentificate user
		return "true";
	}

}
