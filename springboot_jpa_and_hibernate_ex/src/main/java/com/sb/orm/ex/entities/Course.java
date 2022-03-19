package com.sb.orm.ex.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter@Getter@AllArgsConstructor@NoArgsConstructor
@Cacheable
public class Course {

	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + "]";
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	private String name;
	
	public Course(String name) {this.name=name;}
	
	//One to Many
	@OneToMany(mappedBy = "course",cascade=CascadeType.ALL)
	private List<Review> reviews;
	
	public void setReview(Review review) throws Exception {
		throw new Exception("You can't set review, plz use Add review method");
	}
	
	public void addReview(Review review) {
		this.reviews.add(review);
	}
	
	public void removeReview(Review review) {
		this.reviews.remove(review);
	}
	
	@ManyToMany(mappedBy = "courses")
	private List<Student> students;
	
	public void addStudent(Student s) {
		if(null==this.students)
			this.students= new ArrayList<Student>();
		this.students.add(s);
	}
}
