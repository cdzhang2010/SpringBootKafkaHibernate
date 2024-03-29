package com.demo.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.service.KafKaConsumer;
import com.demo.service.KarfkaProducer;

@RestController
@RequestMapping("/api/v1/kafka")
public class KafkaProducerController {
	 private KarfkaProducer karfkaProducer;
	 
	    public KafkaProducerController(KarfkaProducer karfkaProducer) {
	        this.karfkaProducer = karfkaProducer;
	    }

	    //HTTP:localhost:8080/api/v1/kafka/publish?message=Hello World
	    @GetMapping("/publish")
	    public ResponseEntity<String> publish(@RequestParam("message") String message){
	        karfkaProducer.sendMessage(message);
	        return ResponseEntity.ok("Message sent to kafka topic");
	    }
	
}
