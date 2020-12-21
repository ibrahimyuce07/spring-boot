package com.ibrahim.springboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ibrahim.springboot.entity.Employee;

@RepositoryRestResource(path = "members") //now it's set to /members intead of default employees http://localhost:8080/magic-api/members
public interface EmployeeRepository extends JpaRepository<Employee, Integer> { //entity type, primary key

}
