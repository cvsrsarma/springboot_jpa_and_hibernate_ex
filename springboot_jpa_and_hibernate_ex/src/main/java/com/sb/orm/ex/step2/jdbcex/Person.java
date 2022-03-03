package com.sb.orm.ex.step2.jdbcex;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter@Getter@AllArgsConstructor@ToString
public class Person {
	
	private int id;
	private String name;
	private String location;
	private Date dob;
	
	public Person() {}
}
