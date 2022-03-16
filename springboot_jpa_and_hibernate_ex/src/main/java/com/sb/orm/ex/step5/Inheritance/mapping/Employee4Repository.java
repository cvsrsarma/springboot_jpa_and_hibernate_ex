package com.sb.orm.ex.step5.Inheritance.mapping;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class Employee4Repository {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	EntityManager em;
	
	public void insertAnEmployee(Employee4 emp) {
		em.persist(emp);
	}
	
	public List<Employee4> retrieveAllEmployees() {
		List<Employee4> empList = new ArrayList<Employee4>();
		empList.addAll(em.createQuery("Select e from PartTimeEmployee4 e", PartTimeEmployee4.class).getResultList());
		empList.addAll(em.createQuery("Select e from FullTimeEmployee4 e", FullTimeEmployee4.class).getResultList());
		
		return empList;
	}

}
