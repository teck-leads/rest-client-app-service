package com.techleads.app;

import static org.hamcrest.CoreMatchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.techleads.app.controller.ActivityLogController;
import com.techleads.app.model.Users;
import com.techleads.app.service.UserService;

@WebMvcTest(ActivityLogController.class)
public class WebMockTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private UserService userService;
	@Test
	void getUserResponse() throws Exception {
		List<Users> users = new ArrayList<>();
		
		Users u1=new Users();
		u1.setCity("Hyderabad");
		u1.setName("Madhav");
		
		
		when(userService.findAllUsers()).thenReturn(users);
		this.mockMvc.perform(get("/testUsers"))
		.andDo(print())
		.andExpect(status().isOk())
//		.andExpect(content().contentType(MediaType.APPLICATION_JSON))
//		.andExpect(content().string(containsString("test")))
		;
		
	}

}
