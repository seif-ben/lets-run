package com.letsrun.util;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletContext;

import org.atmosphere.cpr.AtmosphereFramework;
import org.atmosphere.cpr.AtmosphereResource;
import org.atmosphere.cpr.AtmosphereResourceFactory;
import org.atmosphere.util.ServletContextFactory;
import org.springframework.util.CollectionUtils;

public abstract class AtmosphereUtil {

	private static AtmosphereResourceFactory getAtmosphereResourceFactory() {
		ServletContext servletContext = ServletContextFactory.getDefault().getServletContext();
		AtmosphereFramework framework = (AtmosphereFramework) servletContext.getAttribute("AtmosphereServlet");
		AtmosphereResourceFactory factory = framework.atmosphereFactory();
		return factory;
	}

	synchronized public static Set<AtmosphereResource> findAtmosphereResource(Collection<String> receivers) {
		if (!CollectionUtils.isEmpty(receivers)) {
			Set<AtmosphereResource> result = new HashSet<>(receivers.size());
			for (String uuid : receivers) {
				AtmosphereResource resource = getAtmosphereResourceFactory().find(uuid);
				result.add(resource);
			}
			return result;
		}
		return Collections.emptySet();
	}

}
