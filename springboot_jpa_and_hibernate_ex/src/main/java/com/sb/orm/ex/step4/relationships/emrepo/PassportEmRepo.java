package com.sb.orm.ex.step4.relationships.emrepo;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sb.orm.ex.entities.Passport;

@Repository
@Transactional
public class PassportEmRepo {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	EntityManager em;
	
	public void retrivePassportDetails(long l) {
		Passport passport = em.find(Passport.class,l);
		logger.info("Passport details {} and student details", passport.toString(),passport.getStudent().toString());
		
	}

}
