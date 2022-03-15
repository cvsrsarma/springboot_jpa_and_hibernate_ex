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
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)//It will create 2 tables for each concrete class with 3 colums id name salary or hourly wage
@Setter@Getter
public abstract class Employee3 {
	
	@Id
	@GeneratedValue
	Long id;
	
	@Column(name="name", nullable = false)
	String name;

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + "]";
	}
	
	public Employee3() {}
	public Employee3(String name) {this.name=name;}
}
