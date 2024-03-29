package com.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import com.demo.domain.User;

import com.demo.service.KafkaJsonProducer;

@RestController
@RequestMapping (path="api/v1/kafka")
public class KafkaJsonMessageController {
	
	private KafkaJsonProducer kafkaJsonProducer;
	
	public KafkaJsonMessageController(KafkaJsonProducer kafkaJsonProducer) {		
		this.kafkaJsonProducer=kafkaJsonProducer;		
	}
	
	@PostMapping(path="/publish/json")
	public ResponseEntity<String>publish(@RequestBody User user){
		kafkaJsonProducer.sendMessage(user);
		System.out.println("Sent user ="+user.toString());
		return ResponseEntity.ok("Sent Json user :" +user.toString());
				
	}
	
}
