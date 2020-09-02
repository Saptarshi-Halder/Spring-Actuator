package com.example.rest;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.boot.actuate.health.Health;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

@Component
@Endpoint(id = "webStatus")
public class CheckWebSiteStatus {
	

	@ReadOperation(produces = MediaType.APPLICATION_JSON_VALUE)
	public Health health(String urlName) {
		try {
			URL url = new URL(urlName);
			HttpURLConnection httpUrlConnection = (HttpURLConnection) url.openConnection();
			httpUrlConnection.setRequestMethod("GET");
			httpUrlConnection.connect();
			int i = httpUrlConnection.getResponseCode();
			if (i == 200) {
				return Health.up().withDetail("Sucess", "Working Like a rocket").build();
			} else {
				return Health.down().withDetail("Error", "Cerner Network is down").build();
			}
		} catch (IOException e) {

			return Health.down().withDetail("Erroneous", "Service Unavailable").build();
		}

	}

	@ReadOperation(produces = MediaType.APPLICATION_JSON_VALUE)
	public Health healthy(@Selector String urlName) {
		URL url;
		try {
			url = new URL(createTheUrl(urlName));
			HttpURLConnection httpUrlConnection = (HttpURLConnection) url.openConnection();
			httpUrlConnection.setRequestMethod("GET");
			httpUrlConnection.connect();
			int i = httpUrlConnection.getResponseCode();
			if (i == 200) {
				return Health.up().withDetail("Sucessfully Executed", "Working Like a rocket").build();
			} else {
				return Health.down().withDetail("Failed during execution", "Cerner Network is down").build();
			}
		} catch (IOException e) {
			return Health.down().withDetail("Failure", "Service Unavailable").build();
		}		
		

	}
	


	private String createTheUrl(String urlName) {
		StringBuilder sb = new StringBuilder();
		sb.append("https://");
		sb.append(urlName);
		sb.append("/");
		return sb.toString();

	}

}
