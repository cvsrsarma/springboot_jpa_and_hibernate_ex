package com.sb.orm.ex.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="course_details")//It can be used when entity and actual table name is different
@Setter@Getter@AllArgsConstructor@NoArgsConstructor@ToString
@NamedQuery(name="query_get_all_course_details", query = "select c from CourseDetails c")
public class CourseDetails {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	@Column(name = "course_name")
	private String courseName;
	@Column(name ="field_in_study")
	private String field;
	
	@UpdateTimestamp
	@Column(name="lst_updtd_tmstmp")
	private LocalDateTime lastUpdatedDate;
	
	@CreatedDate
	private LocalDateTime createDate;
	
	public CourseDetails(String name,String field) {
		this.courseName=name;
		this.field=field;
		this.lastUpdatedDate = LocalDateTime.now();
		this.createDate = LocalDateTime.now();
		
	}
	

}
