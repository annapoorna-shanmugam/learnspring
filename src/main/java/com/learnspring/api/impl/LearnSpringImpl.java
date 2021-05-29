package com.learnspring.api.impl;

import com.learnspring.api.LearnSpring;
import com.learnspring.operations.constants.ReturnCodes;
import com.learnspring.resource.LearnSpringRequest;
import com.learnspring.resource.LearnSpringResponse;

/*
 * LearnSpringResource is the starting point when RESTEasy is added as dependency in our pom.xml
 * This is the implementation of LearnSpringResource
 */


public class LearnSpringImpl implements LearnSpring {

	@Override
	public LearnSpringResponse learnSpringOperations(LearnSpringRequest learnSpringRequest) {
		return new LearnSpringResponse(learnSpringRequest.getOperation(), ReturnCodes.SUCCESS.getValue());
	}

}
