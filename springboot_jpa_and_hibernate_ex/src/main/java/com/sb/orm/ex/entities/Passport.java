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


@Entity@NoArgsConstructor
@Data
public class Passport {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pssprt_sq1")
	private Long id;
	
	@SequenceGenerator(name="pssprt_sq",initialValue = 10000, allocationSize = 1)
	
	@Column(name="number", nullable = false)
	private String number;

	public Passport(String number){
		this.number=number;
	}
	
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "passport")
	public Student student;

	@Override
	public String toString() {
		return "Passport [id=" + id + ", number=" + number + "]";
	}
	
	
}
