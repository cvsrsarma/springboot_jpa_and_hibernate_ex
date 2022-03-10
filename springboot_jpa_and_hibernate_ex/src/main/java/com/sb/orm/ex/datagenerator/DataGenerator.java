package com.sb.orm.ex.datagenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sb.orm.ex.step4.relationships.PassportRepo;
import com.sb.orm.ex.step4.relationships.ReviewRepo;
import com.sb.orm.ex.step4.relationships.StudentJPARepo;
import com.sb.orm.ex.step4.relationships.entities.Passport;
import com.sb.orm.ex.step4.relationships.entities.Review;
import com.sb.orm.ex.step4.relationships.entities.Student;
import com.sb.orm.ex.utlity.Utlity;

@Service
public class DataGenerator {

	@Autowired
	StudentJPARepo sRepo;
	@Autowired
	PassportRepo pRepo;
	
	@Autowired
	ReviewRepo rRepo;

	public Student createStudentData(Passport passport) {
			return sRepo.save(new Student(Utlity.generateRandomText(6), passport));
	}

	public void createData() {
		Passport passport = createPassportData();
		Student student= createStudentData(passport);
		
		createDescriptionData();
	}

	private void createDescriptionData() {
		for (int i = 0; i < 10; i++)
			rRepo.save(new Review(Utlity.generateRandomText(5)+" "+Utlity.generateRandomText(5)+" "+Utlity.generateRandomText(5)));
	}

	private Passport createPassportData() {
			return pRepo.save(new Passport(Utlity.generateRandomText(6)));
	}

}
