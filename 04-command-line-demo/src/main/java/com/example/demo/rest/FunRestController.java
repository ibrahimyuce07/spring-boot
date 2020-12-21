package com.example.demo.rest;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

	//expose "/" that return "Hello World"
	
	@GetMapping("/")
	public String sayHello() {
      
		return "Hello World! Time on server is "+ LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE);
	}
	
	
}
 