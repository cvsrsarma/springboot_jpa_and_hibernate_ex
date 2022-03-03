package com.sb.orm.ex.step3.jpa01;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "person")
@Getter@Setter@AllArgsConstructor@ToString@NoArgsConstructor
public class PersonEntity {
	
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String location;
	private Date dob;

}
