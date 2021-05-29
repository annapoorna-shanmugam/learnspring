package com.learnspring.operations.constants;

public enum ErrorMessageConstants {

	OPERATION_NOT_FOUND("Operation not found");

	private String value;
	
	ErrorMessageConstants(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
	
}
