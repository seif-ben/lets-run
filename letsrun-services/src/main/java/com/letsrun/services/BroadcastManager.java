package com.letsrun.services;

import java.io.IOException;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.letsrun.dto.RunSessionBroadcastProtocol;
import com.letsrun.dto.RestClient;
import com.letsrun.util.ObjectMapperUtil;

@Service
public class BroadcastManager {

	@Inject
	private RestClient restClient;

	public void broadcast(RunSessionBroadcastProtocol message) {
		try {
			restClient.post("localhost:8080/", ObjectMapperUtil.build().writeValueAsString(message));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
