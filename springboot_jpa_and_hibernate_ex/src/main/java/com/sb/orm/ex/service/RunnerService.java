package com.sb.orm.ex.service;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sb.orm.ex.step2.jdbcex.Person;
import com.sb.orm.ex.step2.jdbcex.PersonJdbcDao;
import com.sb.orm.ex.step3.hibernatejparepo.CourseRepository;
import com.sb.orm.ex.step3.jpa01.PersonEntity;
import com.sb.orm.ex.step3.jpa01.PersonJpaRepository;
import com.sb.orm.ex.step3.jpa02.JpqlService;
import com.sb.orm.ex.utlity.Utlity;

@Service
@Transactional
public class RunnerService {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired(required = true)
	PersonJdbcDao dao;
	
	@Autowired
	PersonJpaRepository personRepo;
	
	@Autowired
	CourseRepository courseRepo;
	
	@Autowired
	JpqlService servie;
	
	public void runJdbcDao() {
		List<Person> personList = dao.findAll();

		logger.info("All Users -> {}", personList);
		logger.info("Find User {} -> {}", 100001, dao.fingById(100001));
		logger.info("Save User {} ->{}", 10004, dao.savePerson(10004, Utlity.createRandomDate(),
				Utlity.generateRandomCity(), Utlity.generateRandomName()));
		logger.info("Delete User {} ->{}", 10004, dao.deleteById(10004));
		//logger.info("Save User {}->{}",personList.size()+100001,dao.savePerson(personList.size()+100001,
				//Utlity.createRandomDate(),Utlity.generateRandomCity(), Utlity.generateRandomName()));
	}
	
	public void runPersonRepo(){
		List<PersonEntity> personList = personRepo.findAll();
		logger.info("All Users list size -> {}", personList.size());
		logger.info("All Users -> {}", personList);
		logger.info("Find User {} -> {}", 100001, personRepo.findbyId(100001));
		logger.info("Save User {} ->{}", personList.size() + 100001,
				personRepo.savePerson(Utlity.createRandomDate(),
						Utlity.generateRandomCity(), Utlity.generateRandomName()));
	}
	
	public void runCourseRepo() {
		
		servie.runJPQLQueries();;
//		generateCourseData();
	}
	
	public void runCourseDetailsRepo() {
		servie.findAllCDData();
		//servie.generateCourseDetailsData();
	}
	
	
}
