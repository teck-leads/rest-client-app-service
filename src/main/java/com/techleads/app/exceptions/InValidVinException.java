package com.techleads.app.exceptions;

import org.springframework.http.HttpStatus;

public class InValidVinException extends RuntimeException {
	private final HttpStatus httpStatus;
	private final String errorCode;
	private final String errorMessage;

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public InValidVinException(HttpStatus httpStatus, String errorCode, String errorMessage) {
		super(httpStatus.value() + " - " + errorCode + " - " + errorMessage);
		this.httpStatus = httpStatus;
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}

	
}
