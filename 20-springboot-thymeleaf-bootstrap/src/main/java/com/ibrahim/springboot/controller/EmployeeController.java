package com.ibrahim.springboot.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ibrahim.springboot.entity.Employee;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	@GetMapping("/list")
	public String listEmployees(Model model) {
		
		//create employees
		Employee emp1 =  new Employee(1, "Leslie", "Andrews", "leslie@luv2code.com");
		Employee emp2 =  new Employee(2, "Emma", "Baumgarten", "emma@luv2code.com");
		Employee emp3 =  new Employee(3, "Avani", "Gupt", "avani@luv2code.com");
		
		//create the list
		List<Employee> employees = new ArrayList<>();
		
		//add to the list
		employees.add(emp1);
		employees.add(emp2);
		employees.add(emp3);
		
		//add to the spring mvc model
		model.addAttribute("employees", employees);
		
		return "list-employees";
		
	}
}
