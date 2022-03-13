package com.sb.orm.ex.step3.jpa01;

import java.sql.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.sb.orm.ex.entities.PersonEntity;
import com.sb.orm.ex.utlity.Utlity;

@Transactional
@Repository
public class PersonJpaRepository {
	
	Logger logger=LoggerFactory.getLogger(this.getClass());
	
	@PersistenceContext
	EntityManager entityManager;
	
	public PersonEntity findbyId(int id){
		return entityManager.find(PersonEntity.class, id);
	}
	
	public List<PersonEntity> findAll(){
		List<PersonEntity> personList = null;
		boolean flag=Utlity.generateRandomBolean(); 
		logger.info("find all running using {}", flag?"createQuery":"namedquery");
		if(flag) {
			
			personList=  entityManager.createQuery("Select t from " + PersonEntity.class.getSimpleName() + " t").getResultList();
		}
		else{
			TypedQuery<PersonEntity> namedQuery= entityManager.createNamedQuery("find_all_persons", PersonEntity.class);
			personList=namedQuery.getResultList();
		}
		return personList;
	}

	public PersonEntity deleteById(int i) {
		PersonEntity pe=findbyId(i);
		entityManager.remove(pe);
		return pe;  
	}

	public PersonEntity savePerson(Date createRandomDate, String generateRandomCity, String generateRandomName) {
		PersonEntity person = new PersonEntity();//No need to set id, it will get id from hibernate sequence. 
		person.setDob(createRandomDate); person.setLocation(generateRandomName);person.setName(generateRandomName);
		entityManager.merge(person);
		return person;
	}

}
