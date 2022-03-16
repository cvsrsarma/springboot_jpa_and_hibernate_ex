package com.sb.orm.ex.step5.Inheritance.mapping;

import java.math.BigDecimal;

import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter@Getter
public class FullTimeEmployee4 extends Employee4 {
	
	private BigDecimal salary;
	
	public FullTimeEmployee4(String name, BigDecimal salary) {
		super(name);
		this.salary=salary;
	}

	public FullTimeEmployee4() {}
}
