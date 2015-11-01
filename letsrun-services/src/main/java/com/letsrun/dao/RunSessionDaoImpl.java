package com.letsrun.dao;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.joda.time.DateTime;
import org.springframework.stereotype.Repository;

import com.google.common.collect.Sets;
import com.letsrun.dto.RunSession;

@Repository
public class RunSessionDaoImpl {
	private static Map<String, RunSession> runSessionMap = new ConcurrentHashMap<>();

	static {
		RunSession s = new RunSession();
		s.setDate(new DateTime(2015, 11, 2, 10, 0, 0));
		s.setNbKm(10);
		s.setName("Session1");
		s.setRunners(Sets.newHashSet("seifben", "taher"));
		runSessionMap.put(s.getId(), s);

		RunSession s2 = new RunSession();
		s2.setDate(new DateTime(2015, 11, 3, 11, 0, 0));
		s2.setNbKm(10);
		s2.setName("Session2");
		s2.setRunners(Sets.newHashSet("seifben"));
		runSessionMap.put(s2.getId(), s2);
	}

	public Collection<RunSession> getSessions() {
		return runSessionMap.values();
	}

	public void add(RunSession runSession) {
		runSessionMap.put(runSession.getId(), runSession);
	}

}
