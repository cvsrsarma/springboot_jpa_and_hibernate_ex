package com.sb.orm.ex.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data@NoArgsConstructor
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "stdnt_sq1")
	@SequenceGenerator(name = "stdnt_sq", initialValue = 20000, allocationSize = 5)
	private Long id;
	@Column(name = "name")
	private String name;
	
	public Student(String name, Passport passport) {
		this.name=name;
		this.passport=passport;
		this.courses = new ArrayList<Course>();
	}
	public Student(String name) {
		this.name=name;
		this.courses = new ArrayList<Course>();
	}
	
	@OneToOne(fetch = FetchType.LAZY)
	private Passport passport;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name = "student_course",joinColumns = @JoinColumn(name="student_id"),inverseJoinColumns =@JoinColumn(name="course_id"))
	private List<Course> courses;

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + "]";
	}
	
	public void addCourse(Course c) {
		if(null==this.courses)
			this.courses = new ArrayList<Course>();
		this.courses.add(c);
	}
	
	
}
