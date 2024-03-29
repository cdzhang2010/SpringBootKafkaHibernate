package com.demo.service;

//https://www.youtube.com/watch?v=YDZs5gwkutE&list=PLGRDMO4rOGcNLwoack4ZiTyewUcF6y6BU&index=11

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.demo.util.AppConstants;

@Service
public class KafKaConsumer {

	private static final Logger LOGGER = LoggerFactory.getLogger(KafKaConsumer.class);

    @KafkaListener(topics = AppConstants.TOPIC_NAME,
                    groupId = AppConstants.GROUP_ID)
    public void consume(String message){
        LOGGER.info(String.format("Message received -> %s", message));
    }
}
