package com.sb.orm.ex.service;

import java.math.BigDecimal;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sb.orm.ex.step5.Inheritance.mapping.Employee;
import com.sb.orm.ex.step5.Inheritance.mapping.EmployeeRepository;
import com.sb.orm.ex.step5.Inheritance.mapping.FullTimeEmployee;
import com.sb.orm.ex.step5.Inheritance.mapping.PartTimeEmployee;

@Service
public class EmployeeService {
	
	Logger logger= LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	EmployeeRepository empRepo;
	
	public void runEmpRepo() {
		empRepo.insertAnEmployee(new FullTimeEmployee("Jack", new BigDecimal("10000")));
		empRepo.insertAnEmployee(new PartTimeEmployee("Jill", new BigDecimal("20")));
		
		List<Employee> empList=empRepo.retrieveAllEmployees();
		logger.info("List of employees {}",empList);
	}

}
