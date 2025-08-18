package com.learning.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.learning.dto.UserResponse;

@FeignClient(name="Online-Learning-User-Service", url="http://localhost:8081/api/users")
public interface UserClient {
	
	@PostMapping("/{userId}/assessments/{assessmentId}")
	public UserResponse addAssessmentToUser(@PathVariable Long userId, @PathVariable Long assessmentId);

}
