package com.sb.orm.ex.datagenerator;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sb.orm.ex.entities.Course;
import com.sb.orm.ex.entities.Passport;
import com.sb.orm.ex.entities.Review;
import com.sb.orm.ex.entities.Student;
import com.sb.orm.ex.step3.hibernatejparepo.CourseJPARepo;
import com.sb.orm.ex.step3.hibernatejparepo.CourseRepository;
import com.sb.orm.ex.step4.relationships.PassportRepo;
import com.sb.orm.ex.step4.relationships.ReviewRepo;
import com.sb.orm.ex.step4.relationships.StudentJPARepo;
import com.sb.orm.ex.step4.relationships.emrepo.StudentEMRepo;
import com.sb.orm.ex.utlity.Utlity;


@Service
public class DataGenerator {
	Logger logger= LoggerFactory.getLogger(this.getClass());

	@Autowired
	StudentJPARepo sRepo;
	@Autowired
	PassportRepo pRepo;
	
	@Autowired
	ReviewRepo rRepo;
	
	@Autowired
	CourseRepository cRepo;
	
	@Autowired
	CourseJPARepo cJpaRepo;
	
	@Autowired
	StudentEMRepo sEMRepo;
	
	public Student createStudentData(Passport passport) {
			return sRepo.save(new Student(Utlity.generateRandomText(6), passport));
	}

	public void createData() {
		/*
		 * IntStream.range(0, 20).forEach(x->{ Passport passport = createPassportData();
		 * Student student= createStudentData(passport);
		 * logger.info("Student Create with {} and his passport {} ",student,passport);
		 * });
		 */
		
		//createReview();
		try {
		saveOrUpdateReveiw();
		//saveOrUpdateCourses();
		saveStudentAndCourses();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	@Transactional
	private void saveStudentAndCourses() {
		Student std= new Student(Utlity.generateRandomText(6));
		Course course= new Course("Course "+Utlity.generateRandomText(3));
		sRepo.save(std);
		cRepo.save(course);
		std.addCourse(course);
		course.addStudent(std);
		sRepo.save(std);
		
	}

	private void createDescriptionData() {
		for (int i = 0; i < 10; i++)
			rRepo.save(new Review(Utlity.generateRandomText(5)+" "+Utlity.generateRandomText(5)+" "+Utlity.generateRandomText(5)));
	}

	private Passport createPassportData() {
			return pRepo.save(new Passport(Utlity.generateRandomText(6)));
	}
	
	
	private Course createCourse() {
			Course course = new Course("Course "+Utlity.generateRandomText(3)); 
			cRepo.save(course);
			logger.info("Course Saved, Course-> {}", course.toString());
			return course;
	}
	
	@Transactional
	private void createReview() {
		for(int i=0; i<100;i++) {
			Course course= createCourse();
			Review review = new Review("Course Review :"+Utlity.generateRandomText(3));
			review.setCourse(course);
			rRepo.save(review);
		}
	}
	
	@Transactional
	private void saveOrUpdateReveiw() {
		List<Course> courses = cJpaRepo.findByNameLike("% M%");
		
		for(int i=0; i<courses.size();i++) {
			Review review1 = new Review("Course Review :"+courses.get(i).getName());
			Review review2 = new Review("Course Review :"+courses.get(i).getName());
			review1.setCourse(courses.get(i));
			rRepo.save(review1);
			review2.setCourse(courses.get(i));
			rRepo.save(review2);
		}
	}
	
	@Transactional
	private void saveOrUpdateCourses() {
		List<Course> courses = cJpaRepo.findByNameLike("%M");
		
		List<Student> stdList =sRepo.findAll();
		stdList.stream().forEach(std->{
			
				std.setCourses(courses);
			
		});
		sRepo.saveAll(stdList);
		
		/*
		 * for(int i=0; i<courses.size();i++) { Review review1 = new
		 * Review("Course Review :"+courses.get(i).getName()); Review review2 = new
		 * Review("Course Review :"+courses.get(i).getName());
		 * review1.setCourse(courses.get(i)); rRepo.save(review1);
		 * review2.setCourse(courses.get(i)); rRepo.save(review2); }
		 */
	}
	
	

}
