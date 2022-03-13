package com.sb.orm.ex.step4.relationships.emrepo;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sb.orm.ex.entities.Student;

@Repository
@Transactional
public class StudentEMRepo {
	
	Logger logger= LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	EntityManager em;
	
	public void retrieveStudentDetails(long l) {
		Student student = em.find(Student.class, l);
		logger.info("Student details {} and his passport details {}",student.toString(),student.getPassport().toString());
	}


}
