package com.sb.orm.ex.service;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sb.orm.ex.entities.Course;
import com.sb.orm.ex.entities.CourseDetails;
import com.sb.orm.ex.entities.Student;
import com.sb.orm.ex.step3.hibernatejparepo.CourseDetailsRepo;
import com.sb.orm.ex.step3.hibernatejparepo.CourseRepository;
import com.sb.orm.ex.step4.relationships.emrepo.StudentEMRepo;
import com.sb.orm.ex.utlity.Utlity;

@Service
@Transactional
public class JpqlService {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	CourseDetailsRepo cdRepo;
	
	@Autowired
	CourseRepository cRepo;
	
	@Autowired
	StudentEMRepo sEMRepo;

	public void generateCourseDetailsData() {
		for (int i = 0; i < 100; i++) {
			CourseDetails courseDetails = new CourseDetails("Course " + Utlity.generateRandomText(4),
					Utlity.generateRandomText(6));
			cdRepo.save(courseDetails);
			logger.info("Course Saved, Course-> {}", courseDetails.toString());
		}
	}

	public void findAllCDData() {
		List<CourseDetails> cdList = cdRepo.findAllCD();
		cdList.stream().forEach(x -> {
			logger.info("CourseDetails Namedquery, Course-> {}", x.toString());
		});
	}

	public void findCoursesByNativeQuery() {
		List<CourseDetails> cdList = cdRepo.findCoursesByNativeQuery();
		cdList.stream().forEach(x -> {
			logger.info("CourseDetails native query, Course-> {}", x.toString());
		});
	}

	public void findCourseByNativeQueryParam() {
		List<CourseDetails> cdList = cdRepo.findCoursesByNativeQueryParam();
		cdList.stream().forEach(x -> {
			logger.info("CourseDetails native query with param, Course-> {}", x.toString());
		});
	}

	public void findCourseByNativeQueryParam02() {
		List<CourseDetails> cdList = cdRepo.findCoursesByNativeQueryParam02();
		cdList.stream().forEach(x -> {
			logger.info("CourseDetails native query02 with param, Course-> {}", x.toString());
		});
	}

	public void runJPQLMethods() {
		findAllCDData();
		//findCoursesByNativeQuery();
		findCourseByNativeQueryParam();
		findCourseByNativeQueryParam02();
		findCoursesWithOutStudents();
		findCoursesWith10OrMoreStudents();
		findCoursesOrderByStudents();
		retrieveStudentsLikePasssport();
		//generateCourseDetailsData();
	}

	private void retrieveStudentsLikePasssport() {
		List<Student> stdList= sEMRepo.retrieveStudentsLikePasssport("6");
		stdList.stream().forEach(x->{
			logger.info("Student details {} where passport number contains 6 ",x.toString());
		});
	}

	private void findCoursesOrderByStudents() {
		List<Course> cdList = cRepo.findCoursesOrderByStudents();
		cdList.stream().forEach(x -> {
			logger.info("CourseDetails Order by number of students {}", x.toString());
		});
		
	}

	private void findCoursesWith10OrMoreStudents() {
		List<Course> cdList = cRepo.findCoursesWith10OrMoreStudents();
		cdList.stream().forEach(x -> {
			logger.info("CourseDetails which doesn't have any students. {}", x.toString());
		});
	}

	private void findCoursesWithOutStudents() {
		List<Course> cdList = cRepo.findCoursesWithOutStudents();
		cdList.stream().forEach(x -> {
			logger.info("CourseDetails which does have more than 10 students. {}", x.toString());
		});
	}
}
