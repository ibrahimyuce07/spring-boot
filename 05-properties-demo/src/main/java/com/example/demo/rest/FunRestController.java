package com.example.demo.rest;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

	//inject properties for coach.name and team.name
	@Value("${coach.name}")
	private String coachName;
	@Value("${team.name}")
	private String teamName;
	
	//expose new endpoint for team info
	@GetMapping("/teaminfo")
	public String getTeamInfo() {
      
		return "Coach: " + coachName + ", Team: "+teamName;
	}
	
	//expose "/" that return "Hello World"
	@GetMapping("/")
	public String sayHello() {
      
		return "Hello World! Time on server is "+ LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE);
	}
	
	//expose a new endpoint 
	@GetMapping("/workout")
	public String getDailyWorkout() {
      
		return "Run a hard 5k!";
	}
}
 