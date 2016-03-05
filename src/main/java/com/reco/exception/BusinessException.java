package com.reco.exception;

public class BusinessException extends Exception {

	private String errorCode;

	public BusinessException(String message) {
		super(message);
	}

	public BusinessException(String message, Throwable t) {
		super(message, t);
		
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

}
