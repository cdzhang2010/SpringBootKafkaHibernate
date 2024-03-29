package com.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import com.demo.domain.User;
import com.demo.util.AppConstants;

@Service
public class MessageUserProducer {

	@Autowired
	private KafkaTemplate<String, User> kafkaTemplate;
	
	public void sendMessage(User data) {
		Message<User> message=MessageBuilder.withPayload(data)
				.setHeader(KafkaHeaders.TOPIC, AppConstants.JSON_TOPIC_NAME)
				.build();
		System.out.println("User  ="+ message);
		kafkaTemplate.send(message);
	}
}
