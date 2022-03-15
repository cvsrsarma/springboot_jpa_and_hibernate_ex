package com.sb.orm.ex;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sb.orm.ex.datagenerator.DataGenerator;
import com.sb.orm.ex.service.RunnerServiceHandler;

@SpringBootApplication
public class SpringbootJpaAndHibernateExApplication implements CommandLineRunner {

	@Autowired
	RunnerServiceHandler service;

	@Autowired
	DataGenerator dataGen;

	public static void main(String[] args) {
		SpringApplication.run(SpringbootJpaAndHibernateExApplication.class, args);
	}

	@Override // This step for Step2 jdbc template ex
	public void run(String... args) throws Exception {
		try {
			dataGen.createData();
			//service.process();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
