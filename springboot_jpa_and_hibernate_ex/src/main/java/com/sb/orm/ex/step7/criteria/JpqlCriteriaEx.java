package com.sb.orm.ex.step7.criteria;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sb.orm.ex.entities.Course;
import com.sb.orm.ex.entities.CourseDetails;

@Repository
public class JpqlCriteriaEx {
	
	@Autowired
	EntityManager em;
	
	public List<CourseDetails> listOfCourses() {
		CriteriaBuilder cb= em.getCriteriaBuilder();
		CriteriaQuery<CourseDetails> cq = cb.createQuery(CourseDetails.class);
		Root<CourseDetails> from = cq.from(CourseDetails.class);
		TypedQuery<CourseDetails> query = em.createQuery(cq.select(from));
		List<CourseDetails> resultList = query.getResultList();
		return resultList;
	}
	
	public List<CourseDetails> listOfCoursesNameLike(String name) {
		CriteriaBuilder cb= em.getCriteriaBuilder();
		CriteriaQuery<CourseDetails> cq = cb.createQuery(CourseDetails.class);
		Root<CourseDetails> from = cq.from(CourseDetails.class);
		Predicate like = cb.like(from.get("courseName"), name);
		cq.where(like);
		TypedQuery<CourseDetails> query = em.createQuery(cq.select(from));
		List<CourseDetails> resultList = query.getResultList();
		return resultList;
	}
	
	public List<Course> listOfCourseWithStudnets(){
		CriteriaBuilder cb= em.getCriteriaBuilder();
		CriteriaQuery<Course> cq = cb.createQuery(Course.class);
		Root<Course> from = cq.from(Course.class);
		//Join<Object, Object> join = from.join("students");
		Join<Object, Object> join = from.join("students", JoinType.LEFT);
		TypedQuery<Course> tcq = em.createQuery(cq.select(from));
		List<Course> resultList = tcq.getResultList();
		return resultList;
	}
}