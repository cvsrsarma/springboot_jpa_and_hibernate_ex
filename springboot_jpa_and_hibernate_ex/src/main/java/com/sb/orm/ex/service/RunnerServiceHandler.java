package com.sb.orm.ex.service;

import java.math.BigDecimal;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sb.orm.ex.service.sprngdatajpa.CourseSpringDataService;
import com.sb.orm.ex.step5.Inheritance.mapping.Employee;
import com.sb.orm.ex.step5.Inheritance.mapping.EmployeeRepository;
import com.sb.orm.ex.step5.Inheritance.mapping.FullTimeEmployee;
import com.sb.orm.ex.step5.Inheritance.mapping.PartTimeEmployee;

@Service
public class RunnerServiceHandler {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	JpqlService servie;

	@Autowired
	JDBCService jdbcService;
	
	@Autowired
	PresonService pService;
	
	@Autowired
	CourseService cService;
	
	@Autowired
	StudentService sService;
	
	@Autowired
	EmployeeService eService;
	
	@Autowired
	CriteriaService criteriaService;
	
	@Autowired
	CourseSpringDataService cSpringDataService;
	

	public void process() {
		/*cService.runJPQLQueries();
		pService.runPersonRepo();
		jdbcService.runJdbcDao();
		servie.runJPQLMethods();
		sService.runStudentRepo();*/
		
		//eService.runEmpRepo();
		//servie.runJPQLMethods();
		//criteriaService.runCriteriaService();
		cSpringDataService.courseSpringDataRunner();
		
	}

}
