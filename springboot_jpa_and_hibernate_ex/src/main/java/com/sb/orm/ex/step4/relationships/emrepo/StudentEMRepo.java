package com.sb.orm.ex.step4.relationships.emrepo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
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
	
	public List<Student> retrieveStudentsLikePasssport(String passportNbr) {
		TypedQuery<Student> tQuery = em.createQuery("select s from Student s where s.passport.number like '%"+passportNbr+"%'",Student.class);
		return tQuery.getResultList();
	}


}
