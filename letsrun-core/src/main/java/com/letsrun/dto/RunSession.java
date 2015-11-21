package com.letsrun.dto;

import java.util.Set;
import java.util.UUID;

import javax.xml.bind.annotation.XmlRootElement;

import org.joda.time.DateTime;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.joda.deser.DateTimeDeserializer;
import com.fasterxml.jackson.datatype.joda.ser.DateTimeSerializer;

@XmlRootElement
public class RunSession {

	private String id;
	private String name;
	@JsonSerialize(using = DateTimeSerializer.class)
	@JsonDeserialize(using = DateTimeDeserializer.class)
	private DateTime date;
	private Integer nbKm;
	private Set<String> runners;

	public RunSession() {
		super();
		id = UUID.randomUUID().toString();
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

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

	public Set<String> getRunners() {
		return runners;
	}

	public void setRunners(Set<String> runners) {
		this.runners = runners;
	}

}
