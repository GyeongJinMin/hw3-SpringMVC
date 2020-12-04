package kr.ac.hansung.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.hansung.dao.CourseDao;
import kr.ac.hansung.model.Course;


@Service
public class CourseService {

	@Autowired
	private CourseDao courseDao;
	
	public List<Course> getCurrent() {
		return courseDao.getCourses();
	}
	
	public List<Course> getCoursesBySemester(int year, int semester) {
		return courseDao.getCoursesBySemester(year, semester);
	}
	
	public List<Course> getCreditsBySemester(int year, int semester) {
		return courseDao.getCreditsBySemester(year, semester);
	}
	
	public void insert(Course course) {
		courseDao.insert(course);
	}
}
