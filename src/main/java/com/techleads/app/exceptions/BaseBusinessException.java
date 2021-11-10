package com.techleads.app.exceptions;

import java.util.Objects;

import org.springframework.http.HttpStatus;

public class BaseBusinessException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final HttpStatus httpStatus;
	private final String errorCode;
	private final String errorMessage;

	private final transient Object[] agrs;

	public BaseBusinessException(HttpStatus httpStatus, String errorCode, String errorMessage, Object[] agrs) {
		super(httpStatus.value() + " - " + errorCode);
		this.httpStatus = httpStatus;
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
		if (Objects.nonNull(agrs)) {
			this.agrs = agrs.clone();
		} else {
			this.agrs = null;
		}
	}

	public BaseBusinessException(HttpStatus httpStatus, String errorCode, String errorMessage) {
		super(httpStatus.value() + " - " + errorCode + " - " + errorMessage);
		this.httpStatus = httpStatus;
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
		this.agrs = null;
	}

}
