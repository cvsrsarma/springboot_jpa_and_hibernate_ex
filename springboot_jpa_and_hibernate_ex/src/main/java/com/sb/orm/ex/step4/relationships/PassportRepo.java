package com.sb.orm.ex.step4.relationships;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sb.orm.ex.step4.relationships.entities.Passport;

public interface PassportRepo extends JpaRepository<Passport, Long>{

}
