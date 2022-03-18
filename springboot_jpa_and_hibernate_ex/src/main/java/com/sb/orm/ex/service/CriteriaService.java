package com.sb.orm.ex.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sb.orm.ex.entities.Course;
import com.sb.orm.ex.entities.CourseDetails;
import com.sb.orm.ex.step7.criteria.JpqlCriteriaEx;

@Service
public class CriteriaService {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	JpqlCriteriaEx criteriaEx;
	
	public void runCriteriaService(){
		//getCourseDetails();
		//getListOfCoursesNameLike();
		listOfCourseWithStudnets();
	}
	
	public void getCourseDetails() {
		List<CourseDetails> listOfCourses = criteriaEx.listOfCourses();
		listOfCourses.stream().forEach(x->{
			logger.info("Course Details -> {}",x.toString());
		});
	}
	
	public void getListOfCoursesNameLike() {
		List<CourseDetails> listOfCourses = criteriaEx.listOfCoursesNameLike("X");
		listOfCourses.stream().forEach(x->{
			logger.info("Course Details name like X-> {}",x.toString());
		});
	}
	
	public void listOfCourseWithStudnets() {
		List<Course> listOfCourses = criteriaEx.listOfCourseWithStudnets();
		listOfCourses.stream().forEach(x->{
			logger.info("Course with students -> {}",x.toString());
		});
	}

}
