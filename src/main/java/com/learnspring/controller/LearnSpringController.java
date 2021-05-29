package com.learnspring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.learnspring.operations.LearnSpringOperations;
import com.learnspring.operations.LearnSpringOperationsFactory;
import com.learnspring.operations.constants.ErrorMessageConstants;
import com.learnspring.operations.constants.ReturnCodes;
import com.learnspring.resource.LearnSpringRequest;
import com.learnspring.resource.LearnSpringResponse;

@Controller
@RequestMapping("/springoperations")
public class LearnSpringController {
	
	private LearnSpringOperationsFactory learnSpringOperationsFactory;
	
	@Autowired
	public LearnSpringController(LearnSpringOperationsFactory learnSpringOperationsFactory) {
		this.learnSpringOperationsFactory = learnSpringOperationsFactory;
	}

	@PostMapping(/*produces=MediaType.APPLICATION_JSON*/)
	public @ResponseBody LearnSpringResponse printInput(@RequestBody LearnSpringRequest request) {
		LearnSpringOperations operation = learnSpringOperationsFactory.getLearnSpringOperations(request.getOperation());
		if(operation == null) {
			return new LearnSpringResponse(request.getOperation(), ReturnCodes.ERROR.getValue(), ErrorMessageConstants.OPERATION_NOT_FOUND.getValue());
		}
		return operation.performOperation(request);
	}

}
