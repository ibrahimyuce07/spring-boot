package com.ibrahim.springboot.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibrahim.springboot.dao.EmployeeDAO;
import com.ibrahim.springboot.entity.Employee;
import com.ibrahim.springboot.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

	// quick bad code: inject employee dao for now , refactor later
	@Autowired
	private EmployeeService service;

	// expose /employees and return list of employees
	@GetMapping("/employees")
	public List<Employee> findAll() {

		return service.findAll();
	}



}
