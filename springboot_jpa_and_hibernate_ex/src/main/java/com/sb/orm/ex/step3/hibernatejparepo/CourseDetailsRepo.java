package com.sb.orm.ex.step3.hibernatejparepo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sb.orm.ex.step3.hbrmtandjpa.CourseDetails;

@Repository
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
	
	public List<CourseDetails> findCoursesByNativeQuery() {
		Query query = em.createNativeQuery("select * from springdatajpa.course_details", CourseDetails.class);
		return query.getResultList();
	}

	public List<CourseDetails> findCoursesByNativeQueryParam() { 
		Query query = em.createNativeQuery("select * from springdatajpa.course_details where course_name like :name "
				+ "and field_in_study like :field", CourseDetails.class);
		query.setParameter("name", "'%Q%'");
		query.setParameter("field", "'%0%'");

		return query.getResultList(); 
	}
	
	public List<CourseDetails> findCoursesByNativeQueryParam02() { 
		//
		Query query = em.createNativeQuery("SELECT id, course_name, create_date, field_in_study, lst_updtd_tmstmp\r\n"
				+ "	FROM springdatajpa.course_details where course_name like ? and field_in_study like ?;", CourseDetails.class).setParameter(1, "'%Y%'");
		query.setParameter(2, "'%O%'");
		return query.getResultList();
	}
}
