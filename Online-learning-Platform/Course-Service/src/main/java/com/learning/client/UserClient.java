package com.learning.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.learning.dto.CourseResponse;
import com.learning.dto.UserResponse;

@FeignClient(name="Online-Learning-User-Service", url = "http://localhost:8081")
public interface UserClient {
	
    @GetMapping("/api/users/{userId}")
	UserResponse getUserById(@PathVariable Long userId);
    
    @PostMapping("/api/users/{userId}/courses")
    UserResponse addCourseToUser(@PathVariable Long userId, @RequestBody CourseResponse courseResponse);

}
