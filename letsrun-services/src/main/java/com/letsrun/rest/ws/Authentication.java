package com.letsrun.rest.ws;

import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Service;

import com.letsrun.dao.UserDaoImpl;
import com.letsrun.model.User;

@Service
@Path("/login")
public class Authentication {

	@Inject
	private UserDaoImpl userDaoImpl;

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public String authenticate(User user) {
		User knownUser = userDaoImpl.get(user.getLogin());
		if (knownUser == null) {
			return "false";
		}

		if (user.getLogin() != null && user.getLogin().equals(knownUser.getLogin()) && user.getPassword() != null
				&& user.getPassword().equals(knownUser.getPassword())) {
			userDaoImpl.addSocketSession(user);
			return "true";
		}

		return "false";
	}

}
