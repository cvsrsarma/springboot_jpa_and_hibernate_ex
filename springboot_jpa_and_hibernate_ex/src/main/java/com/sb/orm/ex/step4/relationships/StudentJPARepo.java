package com.sb.orm.ex.step4.relationships;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sb.orm.ex.entities.Student;

@Repository
public interface StudentJPARepo extends JpaRepository<Student, Long>{

	List<Student> findByName(String name);

}
