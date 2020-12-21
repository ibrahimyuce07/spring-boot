package com.ibrahim.springboot.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ibrahim.springboot.entity.Employee;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {

	// define field for entitymanager //set up constructor injection
	@Autowired
	private EntityManager entityManager;

	@Override
	@Transactional
	public List<Employee> findAll() {

		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);

		// create query
		TypedQuery<Employee> theQuery = currentSession.createQuery("from Employee", Employee.class);
		// Query deprecated

		// execute query and get result list
		List<Employee> employees = theQuery.getResultList();

		// return the results
		return employees;
	}

	@Override
	@Transactional
	public Employee findById(int theId) {

		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);

		// get the employee
		Employee theEmployee = currentSession.get(Employee.class, theId);

		return theEmployee;
	}

	@Override
	@Transactional
	public void save(Employee employee) {
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);

		// save employee
		currentSession.saveOrUpdate(employee);
	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		//delete object with primary key
		TypedQuery theQuery = currentSession.createQuery("delete from Employee where id=:employeeId");
		theQuery.setParameter("employeeId", theId);
		theQuery.executeUpdate();
	}

}
