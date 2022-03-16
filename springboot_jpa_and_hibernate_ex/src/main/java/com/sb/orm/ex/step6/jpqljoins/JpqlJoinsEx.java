package com.sb.orm.ex.step6.jpqljoins;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class JpqlJoinsEx {
	
	@Autowired
	EntityManager em;
	
	public List<Object[]> getStudentJoinCourseDetails() {
		Query createQuery = em.createQuery("Select c, s from Course c join c.students s");
		List<Object[]> csObject= createQuery.getResultList();
		return csObject;
	}
	
	public List<Object[]> getStudentLeftJoinCourseDetails() {
		Query createQuery = em.createQuery("Select c, s from Course c left join c.students s");
		List<Object[]> csObject= createQuery.getResultList();
		return csObject;
	}

}
