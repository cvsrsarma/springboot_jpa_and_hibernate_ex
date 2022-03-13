package com.sb.orm.ex.entities;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "person")
@Getter@Setter@AllArgsConstructor@ToString@NoArgsConstructor
@NamedQuery(name="find_all_persons", query="select p from PersonEntity p")
public class PersonEntity {
	
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String location;
	private Date dob;

}
