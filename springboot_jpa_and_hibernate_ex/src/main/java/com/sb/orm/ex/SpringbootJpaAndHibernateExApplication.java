package com.sb.orm.ex;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sb.orm.ex.step2.jdbcex.Person;
import com.sb.orm.ex.step2.jdbcex.PersonJdbcDao;
import com.sb.orm.ex.utlity.Utlity;

@SpringBootApplication
public class SpringbootJpaAndHibernateExApplication implements CommandLineRunner{
	
	@Autowired
	PersonJdbcDao dao;

	Logger logger=LoggerFactory.getLogger(this.getClass());
	
	public static void main(String[] args) {
		SpringApplication.run(SpringbootJpaAndHibernateExApplication.class, args);
	}

	@Override //This step for Step2 jdbc template ex
	public void run(String... args) throws Exception {
		try {
			List<Person> personList= dao.findAll();
			
		logger.info("All Users -> {}", personList);
		logger.info("Find User {} -> {}", 100001, dao.fingById(100001));
		logger.info("Delete User {} ->{}",10004,dao.deleteById(10004));
		logger.info("Save User {} ->{}",personList.size()+100001,dao.savePerson(personList.size()+100001, Utlity.createRandomDate(),Utlity.generateRandomCity(), Utlity.generateRandomName()));
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	

}
