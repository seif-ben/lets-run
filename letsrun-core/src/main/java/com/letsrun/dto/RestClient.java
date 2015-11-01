package com.letsrun.dto;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.stereotype.Service;

@Service
public class RestClient {

	private static HttpClient httpClient = HttpClientBuilder.create().build();

	public HttpResponse get(String url) throws ClientProtocolException, IOException {
		HttpGet getRequest = new HttpGet(url);
		getRequest.addHeader("accept", "application/json");
		return httpClient.execute(getRequest);
	}

	public HttpResponse post(String url, String content) throws ClientProtocolException, IOException {
		HttpPost postRequest = new HttpPost(url);
		postRequest.addHeader("accept", "application/json");
		postRequest.setEntity(new StringEntity(content, ContentType.APPLICATION_JSON));
		return httpClient.execute(postRequest);
	}

}
