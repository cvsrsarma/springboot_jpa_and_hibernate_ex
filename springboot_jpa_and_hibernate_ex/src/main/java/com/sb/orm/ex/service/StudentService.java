package com.sb.orm.ex.service;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sb.orm.ex.step4.relationships.PassportRepo;
import com.sb.orm.ex.step4.relationships.StudentJPARepo;
import com.sb.orm.ex.step4.relationships.emrepo.PassportEmRepo;
import com.sb.orm.ex.step4.relationships.emrepo.StudentEMRepo;

@Service
@Transactional
public class StudentService {
	
	Logger logger= LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	StudentJPARepo sRepo;
	
	@Autowired
	PassportRepo pRepo;
	
	@Autowired
	StudentEMRepo studentEm;
	@Autowired
	PassportEmRepo passportEm;

	public void runStudentRepo() {
		try {
			logger.info("{} running student find by id ",this.getClass().getName());
		findStudentById(152L);
		findStudentByPassportId(152L);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	private void findStudentByPassportId(long l) {
		studentEm.retrieveStudentDetails(l);
		//Optional<Passport> passport = pRepo.findById(l);
		/*
		 * passport.ifPresent(pssprt->{
		 * logger.debug("Passport details {}",pssprt.toString());
		 * logger.info("Student details {}",pssprt.getStudent().toString());
		 * //logger.info("Course Saved, Course-> {}", courseDetails.toString()); });
		 */
	}
	
	public void findStudentById(Long id) {
		passportEm.retrivePassportDetails(id);
		//Optional<Student> student = sRepo.findById(id);
		/*if(student.isPresent()) {
			logger.info("Student details {}",student.get().toString());
			//logger.debug("Student passport details {}",student.get().getPassport().toString());
		}*/
		/*
		 * student.ifPresent(stdnt->{
		 * logger.debug("Student details {}",stdnt.toString());
		 * logger.debug("Student passport details {}",stdnt.getPassport().toString());
		 * });
		 */
	}

}
