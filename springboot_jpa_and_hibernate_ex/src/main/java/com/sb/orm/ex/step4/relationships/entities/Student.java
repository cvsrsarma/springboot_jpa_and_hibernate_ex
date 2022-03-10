package com.sb.orm.ex.step4.relationships.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity
@Data
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "S_SQ")
	private Long id;
	@Column(name = "name")
	private String name;
	
	public Student(String name, Passport passport) {
		this.name=name;
		this.passport=passport;
	}
	
	@OneToOne
	private Passport passport;
	
}
