package com.sb.orm.ex.service;

import java.math.BigDecimal;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sb.orm.ex.step5.Inheritance.mapping.Employee;
import com.sb.orm.ex.step5.Inheritance.mapping.Employee2;
import com.sb.orm.ex.step5.Inheritance.mapping.Employee2Repository;
import com.sb.orm.ex.step5.Inheritance.mapping.Employee3;
import com.sb.orm.ex.step5.Inheritance.mapping.Employee3Repository;
import com.sb.orm.ex.step5.Inheritance.mapping.Employee4;
import com.sb.orm.ex.step5.Inheritance.mapping.Employee4Repository;
import com.sb.orm.ex.step5.Inheritance.mapping.EmployeeRepository;
import com.sb.orm.ex.step5.Inheritance.mapping.FullTimeEmployee;
import com.sb.orm.ex.step5.Inheritance.mapping.FullTimeEmployee2;
import com.sb.orm.ex.step5.Inheritance.mapping.FullTimeEmployee3;
import com.sb.orm.ex.step5.Inheritance.mapping.FullTimeEmployee4;
import com.sb.orm.ex.step5.Inheritance.mapping.PartTimeEmployee;
import com.sb.orm.ex.step5.Inheritance.mapping.PartTimeEmployee2;
import com.sb.orm.ex.step5.Inheritance.mapping.PartTimeEmployee3;
import com.sb.orm.ex.step5.Inheritance.mapping.PartTimeEmployee4;

@Service
public class EmployeeService {
	
	Logger logger= LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	EmployeeRepository empRepo;
	
	@Autowired
	Employee2Repository emp2Repo;
	
	@Autowired
	Employee3Repository emp3Repo;
	
	@Autowired
	Employee4Repository emp4Repo;
	
	public void runEmpRepo() {
		empRepo.insertAnEmployee(new FullTimeEmployee("Jack", new BigDecimal("10000")));
		empRepo.insertAnEmployee(new PartTimeEmployee("Jill", new BigDecimal("20")));
		
		List<Employee> empList=empRepo.retrieveAllEmployees();
		logger.info("List of employees {}",empList);
		
		emp2Repo.insertAnEmployee(new FullTimeEmployee2("Jack", new BigDecimal("10000")));
		emp2Repo.insertAnEmployee(new PartTimeEmployee2("Jill", new BigDecimal("20")));
		
		List<Employee2> empList2=emp2Repo.retrieveAllEmployees();
		logger.info("List of employees {}",empList);
		
		emp3Repo.insertAnEmployee(new FullTimeEmployee3("Jack", new BigDecimal("10000")));
		emp3Repo.insertAnEmployee(new PartTimeEmployee3("Jill", new BigDecimal("20")));
		
		List<Employee3> empList3=emp3Repo.retrieveAllEmployees();
		logger.info("List of employees {}",empList);
		
		emp4Repo.insertAnEmployee(new FullTimeEmployee4("Jack", new BigDecimal("10000")));
		emp4Repo.insertAnEmployee(new PartTimeEmployee4("Jill", new BigDecimal("20")));
		
		List<Employee4> empList4=emp4Repo.retrieveAllEmployees();
		logger.info("List of employees {}",empList);
		
		
	}
}
