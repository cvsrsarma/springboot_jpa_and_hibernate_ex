package com.sb.orm.ex.step5.Inheritance.mapping;

import java.math.BigDecimal;

import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter@Getter
public class PartTimeEmployee2 extends Employee2 {
	
	public PartTimeEmployee2(String name, BigDecimal hourlyWage) {
		super(name);
		this.hourlyWage = hourlyWage;
	}

	private BigDecimal hourlyWage;
	
	public PartTimeEmployee2() {};
	

}
