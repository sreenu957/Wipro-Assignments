package com.learning.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.dto.CourseRequest;
import com.learning.dto.CourseResponse;
import com.learning.dto.UserResponse;
import com.learning.service.CourseService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/courses")
@RequiredArgsConstructor
public class CourseController {
	
	private final CourseService courseService;
	
	 	@PostMapping
	    public ResponseEntity<CourseResponse> createCourse(@RequestBody CourseRequest courseRequest) {
	        CourseResponse response = courseService.createCourse(courseRequest);
	        return new ResponseEntity<>(response, HttpStatus.CREATED);
	    }


	    @GetMapping("/{id}")
	    public ResponseEntity<CourseResponse> getCourseById(@PathVariable Long id) {
	        CourseResponse response = courseService.getCourseById(id);
	        return ResponseEntity.ok(response);
	    }

	    
	    @GetMapping
	    public ResponseEntity<List<CourseResponse>> getAllCourses() {
	        List<CourseResponse> courses = courseService.getAllCourses();
	        return ResponseEntity.ok(courses);
	    }

	    
	    @PutMapping("/{id}")
	    public ResponseEntity<CourseResponse> updateCourse(@PathVariable Long id,
	                                                       @RequestBody CourseRequest courseRequest){
	        CourseResponse updated = courseService.updateCourse(id, courseRequest);
	        return ResponseEntity.ok(updated);
	    }

	    
	    @DeleteMapping("/{id}")
	    public ResponseEntity<String> deleteCourse(@PathVariable Long id){
	        String result = courseService.deleteCourse(id);
	        return ResponseEntity.ok(result);
	    }
	    
	    @PostMapping("/{courseId}/enroll/{userId}")
	    public ResponseEntity<UserResponse> enrollUserInCourse(@PathVariable Long courseId,@PathVariable Long userId){
	        return ResponseEntity.ok(courseService.enrollUserInCourse(courseId, userId));
	    }

}
