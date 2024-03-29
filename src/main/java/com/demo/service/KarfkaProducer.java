package com.demo.service;


import com.demo.util.AppConstants;
import org.apache.kafka.clients.admin.NewTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KarfkaProducer {
	
	 private static final Logger LOGGER = LoggerFactory.getLogger(KarfkaProducer.class);

	    @Autowired
	    private KafkaTemplate<String, String> karfkaTemplate;

	    //http://localhost:8080/api/v1/kafka/publish?message=hello%20world
	    public void sendMessage(String message){
	        LOGGER.info(String.format("Message sent -> %s", message));
	        karfkaTemplate.send(AppConstants.TOPIC_NAME, message);
	    }
}
