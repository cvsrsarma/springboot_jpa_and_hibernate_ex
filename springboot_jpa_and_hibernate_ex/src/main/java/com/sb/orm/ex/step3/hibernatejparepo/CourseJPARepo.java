package com.sb.orm.ex.step3.hibernatejparepo;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sb.orm.ex.entities.Course;

@Repository
public interface CourseJPARepo extends JpaRepository<Course, Long> {
	
	@Query(value="select c from Course c where c.name like ?1")
	public List<Course> findByNameLike(@Param("name") String name);

}
