package com.techleads.app.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.techleads.app.model.UserResponse;

//@Component
public class MyRunner implements CommandLineRunner {

	private RestTemplate rt;

	@Autowired
	public void setRt(RestTemplate rt) {
		this.rt = rt;
	}

	@Override
	public void run(String... args) throws Exception {

		HttpHeaders requestHeaders = new HttpHeaders();
		// set up HTTP Basic Authentication Header
		requestHeaders.add("Authorization", "test");
		requestHeaders.add("Accept", MediaType.APPLICATION_JSON_VALUE);

		// request entity is created with request headers
		HttpEntity<?> requestEntity = new HttpEntity<>(requestHeaders);
		String url = "https://reqres.in/api/users";
		ResponseEntity<UserResponse> responseEntity = rt.exchange(url, HttpMethod.GET, requestEntity, UserResponse.class);

		UserResponse body = responseEntity.getBody();
		body.getData().forEach(System.out::println);
//		System.out.println(responseEntity.getBody());

	}

}
