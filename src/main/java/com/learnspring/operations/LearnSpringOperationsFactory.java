package com.learnspring.operations;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.learnspring.operations.impl.LearnBasicOperation;
import com.learnspring.operations.impl.LearnExternalAPIHitOperation;
import com.learnspring.operations.impl.LearnSendEmailOperation;

@Component
public class LearnSpringOperationsFactory {

	private static Map<String, LearnSpringOperations> SPRING_OPERATION_MAP = new HashMap<>();
	private LearnBasicOperation learnBasicOperation;
	private LearnExternalAPIHitOperation learnExternalAPIHitOperation;
	private LearnSendEmailOperation learnSendEmailOperation;
	
	@Autowired
	public LearnSpringOperationsFactory(LearnBasicOperation learnBasicOperation, LearnExternalAPIHitOperation learnExternalAPIHitOperation,
			LearnSendEmailOperation learnSendEmailOperation) {
		this.learnBasicOperation = learnBasicOperation;
		this.learnExternalAPIHitOperation = learnExternalAPIHitOperation;
		this.learnSendEmailOperation = learnSendEmailOperation;
	}
	
	@PostConstruct
	public final void initialize() {
		SPRING_OPERATION_MAP.put("BASIC", learnBasicOperation);
		SPRING_OPERATION_MAP.put("EXTERNAL_API", learnExternalAPIHitOperation);
		SPRING_OPERATION_MAP.put("SEND_EMAIL", learnSendEmailOperation);
	}
	
	public LearnSpringOperations getLearnSpringOperations(String operation) {
		return SPRING_OPERATION_MAP.get(operation);
	}
}
