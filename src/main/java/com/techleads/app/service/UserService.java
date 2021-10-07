package com.techleads.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.techleads.app.model.UserResponse;

@Service
public class UserService {
	private RestTemplate restTemplate;
	private final String  url = "https://reqres.in/api";

	@Autowired
	public void setRt(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
	
	public UserResponse userResponse(String path) {
		
		StringBuilder sb=new StringBuilder();
		sb.append(url);
		sb.append("/");
		sb.append(path);
		String url =sb.toString();
		//Set headers
		HttpHeaders requestHeaders = setHeaderValues();

		// request entity is created with request headers
		HttpEntity<?> requestEntity = new HttpEntity<>(requestHeaders);
		
		ResponseEntity<UserResponse> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, UserResponse.class);

		UserResponse userRespnose = responseEntity.getBody();
		return userRespnose;
	}

	private HttpHeaders setHeaderValues() {
		HttpHeaders requestHeaders = new HttpHeaders();
		requestHeaders.add("Authorization", "test");
		requestHeaders.add("Accept", MediaType.APPLICATION_JSON_VALUE);
		return requestHeaders;
	}

}
