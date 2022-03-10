package com.sb.orm.ex.step4.relationships.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Review {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "S_Review")
	private Long id;
	@Column(name = "description")
	private String description;
	
	public Review(String desc) {
		this.description=desc;
	}
	

}
