package com.sb.orm.ex.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

	public void process() {
		cService.runJPQLQueries();
		pService.runPersonRepo();
		jdbcService.runJdbcDao();
		servie.runJPQLMethods();
		sService.runStudentRepo();
	}

}
