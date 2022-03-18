package com.sb.orm.ex.step8.springdatajpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sb.orm.ex.entities.Course;

@Repository
public interface CourseSprngDataRepo extends JpaRepository<Course, Long>{

	List<Course> findByIdBetween(Long l1, Long l2);

	List<Course> findByIdBetweenOrderByNameAsc(long l, long m);

}
