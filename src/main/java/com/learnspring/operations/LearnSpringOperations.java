package com.learnspring.operations;

import org.springframework.stereotype.Component;

import com.learnspring.resource.LearnSpringRequest;
import com.learnspring.resource.LearnSpringResponse;

@Component
public interface LearnSpringOperations {

	LearnSpringResponse performOperation(LearnSpringRequest request);
}
