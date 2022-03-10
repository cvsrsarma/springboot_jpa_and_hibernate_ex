package com.sb.orm.ex.service;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sb.orm.ex.step4.relationships.StudentJPARepo;

@Service
@Transactional
public class StudentService {
	
	Logger logger= LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	StudentJPARepo sRepo;

	public void runStudentRepo() {
		
	}

}
