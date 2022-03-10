package com.sb.orm.ex.step4.relationships;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sb.orm.ex.step4.relationships.entities.Student;

@Repository
public interface StudentJPARepo extends JpaRepository<Student, Long>{

}
