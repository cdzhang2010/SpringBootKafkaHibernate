package com.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.demo.domain.User;
import com.demo.model.UserRepository;
import com.demo.util.AppConstants;


@Service
public class KafkaJsonConsumer {

	@Autowired
	private UserRepository userRepository;
	
	//private static final Logger LOGGER=(Logger) LoggerFactory.getLogger(KafkaJsonConsumer.class);
	
	@KafkaListener(topics = AppConstants.JSON_TOPIC_NAME, groupId = AppConstants.GROUP_ID)
	public void consume(User user) {
		System.out.println("Received User -> "+ user.toString());
		userRepository.save(user);
	}
}
