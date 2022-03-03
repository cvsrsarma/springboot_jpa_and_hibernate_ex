package com.sb.orm.ex.step2.jdbcex;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class PersonJdbcDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	//select * from person
	public List<Person> findAll(){
		return jdbcTemplate.query("select * from springdatajpa.person", new BeanPropertyRowMapper(Person.class));
	}
	
	public Person fingById(int id) {
		return jdbcTemplate.queryForObject("select * from springdatajpa.person where id=?", 
				new Object[] {id},new BeanPropertyRowMapper<Person>(Person.class));
	}
	
	public int deleteById(int id) {
		return jdbcTemplate.update("delete from springdatajpa.person where id=?",id);
	}
	
	public Person savePerson(int i, Date timestamp, String loc, String name) {
		jdbcTemplate.update("INSERT INTO springdatajpa.person(id, dob, location, name)	VALUES ("+i+",'"+timestamp+"', '"+loc+"', '"+name+"')");
		return fingById(i);
	}
}
