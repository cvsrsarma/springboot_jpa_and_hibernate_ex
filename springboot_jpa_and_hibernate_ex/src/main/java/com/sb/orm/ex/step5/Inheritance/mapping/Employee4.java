package com.sb.orm.ex.step5.Inheritance.mapping;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;

import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
/*MappedSuperclass annotation can be mapped in the same way as an entity except that the 
		mappings will apply only to its subclasses since no table exists for the mapped superclass itself.*/
@Setter@Getter
public abstract class Employee4 {
	
	@Id
	@GeneratedValue
	Long id;
	
	@Column(name="name", nullable = false)
	String name;

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + "]";
	}
	
	public Employee4() {}
	public Employee4(String name) {this.name=name;}
}
