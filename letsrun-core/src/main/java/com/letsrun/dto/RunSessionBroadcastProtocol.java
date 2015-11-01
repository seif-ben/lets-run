package com.letsrun.dto;

import java.util.Set;

public class RunSessionBroadcastProtocol {

	private Set<RunSession> runSessions;
	private Set<String> receivers;

	public RunSessionBroadcastProtocol() {
		super();
	}

	public RunSessionBroadcastProtocol(Set<RunSession> runSessions, Set<String> receivers) {
		super();
		this.runSessions = runSessions;
		this.receivers = receivers;
	}

	public RunSessionBroadcastProtocol(Set<RunSession> runSessions) {
		super();
		this.runSessions = runSessions;
	}

	public Set<RunSession> getRunSessions() {
		return runSessions;
	}

	public void setRunSessions(Set<RunSession> runSessions) {
		this.runSessions = runSessions;
	}

	public Set<String> getReceivers() {
		return receivers;
	}

	public void setReceivers(Set<String> receivers) {
		this.receivers = receivers;
	}

}
