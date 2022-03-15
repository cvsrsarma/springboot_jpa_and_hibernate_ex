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
@Inheritance(strategy = InheritanceType.JOINED)//It will create 3 tables for each class and join while we run query.
@Setter@Getter
public abstract class Employee2 {
	
	@Id
	@GeneratedValue
	Long id;
	
	@Column(name="name", nullable = false)
	String name;

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + "]";
	}
	
	public Employee2() {}
	public Employee2(String name) {this.name=name;}
}
