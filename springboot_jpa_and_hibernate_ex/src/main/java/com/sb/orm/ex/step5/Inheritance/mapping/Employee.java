package com.sb.orm.ex.step5.Inheritance.mapping;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import lombok.Getter;
import lombok.Setter;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="employeeType")
@Setter@Getter
public abstract class Employee {
	
	@Id
	@GeneratedValue
	Long id;
	
	@Column(name="name", nullable = false)
	String name;

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + "]";
	}
	
	public Employee() {}
	public Employee(String name) {this.name=name;}
}
