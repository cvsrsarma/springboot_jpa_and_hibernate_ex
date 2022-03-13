package com.sb.orm.ex.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sb.orm.ex.entities.Person;
import com.sb.orm.ex.step2.jdbcex.PersonJdbcDao;
import com.sb.orm.ex.utlity.Utlity;

@Service
public class JDBCService {
	

	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired(required = true)
	PersonJdbcDao dao;
	
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

}
