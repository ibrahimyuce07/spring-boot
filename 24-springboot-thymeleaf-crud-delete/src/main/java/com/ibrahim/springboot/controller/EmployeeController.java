package com.ibrahim.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ibrahim.springboot.entity.Employee;
import com.ibrahim.springboot.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService service;

	// add mapping for /list
	@GetMapping("/list")
	public String listEmployees(Model model) {

		// get employees from database
		List<Employee> employees = service.findAll();

		// add to the spring model
		model.addAttribute("employees", employees);
		return "employees/list-employees";

	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {

		// create model attribute to bind form data
		Employee theEmployee = new Employee();
		model.addAttribute("employee", theEmployee);
		return "employees/employee-form";

	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("employeeId") int theId, Model model) {

		// get employee from service
		Employee theEmployee = service.findById(theId);
		// set employee as a model attribute to prepopulate form
		model.addAttribute("employee", theEmployee);
		// send over to our form
		return "employees/employee-form";
	}

	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee") Employee theEmployee) {

		// save the employee
		service.save(theEmployee);
		// use a redirect to prevent duplicates
		return "redirect:/employees/list";
	}

	@GetMapping("/delete")
	public String delete(@RequestParam("employeeId") int theId) {
		// delete employee
		service.deleteById(theId);
		// redirect to /employe/list
		return "redirect:/employees/list";
	}

}
