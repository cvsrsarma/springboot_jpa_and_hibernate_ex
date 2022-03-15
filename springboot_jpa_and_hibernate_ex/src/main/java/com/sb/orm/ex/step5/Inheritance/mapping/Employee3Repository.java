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
public class Employee3Repository {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	EntityManager em;
	
	public void insertAnEmployee(Employee3 emp) {
		em.persist(emp);
	}
	
	public List<Employee3> retrieveAllEmployees() {
		return em.createQuery("Select e from Employee3 e", Employee3.class).getResultList();
	}

}
