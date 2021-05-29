package com.learnspring.operations.constants;

public enum ReturnCodes {

	SUCCESS("Success"),
	ERROR("Error");

	private String value;
	
	ReturnCodes(String value) {
		this.value = value;
	}
	public String getValue() {
		return value;
	}
	
}
