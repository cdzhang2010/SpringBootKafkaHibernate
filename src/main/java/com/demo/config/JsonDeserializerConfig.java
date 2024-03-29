package com.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.support.serializer.JsonDeserializer;

@Configuration
public class JsonDeserializerConfig {
	
	@Bean
    public JsonDeserializer<Object> jsonDeserializer() {
        return new JsonDeserializer<>();
    }
}
