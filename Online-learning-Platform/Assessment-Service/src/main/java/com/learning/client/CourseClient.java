package com.learning.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.learning.dto.CourseDTO;

@FeignClient(name="Online-Learning-Course-Service", url="http://localhost:8082/api/courses")
public interface CourseClient {
	
	@GetMapping("/{courseId}")
    CourseDTO getCourseById(@PathVariable("courseId") Long courseId);

}
