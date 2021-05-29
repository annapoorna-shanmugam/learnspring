package com.learnspring.operations.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import com.learnspring.operations.LearnSpringOperations;
import com.learnspring.operations.constants.ReturnCodes;
import com.learnspring.resource.LearnSpringRequest;
import com.learnspring.resource.LearnSpringResponse;

@Component
public class LearnSendEmailOperation implements LearnSpringOperations {
	
	private JavaMailSender javaMailSender;
	
	@Autowired
	public LearnSendEmailOperation(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}

	@Override
	public LearnSpringResponse performOperation(LearnSpringRequest request) {
		sendEmail();
		LearnSpringResponse response = new LearnSpringResponse(request.getOperation(), ReturnCodes.SUCCESS.getValue());
		return response;
	}
	
	private void sendEmail() {

        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo("annapoorna.shanmugam@gmail.com");

        msg.setSubject("Testing from Spring Boot");
        msg.setText("Hello World \n Spring Boot Email");

        javaMailSender.send(msg);

    }

}
