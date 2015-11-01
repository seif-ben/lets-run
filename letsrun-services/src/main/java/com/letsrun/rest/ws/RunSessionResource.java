package com.letsrun.rest.ws;

import java.util.Collection;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Service;

import com.google.common.collect.Sets;
import com.letsrun.dao.RunSessionDaoImpl;
import com.letsrun.dto.RunSession;
import com.letsrun.dto.RunSessionBroadcastProtocol;
import com.letsrun.services.BroadcastManager;

@Path("/runSession")
@Service
public class RunSessionResource {

	@Inject
	private RunSessionDaoImpl runSessionDao;

	@Inject
	private BroadcastManager broadcaster;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<RunSession> getAllRunSessions() {
		return runSessionDao.getSessions();
	}

	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	public void addRunSession(RunSession runSession) {
		runSessionDao.add(runSession);
		broadcaster.broadcast(new RunSessionBroadcastProtocol(Sets.newHashSet(runSession)));
	}

}
