package com.techleads.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.techleads.app.model.UserResponse;
import com.techleads.app.service.UserService;

@RestController
public class ActivityLogController {

	private UserService UserService;

	@Autowired
	public ActivityLogController(com.techleads.app.service.UserService userService) {
		UserService = userService;
	}

	@GetMapping(value = "/{path}")
	public ResponseEntity<UserResponse> userResponse(@PathVariable("path") String path) {
		UserResponse userResponse = UserService.userResponse(path);
		return new ResponseEntity<>(userResponse, HttpStatus.OK);

	}

}
