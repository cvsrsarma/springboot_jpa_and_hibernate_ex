package com.sb.orm.ex.step3.hibernatejparepo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NamedQuery;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sb.orm.ex.step3.hbrmtandjpa.CourseDetails;

@Repository
@NamedQuery(name="query_get_all_course_details", query = "select c from CourseDetails c")
public class CourseDetailsRepo {
	
	@Autowired
	EntityManager em;
	
	@Transactional
	public CourseDetails save(CourseDetails course) {
		if(null==course.getId()) {
			em.persist(course);
		} else {
			em.merge(course);
		}
		return course;
	}
	
	public List<CourseDetails> findAllCD(){
		TypedQuery<CourseDetails> cdTypedQuery=em.createNamedQuery("query_get_all_course_details",  CourseDetails.class);
		return cdTypedQuery.getResultList();
	}
}
