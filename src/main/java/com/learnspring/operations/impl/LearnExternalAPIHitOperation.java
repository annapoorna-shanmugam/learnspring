package com.learnspring.operations.impl;

import java.util.Map;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.simple.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.learnspring.operations.LearnSpringOperations;
import com.learnspring.operations.constants.ReturnCodes;
import com.learnspring.resource.LearnSpringRequest;
import com.learnspring.resource.LearnExternalAPIHitResponse;

@Component
public class LearnExternalAPIHitOperation implements LearnSpringOperations{

	private static final String EXTERNAL_API = "https://api.coinbase.com/v2/exchange-rates?currency=BTC";
	
	@Override
	public LearnExternalAPIHitResponse performOperation(LearnSpringRequest request) {
		Response response = hitExternalAPI();
		JSONObject json = mapExternalAPIResponse(response);
		return buildResponse(request.getOperation(), json);
	}
	
	private Response hitExternalAPI() {
		Client client = ClientBuilder.newBuilder().build();
		WebTarget webTarget = client.target(EXTERNAL_API);
		Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
		return invocationBuilder.get();
	}
	
	private LearnExternalAPIHitResponse buildResponse(String operation, JSONObject json) {
		LearnExternalAPIHitResponse response = new LearnExternalAPIHitResponse(operation, ReturnCodes.SUCCESS.getValue());
		if(json != null && json.get("data") != null) {
			Map data = (Map) json.get("data");
			Map rates = (Map) data.get("rates");
			String val = rates != null ? (String) rates.get("AED") : "anu123";
			response.setRate(val);
		}
		return response;
	}
	
	private JSONObject mapExternalAPIResponse(Response response) {
		if(HttpStatus.OK.value() == response.getStatus()
				|| HttpStatus.CREATED.value() == response.getStatus()) {
			String val = response.readEntity(String.class);
			ObjectMapper mapper = new ObjectMapper();
			try {
				return mapper.readValue(val, JSONObject.class);
			} catch (Exception e) {
				return null;
			} 
		}
		
		return null;
	}

}
