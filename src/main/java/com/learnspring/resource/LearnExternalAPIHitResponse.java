package com.learnspring.resource;

public class LearnExternalAPIHitResponse extends LearnSpringResponse {

	public LearnExternalAPIHitResponse(String operation, String responseCode) {
		super(operation, responseCode);
	}
	
	public LearnExternalAPIHitResponse(String operation, String responseCode, String errorMessage) {
		super(operation, responseCode, errorMessage);
	}

	private String rate;

	public String getRate() {
		return rate;
	}

	public void setRate(String rate) {
		this.rate = rate;
	}
}
