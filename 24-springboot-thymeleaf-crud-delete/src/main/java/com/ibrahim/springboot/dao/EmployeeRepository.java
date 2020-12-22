package com.ibrahim.springboot.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ibrahim.springboot.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> { //entity type, primary key

	//add a method to sort by last name
	public List<Employee> findAllByOrderByLastNameAsc();
}
