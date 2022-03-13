package com.sb.orm.ex.step3.hbrmtandjpa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.sb.orm.ex.JPADemoApplication;
import com.sb.orm.ex.entities.Course;
import com.sb.orm.ex.step3.hibernatejparepo.CourseRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = JPADemoApplication.class)
class CourseRepositoryTest {

	@Autowired
	CourseRepository courseRepo;

	@Test
	public void findById_basicTest() {
		Course course = courseRepo.findById(100001L);
		assertEquals("Course JPA", course.getName());
	}

	@Test
	@Transactional
	public void saveCourse_basicTest() {
		Course course = courseRepo.findById(100001L);
		assertEquals("Course JPA", course.getName());
		course.setName("Course JPA-Updated");
		Course course1 = courseRepo.save(course);
		assertEquals("Course JPA-Updated", course1.getName());
	}

	
	@Test
	@Transactional 
	public void deleteById_basicTest() {
	  courseRepo.deleteById(100001L); 
	  assertNull(courseRepo.findById(100001L));
	}
	
	@Test
	public void jpqlSelect_Test() {
		List list = courseRepo.jpqlSelect();
		assertNotNull(list);
	}
	
	@Test
	public void jpqlTyped_Test() {
		List<Course> courseList = courseRepo.jpqlTyped();
		assertNotNull(courseList);
		
	}
	 

}
