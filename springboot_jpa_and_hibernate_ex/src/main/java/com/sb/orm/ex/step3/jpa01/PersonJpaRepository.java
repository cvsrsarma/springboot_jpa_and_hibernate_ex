package com.sb.orm.ex.step3.jpa01;

import java.sql.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

@Transactional
@Repository
public class PersonJpaRepository {
	
	@PersistenceContext
	EntityManager entityManager;
	
	public PersonEntity findbyId(int id){
		return entityManager.find(PersonEntity.class, id);
	}
	
	public List<PersonEntity> findAll(){
		return  entityManager.createQuery("Select t from " + PersonEntity.class.getSimpleName() + " t").getResultList();
	}
}
