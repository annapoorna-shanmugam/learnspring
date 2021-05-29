package com.learnspring.operations.impl;

import org.springframework.stereotype.Component;

import com.learnspring.operations.LearnSpringOperations;
import com.learnspring.operations.constants.ReturnCodes;
import com.learnspring.resource.LearnSpringRequest;
import com.learnspring.resource.LearnSpringResponse;

@Component
public class LearnBasicOperation implements LearnSpringOperations{

	@Override
	public LearnSpringResponse performOperation(LearnSpringRequest request) {
		LearnSpringResponse response = new LearnSpringResponse(request.getOperation(), ReturnCodes.SUCCESS.getValue());
		return response;
	}

}
