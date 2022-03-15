package com.sb.orm.ex.step5.Inheritance.mapping;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class Employee2Repository {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	EntityManager em;
	
	public void insertAnEmployee(Employee2 emp) {
		em.persist(emp);
	}
	
	public List<Employee2> retrieveAllEmployees() {
		return em.createQuery("Select e from Employee2 e", Employee2.class).getResultList();
	}

}
