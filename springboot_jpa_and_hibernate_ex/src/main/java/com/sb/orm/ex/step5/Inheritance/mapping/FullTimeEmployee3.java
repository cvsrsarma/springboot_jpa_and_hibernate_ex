package com.sb.orm.ex.step5.Inheritance.mapping;

import java.math.BigDecimal;

import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter@Getter
public class FullTimeEmployee3 extends Employee3 {
	
	private BigDecimal salary;
	
	public FullTimeEmployee3(String name, BigDecimal salary) {
		super(name);
		this.salary=salary;
	}

	public FullTimeEmployee3() {}
}
