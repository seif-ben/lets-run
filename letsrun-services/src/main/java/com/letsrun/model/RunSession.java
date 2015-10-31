package com.letsrun.model;

import java.util.Set;

import org.joda.time.DateTime;

public class RunSession {

	private String name;
	private DateTime date;
	private Integer nbKm;
	private Set<User> runners;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public DateTime getDate() {
		return date;
	}

	public void setDate(DateTime date) {
		this.date = date;
	}

	public Integer getNbKm() {
		return nbKm;
	}

	public void setNbKm(Integer nbKm) {
		this.nbKm = nbKm;
	}

	public Set<User> getRunners() {
		return runners;
	}

	public void setRunners(Set<User> runners) {
		this.runners = runners;
	}

}
