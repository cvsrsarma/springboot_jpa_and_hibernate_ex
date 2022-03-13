package com.sb.orm.ex.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.Data;

@Entity
@Data
public class Review {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "review_sq1")
	private Long id;
	
	@SequenceGenerator(name="review_sq", initialValue = 30000, allocationSize = 1)
	@Column(name = "description")
	private String description;
	
	public Review(String desc) {
		this.description=desc;
	}
	

}
