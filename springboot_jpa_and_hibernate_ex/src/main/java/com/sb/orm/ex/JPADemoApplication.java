package com.sb.orm.ex;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sb.orm.ex.step3.hibernatejparepo.CourseRepository;

@SpringBootApplication
@Transactional
public class JPADemoApplication  implements CommandLineRunner{

	Logger logger=LoggerFactory.getLogger(this.getClass());

	@Autowired
	CourseRepository courseRepo;

	public static void main(String[] args) {
		SpringApplication.run(SpringbootJpaAndHibernateExApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		try {
			logger.info("Course repofindBYid 100001L->{}",courseRepo.findById(100001L));
			//logger.info("Course repo deleteById 100001L->{}",courseRepo.deleteById(100001L));
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
