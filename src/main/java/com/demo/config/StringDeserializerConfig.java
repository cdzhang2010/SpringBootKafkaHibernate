package com.demo.config;

import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StringDeserializerConfig {
	
	@Bean
    public StringDeserializer stringDeserializer() {
        return new StringDeserializer();
    }
}
