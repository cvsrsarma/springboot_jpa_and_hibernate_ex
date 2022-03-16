package com.sb.orm.ex.step3.hibernatejparepo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sb.orm.ex.entities.Course;

@Repository
@Transactional
public class CourseRepository {
	
	@Autowired
	EntityManager em;
	
	public Course findById(Long id) {
		return em.find(Course.class, id);
	}
	
	@Transactional
	public Course deleteById(Long id) {
		Course course= em.find(Course.class, id);
		em.remove(course);
		return course;
	}
	
	@Transactional
	public Course save(Course course) {
		if(null==course.getId()) {
			em.persist(course);
		} else {
			em.merge(course);
		}
		return course;
	}

	public List jpqlSelect() {
		Query query = em.createQuery("select c from Course c");
		List resultList = query.getResultList();
		return resultList;
	}
	
	public List<Course> jpqlTyped(){
		TypedQuery<Course> typedQuery = em.createQuery("Select c from Course c", Course.class);
		List<Course> resultSet = typedQuery.getResultList();
		return resultSet;
	}
	
	public List<Course> jpqlWhere(){
		TypedQuery<Course> typedQuery= em.createQuery("Select c from Course c where name like 'Course %'",Course.class);
		List<Course> resultSet = typedQuery.getResultList();
		return resultSet;
	}

	public List<Course> findCoursesWithOutStudents() {
		TypedQuery<Course> cdTypedQuery=em.createQuery("select c from Course c where c.students is empty",  Course.class);
		return cdTypedQuery.getResultList();
	}
	
	public List<Course> findCoursesWith10OrMoreStudents() {
		TypedQuery<Course> cdTypedQuery=em.createQuery("select c from Course c where size(c.students) >10",  Course.class);
		return cdTypedQuery.getResultList();
	}

}
