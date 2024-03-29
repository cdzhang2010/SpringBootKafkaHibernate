package com.demo.service;

import org.springframework.messaging.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import com.demo.domain.User;
import com.demo.util.AppConstants;

@Service
public class KafkaJsonProducer {
	
	@Autowired
	private KafkaTemplate<String, User> kafkaTemplate;

	@Autowired //not required here
	public KafkaJsonProducer(KafkaTemplate<String, User> kafkaTemplate) {
		super();
		this.kafkaTemplate = kafkaTemplate;
	}
	
	public void sendMessage(User data) {
		Message<User> message=MessageBuilder.withPayload(data)
				.setHeader(KafkaHeaders.TOPIC, AppConstants.JSON_TOPIC_NAME)
				.build();
		System.out.println("Message ="+ message);
		kafkaTemplate.send(message);
		
	}
	
	

}
