package com.sb.orm.ex.step4.relationships.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Passport {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "S_Pssprt")
	private int id;
	
	@Column(name="number", nullable = false)
	private String number;

	public Passport(String number){
		this.number=number;
	}
}
