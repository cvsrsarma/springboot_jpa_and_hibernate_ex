package com.sb.orm.ex.service;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sb.orm.ex.entities.Course;
import com.sb.orm.ex.step3.hibernatejparepo.CourseRepository;
import com.sb.orm.ex.utlity.Utlity;

@Service
@Transactional
public class CourseService {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	CourseRepository repo;
	
	public void runJPQLQueries() {
		jpql_Select();
		jpqlWhere();
		jpqlTyped();
		
	}
	
	public void generateCourseData() {
		for(int i=0; i<100; i++) {
		Course course = new Course("Course "+Utlity.generateRandomText(3)); 
		repo.save(course);
		logger.info("Course Saved, Course-> {}", course.toString());
		}
	}
	
	public void jpql_Select(){
		List courseList = repo.jpqlSelect();
		courseList.stream().forEach(x->{
			logger.info("jpql select, Course-> {}", x.toString());
		});
	} 
	
	public void jpqlWhere() {
		List courseList = repo.jpqlWhere();
		courseList.stream().forEach(x->{
			logger.info("jpql where Saved, Course-> {}", x.toString());
		});
	}
	
	public void jpqlTyped() {
		List<Course> courseList = repo.jpqlTyped();
		courseList.stream().forEach(x->{
		logger.info("Typed uery, Course-> {}", x.toString());
		});
	}

}
