package com.sb.orm.ex.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data@ToString@NoArgsConstructor
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "stdnt_sq1")
	@SequenceGenerator(name = "stdnt_sq", initialValue = 20000, allocationSize = 5)
	private Long id;
	@Column(name = "name")
	private String name;
	
	public Student(String name, Passport passport) {
		this.name=name;
		this.passport=passport;
	}
	
	@OneToOne(fetch = FetchType.LAZY)
	private Passport passport;
	
}
