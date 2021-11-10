package com.techleads.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.techleads.app.model.UserResponse;
import com.techleads.app.model.Users;
import com.techleads.app.service.UserService;

@RestController
public class ActivityLogController {

	private UserService userService;

	@Autowired
	public ActivityLogController(com.techleads.app.service.UserService userService) {
		this.userService = userService;
	}

	@GetMapping(value = "/{path}")
	public ResponseEntity<UserResponse> userResponse(@PathVariable("path") String path) {
		
		userService.validate(path);
		
		UserResponse userResponse = userService.userResponse(path);
		return new ResponseEntity<>(userResponse, HttpStatus.OK);

	}
	
//	@GetMapping(value = "/users")
//	public ResponseEntity<List<Users>> findAllUsers(
//			@RequestHeader(value = "Authorization", required = true ) String authorization,
//			 @RequestParam(value = "fromDate", required = true) String fromDate
//			) {
//		System.out.println("Authorization "+authorization);
//		System.out.println(fromDate);
//		List<Users> findAllUsers = userService.findAllUsers();
//		return new ResponseEntity<List<Users>>(findAllUsers, HttpStatus.OK);
//
//	}

}
