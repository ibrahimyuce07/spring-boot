package com.ibrahim.springboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ibrahim.springboot.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> { //entity type, primary key

	//that's it. no more boilerplate
}
