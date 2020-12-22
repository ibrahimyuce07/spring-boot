package com.ibrahim.springboot.service;

import java.util.List;

import com.ibrahim.springboot.entity.Employee;

public interface EmployeeService {

	public List<Employee> findAll();

	public Employee findById(int theId);

	public void save(Employee employee);

	public void deleteById(int theId);
}
