package com.techleads.app;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.anything;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.context.WebApplicationContext;

import com.techleads.app.controller.ActivityLogController;
import com.techleads.app.model.Users;
import com.techleads.app.service.UserService;

@WebMvcTest(ActivityLogController.class)
public class APITestWithHeaders {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private UserService userService;
	
	@Autowired
	private WebApplicationContext webApplicationContext;
	
	@Test
	void shouldCreateMockMvc() {
		assertNotNull(mockMvc);
	}
	
	@Test
	void getUserResponse() throws Exception {
		List<Users> users = new ArrayList<>();
		
		Users u1=new Users();
		u1.setCity("Hyderabad");
		u1.setName("Madhav");
		users.add(u1);
		HttpHeaders setHeaderValues = setHeaderValues();
		when(userService.findAllUsers())
		.thenReturn(users);
		
		this.mockMvc
		.perform(MockMvcRequestBuilders.get("/users?fromDate=14-10-2021")
				.headers(setHeaderValues))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(MockMvcResultMatchers.jsonPath("$.size()", Matchers.is(1)))
		.andExpect(MockMvcResultMatchers.jsonPath("$.[0].name").value("Madhav"))
		.andExpect(MockMvcResultMatchers.jsonPath("$.[0].city").value("Hyderabad"))
		;
		verify(userService).findAllUsers();
		verify(userService, times(1)).findAllUsers();//same as normal verify method
		verify(userService, atLeastOnce()).findAllUsers();// must be called at least once
		verify(userService, atMost(2)).findAllUsers(); // must be called at most 2 times
		verify(userService, atLeast(1)).findAllUsers(); // must be called at least once
//		verify(userService, never()).findAllUsers(); // must never be called
		
		
		
	
		
		
	}
	
	private HttpHeaders setHeaderValues() {
		HttpHeaders requestHeaders = new HttpHeaders();
		requestHeaders.add("Authorization", "test");
		requestHeaders.add("Accept", MediaType.APPLICATION_JSON_VALUE);
		return requestHeaders;
	}

}
