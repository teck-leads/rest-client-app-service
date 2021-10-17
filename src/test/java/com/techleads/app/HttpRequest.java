package com.techleads.app;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.web.client.RestTemplate;

import com.techleads.app.controller.ActivityLogController;
import com.techleads.app.model.UserResponse;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class HttpRequest {
	@LocalServerPort
	private int port;
	@Autowired
	private TestRestTemplate restTemplate;
	
	@Autowired
	private ActivityLogController activityLogController;

	@Test
	void shoudReturnUsers() {
		String url="http://localhost:"+port+"/testUsers";
		UserResponse ur=new UserResponse();
		
		
		UserResponse forObject = this.restTemplate.getForObject(url, UserResponse.class);
		assertThat(forObject).isNotNull();
		assertThat(forObject).isEqualTo(forObject);
	}
}
