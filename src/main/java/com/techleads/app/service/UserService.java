package com.techleads.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.client.RestTemplate;

import com.techleads.app.exceptions.BaseBusinessException;
import com.techleads.app.exceptions.InValidVinException;
import com.techleads.app.model.UserResponse;
import com.techleads.app.model.Users;

@Service
public class UserService {
	private RestTemplate restTemplate;
	private final String url = "https://reqres.in/api";
	private final String usersUrl = "https://mocki.io/v1/d4867d8b-b5d5-4a48-a4ab-79131b5809b8";

	@Autowired
	public void setRt(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	public UserResponse userResponse(String path) {

		StringBuilder sb = new StringBuilder();
		sb.append(url);
		sb.append("/");
		sb.append(path);
		String url = sb.toString();
		// Set headers
		HttpHeaders requestHeaders = setHeaderValues();

		// request entity is created with request headers
		HttpEntity<?> requestEntity = new HttpEntity<>(requestHeaders);

		ResponseEntity<UserResponse> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity,
				UserResponse.class);

		UserResponse userRespnose = responseEntity.getBody();
		return userRespnose;
	}

	public List<Users> findAllUsers() {

		// Set headers
		HttpHeaders requestHeaders = setHeaderValues();

		// request entity is created with request headers
		HttpEntity<?> requestEntity = new HttpEntity<>(requestHeaders);

		ResponseEntity<List<Users>> responseEntity = restTemplate.exchange(usersUrl, HttpMethod.GET, requestEntity,
				new ParameterizedTypeReference<List<Users>>() {
				});
		List<Users> users = responseEntity.getBody();

		return users;
	}

	private HttpHeaders setHeaderValues() {
		HttpHeaders requestHeaders = new HttpHeaders();
		requestHeaders.add("Authorization", "test");
		requestHeaders.add("Accept", MediaType.APPLICATION_JSON_VALUE);
		return requestHeaders;
	}

	public void validate(String path) {
		if (!"users".equals(path)) {
			throw new InValidVinException(HttpStatus.BAD_REQUEST, String.valueOf(HttpStatus.BAD_REQUEST.value()),
					"Invalid Vin");
		}
	}

}
