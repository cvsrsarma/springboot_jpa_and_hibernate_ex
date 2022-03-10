package com.sb.orm.ex.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sb.orm.ex.step3.jpa01.PersonEntity;
import com.sb.orm.ex.step3.jpa01.PersonJpaRepository;
import com.sb.orm.ex.utlity.Utlity;

@Service
public class PresonService {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	PersonJpaRepository personRepo;
	
	public void runPersonRepo(){
		List<PersonEntity> personList = personRepo.findAll();
		logger.info("All Users list size -> {}", personList.size());
		logger.info("All Users -> {}", personList);
		logger.info("Find User {} -> {}", 100001, personRepo.findbyId(100001));
		logger.info("Save User {} ->{}", personList.size() + 100001,
				personRepo.savePerson(Utlity.createRandomDate(),
						Utlity.generateRandomCity(), Utlity.generateRandomName()));
	}

}
