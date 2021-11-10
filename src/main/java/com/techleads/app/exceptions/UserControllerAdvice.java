package com.techleads.app.exceptions;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class UserControllerAdvice {

	@ExceptionHandler(InValidVinException.class)
	public ResponseEntity<Object> handleCityNotFoundException(InValidVinException ex, HttpServletRequest request) {

		Map<String, Object> body = new LinkedHashMap<>();
		body.put("timestamp", LocalDateTime.now());
		body.put("HttpStatus", ex.getHttpStatus());
		body.put("message", ex.getErrorMessage());
		body.put("ErrorCode", ex.getErrorCode());
		body.put("path", request.getRequestURL());

		return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
	}
	// add all your spefific custom exception here as above

	// executes this when no match is found from above handlers
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> handleUnknownExceptions(Exception ex, WebRequest request) {

		Map<String, Object> body = new LinkedHashMap<>();
		body.put("timestamp", LocalDateTime.now());
		body.put("message", "Unknown Exception");
		body.put("ErrorCode", "500");

		return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
