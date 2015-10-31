package com.letsrun.business;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

//TODO to remove after test
public class UserAtResourceHandler {

	private static Map<String, String> atmosphereResourceByUserMap = new ConcurrentHashMap<>();

	private static UserAtResourceHandler userAtResourceHandler;

	public static UserAtResourceHandler getUserAtResourceHandler() {
		if (userAtResourceHandler == null) {
			userAtResourceHandler = new UserAtResourceHandler();
			return userAtResourceHandler;
		}
		return userAtResourceHandler;
	}

	public String getAtmosphereResource(String login) {
		return atmosphereResourceByUserMap.get(login);
	}

	public void addAtmosphereResource(String login, String resource) {
		atmosphereResourceByUserMap.put(login, resource);
	}

}
