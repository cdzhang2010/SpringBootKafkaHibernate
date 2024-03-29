package com.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/")
public class IndexController {
	
	@RequestMapping(path="index")
	public ResponseEntity<String> index(){
		
		return ResponseEntity.ok("Hello World");
	}

}
