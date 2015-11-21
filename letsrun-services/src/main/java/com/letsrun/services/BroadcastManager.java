package com.letsrun.services;

import java.io.IOException;

import org.springframework.stereotype.Service;

import com.letsrun.dto.RunSessionBroadcastProtocol;
import com.letsrun.util.ObjectMapperUtil;
import com.letsrun.util.RestClient;

@Service
public class BroadcastManager {

	public void broadcast(RunSessionBroadcastProtocol message) {
		try {
			RestClient.post("http://localhost:8080/letsrun-websocket/rest/broadcast",
					ObjectMapperUtil.build().writeValueAsString(message));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
