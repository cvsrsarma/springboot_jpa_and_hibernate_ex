package com.sb.orm.ex;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sb.orm.ex.step3.jpa01.PersonEntity;
import com.sb.orm.ex.step3.jpa01.PersonJpaRepository;

@SpringBootApplication
@Transactional
public class JPADemoApplication  implements CommandLineRunner{

Logger logger=LoggerFactory.getLogger(this.getClass());

	@Autowired
	PersonJpaRepository personRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringbootJpaAndHibernateExApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		try {
			List<PersonEntity> personList= personRepo.findAll();
			logger.info("All Users -> {}", personList);
			logger.info("Find User {} -> {}", 100001, personRepo.findbyId(100001));
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
