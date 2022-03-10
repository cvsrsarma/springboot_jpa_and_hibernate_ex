package com.sb.orm.ex.service;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sb.orm.ex.step3.hbrmtandjpa.CourseDetails;
import com.sb.orm.ex.step3.hibernatejparepo.CourseDetailsRepo;
import com.sb.orm.ex.utlity.Utlity;

@Service
@Transactional
public class JpqlService {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	CourseDetailsRepo cdRepo;

	public void generateCourseDetailsData() {
		for (int i = 0; i < 100; i++) {
			CourseDetails courseDetails = new CourseDetails("Course " + Utlity.generateRandomText(4),
					Utlity.generateRandomText(6));
			cdRepo.save(courseDetails);
			logger.info("Course Saved, Course-> {}", courseDetails.toString());
		}
	}

	public void findAllCDData() {
		List<CourseDetails> cdList = cdRepo.findAllCD();
		cdList.stream().forEach(x -> {
			logger.info("CourseDetails Namedquery, Course-> {}", x.toString());
		});
	}

	public void findCoursesByNativeQuery() {
		List<CourseDetails> cdList = cdRepo.findCoursesByNativeQuery();
		cdList.stream().forEach(x -> {
			logger.info("CourseDetails native query, Course-> {}", x.toString());
		});
	}

	public void findCourseByNativeQueryParam() {
		List<CourseDetails> cdList = cdRepo.findCoursesByNativeQueryParam();
		cdList.stream().forEach(x -> {
			logger.info("CourseDetails native query with param, Course-> {}", x.toString());
		});
	}

	public void findCourseByNativeQueryParam02() {
		List<CourseDetails> cdList = cdRepo.findCoursesByNativeQueryParam02();
		cdList.stream().forEach(x -> {
			logger.info("CourseDetails native query02 with param, Course-> {}", x.toString());
		});
	}

	public void runJPQLMethods() {
		findAllCDData();
		//findCoursesByNativeQuery();
		findCourseByNativeQueryParam();
		findCourseByNativeQueryParam02();
		//generateCourseDetailsData();
	}
}
