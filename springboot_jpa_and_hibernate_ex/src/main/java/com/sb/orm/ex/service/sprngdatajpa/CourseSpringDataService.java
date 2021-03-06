package com.sb.orm.ex.service.sprngdatajpa;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.sb.orm.ex.entities.Course;
import com.sb.orm.ex.step8.springdatajpa.CourseSprngDataRepo;
import com.sb.orm.ex.utlity.Utlity;

@Service
public class CourseSpringDataService {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	CourseSprngDataRepo cRepo;
	
	public void courseSpringDataRunner() {
		findCourseByIdNotExist();
		findCourseById();
		createNewCourse();
		updateCourse();
		findAllCourse();
		sortCourse();
		paginationCourse();
		
		findByExamples();
		likeExamples();

		
	}
	
	private void likeExamples() {
		List<Course> c1	=cRepo.findByNameContaining("A");
		List<Course> c12=cRepo.findByNameContainsOrderByNameDesc("A");
		List<Course> c13=cRepo.findByNameIsContainingOrderById("A");
		
		logger.info("Find by Course name like--> {}",c1);
		logger.info("Find by Course name like--> {}",c12);
		logger.info("Find by Course name like--> {}",c13);
	}

	private void findByExamples() {
		Optional<Course> cc= cRepo.findById(101582L);
		String name= cc.get().getName();
		List<Course> c2=cRepo.findByName(name);
		logger.info("Find by Course name {}--> {}",name,c2);
		long l=c2.get(0).getId();
		List<Course> c1=cRepo.findByIdAndName(l, name);
		logger.info("Find by Course name {} and id {} --> {}",name,l,c1);
		List<Course> c3=cRepo.findByNameOrderByIdDesc(name);
		logger.info("findByName Order By Id Desc name {}--> {}",name,c3);
		long c4=cRepo.countByName(name);
		logger.info("countByName EET2SLW--> {}",c4);
		//List<Course> c5=cRepo.deleteByName(name);
		//logger.info("Delete Course with name {}--> {}",name,c5);
		Course c= cRepo.save(new Course(c2.get(0).getName()));
		logger.info("Course saved with {}--> {}",name,c);
	}

	private void paginationCourse() {
		long totalNumberOfRecoreds=cRepo.count();
		logger.info("Total number of records {}",totalNumberOfRecoreds);
		logger.info("Print only 10 records in a pages");
		for(int i=0; i<totalNumberOfRecoreds/10; i++) {
			PageRequest pageReq= PageRequest.of(i, 10);
			Page<Course> coursesPage=cRepo.findAll(pageReq);
			logger.info("Page number {}, --> Records {}",i,coursesPage.getContent());
		}
	}

	private void sortCourse() {
		List<Course> courses=cRepo.findByIdBetween(101579L, 101589L);
		List<Course> coursesOrderByName=cRepo.findByIdBetweenOrderByNameAsc(101579L, 101589L);
		logger.info("Selected courses without sorting {}",courses);
		logger.info("Selected courses with sorting {}",coursesOrderByName);
		
	}

	private void findAllCourse() {
		List<Course> allCourses=cRepo.findAll();
		logger.info("Total number of courses exist {}",allCourses.size());
	}

	private void updateCourse() {
		Course course = findCourseById();
		if(null!=course) {
			logger.info("Course Details -> {}",course.toString());
			course.setName(Utlity.generateRandomText(7));
			cRepo.save(course);
			logger.info("Course Details -> {}",course.toString());
		}
			
	}

	private void createNewCourse() {
		String name = Utlity.generateRandomText(7);
		Course course = new Course(name);
		cRepo.save(course);
	}

	public Course findCourseById() {
		Optional<Course> optional = cRepo.findById(101582L);
		logger.info("{} Course exist ",optional.isPresent());
		return optional.isPresent()?optional.get():null;
	}
	
	public void findCourseByIdNotExist() {
		Optional<Course> optional = cRepo.findById(5000L);
		logger.info("{} Course exist ",optional.isPresent());
	}

}
