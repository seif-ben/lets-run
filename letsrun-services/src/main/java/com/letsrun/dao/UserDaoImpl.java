package com.letsrun.dao;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Repository;

import com.letsrun.model.User;

@Repository
public class UserDaoImpl {

	private static Map<String, User> usersMap = new ConcurrentHashMap<>();

	static {
		usersMap.put("seifben", new User("seifben", "xxx", "seif"));
		usersMap.put("taher", new User("taher", "xxx", "taher"));
	}

	public User get(String login) {
		return usersMap.get(login);
	}

}
