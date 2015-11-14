package com.letsrun.util;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;

public abstract class RestClient {

	private static HttpClient httpClient;

	private static HttpClient getHttpClient() {
		if (httpClient == null) {
			httpClient = HttpClientBuilder.create().build();
		}
		return httpClient;
	}

	public static HttpResponse get(String url) throws ClientProtocolException, IOException {
		HttpGet getRequest = new HttpGet(url);
		getRequest.addHeader("accept", "application/json");
		return getHttpClient().execute(getRequest);
	}

	public static HttpResponse post(String url, String content) throws ClientProtocolException, IOException {
		HttpPost postRequest = new HttpPost(url);
		postRequest.addHeader("accept", "application/json");
		postRequest.setEntity(new StringEntity(content, ContentType.APPLICATION_JSON));
		return getHttpClient().execute(postRequest);
	}

}
