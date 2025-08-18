package com.learning.service;

import java.util.List;

import com.learning.dto.CourseRequest;
import com.learning.dto.CourseResponse;
import com.learning.dto.UserResponse;

public interface CourseService {
	
	CourseResponse createCourse(CourseRequest courseRequest);
	
	CourseResponse getCourseById(Long id);
	
	List<CourseResponse>getAllCourses();
	
	CourseResponse updateCourse(Long id, CourseRequest courseRequest);
	
	String deleteCourse(Long id);
	
	UserResponse enrollUserInCourse(Long courseId, Long userId);

}
