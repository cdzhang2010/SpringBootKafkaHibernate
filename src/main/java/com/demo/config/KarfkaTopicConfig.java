package com.demo.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

import com.demo.util.AppConstants;

@Configuration
public class KarfkaTopicConfig {
	
	@Bean
    public NewTopic createTopic(){
        return TopicBuilder.name(AppConstants.TOPIC_NAME)
                .build();
    }
	
	@Bean
	public NewTopic createJsonTopic() {
		return TopicBuilder.name(AppConstants.JSON_TOPIC_NAME).build();
	}

}
