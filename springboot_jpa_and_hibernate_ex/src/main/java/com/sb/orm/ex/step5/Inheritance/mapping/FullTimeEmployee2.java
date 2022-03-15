package com.sb.orm.ex.step5.Inheritance.mapping;

import java.math.BigDecimal;

import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter@Getter
public class FullTimeEmployee2 extends Employee2 {
	
	private BigDecimal salary;
	
	public FullTimeEmployee2(String name, BigDecimal salary) {
		super(name);
		this.salary=salary;
	}

	public FullTimeEmployee2() {}
}
