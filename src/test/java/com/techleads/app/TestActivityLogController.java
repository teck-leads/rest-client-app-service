package com.techleads.app;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class TestActivityLogController {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Mock
	private HttpServletRequest httpServletRequest;
	static HttpHeaders requestHeaders = new HttpHeaders();
//	public static void init(){
//	    // ...
//
//	    MockHttpServletRequest mockRequest = new MockHttpServletRequest();
//	    	
//	    MockHttpServletRequest request = new MockHttpServletRequest();
//	    request.addHeader("x-real-ip","127.0.0.1");
//	    
//	    request.addHeader("Content-Type", "text/html");
//	    request.addHeader("if-none-match", "*");
//	    request.addHeader("customHeader", "customValue");
//
//	    requestHeaders = mockRequest;
//	}
	
	@Test
	void shoudReturn200Status() throws Exception {
		
		
		// define the headers you want to be returned
		Map<String, String> headers = new HashMap<>();
		headers.put("test", "test");
		headers.put("Authorization", "test");

		// create an Enumeration over the header keys
		Enumeration<String> headerNames = Collections.enumeration(headers.keySet());

		// mock HttpServletRequest
		HttpServletRequest request = mock(HttpServletRequest.class);
		// mock the returned value of request.getHeaderNames()
		when(request.getHeaderNames()).thenReturn(headerNames);
		this.mockMvc.perform(get("/users"))
		.andDo(print())
		.andExpect(status().isOk())
//		.andExpect((ResultMatcher) content().string(containsString("page")))
		;
		
	}
	
	private HttpHeaders setHeaderValues() {
		HttpHeaders requestHeaders = new HttpHeaders();
		requestHeaders.add("Authorization", "test");
		requestHeaders.add("Accept", MediaType.APPLICATION_JSON_VALUE);
		return requestHeaders;
	}

}
