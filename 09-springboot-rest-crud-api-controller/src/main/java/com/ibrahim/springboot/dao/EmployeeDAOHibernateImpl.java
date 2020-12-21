package com.ibrahim.springboot.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ibrahim.springboot.entity.Employee;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {

	//define field for entitymanager //set up constructor injection
	@Autowired
	private EntityManager entityManager;

//	@Autowired
//	public EmployeeDAOHibernateImpl(EntityManager theEntityManager) {
//		entityManager = theEntityManager;
//	}
	
	@Override
	@Transactional
	public List<Employee> findAll() {
		
		//get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		//create query
		TypedQuery<Employee> theQuery = currentSession.createQuery("from Employee", Employee.class);
		//Query deprecated
		
		//execute query and get result list
		List<Employee> employees = theQuery.getResultList();
		
		//return the results
		return employees;
	}

}
