package com.learnspring.resource;

public class LearnSpringResponse {

	private String operation;
	private String responseCode;
	private String errorMessage;
	
	public LearnSpringResponse(String operation, String responseCode) {
		this.operation = operation;
		this.responseCode = responseCode;
	}
	
	public LearnSpringResponse(String operation, String responseCode, String errorMessage) {
		this.operation = operation;
		this.responseCode = responseCode;
		this.errorMessage = errorMessage;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

}
