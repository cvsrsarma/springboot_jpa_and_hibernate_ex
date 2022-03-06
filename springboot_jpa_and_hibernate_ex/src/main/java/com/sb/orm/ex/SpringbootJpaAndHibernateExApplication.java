package com.sb.orm.ex;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sb.orm.ex.service.RunnerService;

@SpringBootApplication
public class SpringbootJpaAndHibernateExApplication implements CommandLineRunner {

	@Autowired
	RunnerService service;

	public static void main(String[] args) {
		SpringApplication.run(SpringbootJpaAndHibernateExApplication.class, args);
	}

	@Override // This step for Step2 jdbc template ex
	public void run(String... args) throws Exception {
		service.runJdbcDao();
		service.runPersonRepo();
		service.runCourseRepo();
		service.runCourseDetailsRepo();
		
	}

}
