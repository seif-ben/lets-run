package com.letsrun.rest.ws;

import java.util.Set;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;

import org.atmosphere.annotation.Suspend;
import org.atmosphere.config.service.AtmosphereService;
import org.atmosphere.cpr.AtmosphereResource;
import org.atmosphere.cpr.AtmosphereResourceEvent;
import org.atmosphere.cpr.AtmosphereResourceEventListenerAdapter;
import org.atmosphere.cpr.Broadcaster;
import org.atmosphere.jersey.JerseyBroadcaster;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.letsrun.business.UserAtResourceHandler;
import com.letsrun.dto.BroadcastProtocol;
import com.letsrun.util.AtmosphereUtil;

@Path("/")
@AtmosphereService(broadcaster = JerseyBroadcaster.class)
public class RunningSessionService {

	private final static Logger logger = LoggerFactory.getLogger(RunningSessionService.class);

	@Context
	private Broadcaster broadcaster;

	private UserAtResourceHandler userAtResourceHandler = UserAtResourceHandler.getUserAtResourceHandler();

	@GET
	@Path("login/{login}")
	@Suspend(contentType = "application/json", listeners = { OnDisconnect.class })
	public String suspend(@PathParam("login") String login, @Context AtmosphereResource r) {
		logger.info("Browser {} connected.", r.uuid());
		userAtResourceHandler.addAtmosphereResource(login, r.uuid());
		return "";
	}

	@POST
	@Path("broadcast")
	public void broadcast(BroadcastProtocol broadcastProtocol) {
		// braodcast messages to client getted from services
		Set<AtmosphereResource> resources = AtmosphereUtil.findAtmosphereResource(broadcastProtocol.getReceivers());
		broadcaster.broadcast(broadcastProtocol.getMessage(), resources);
	}

	public static final class OnDisconnect extends AtmosphereResourceEventListenerAdapter {

		@Override
		public void onDisconnect(AtmosphereResourceEvent event) {
			if (event.isCancelled()) {
				logger.info("Browser {} unexpectedly disconnected", event.getResource().uuid());
			} else if (event.isClosedByClient()) {
				logger.info("Browser {} closed the connection", event.getResource().uuid());
			}
		}
	}

}
