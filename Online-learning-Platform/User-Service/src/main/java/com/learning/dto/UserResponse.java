package com.learning.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.learning.constants.Role;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserResponse {
	
	private Long id;
    private String name;
    private String email;
    private Role role;
    private LocalDateTime createdAt;
    private List<CourseResponse> courses;
    private List<Long> assessments;
    
	public UserResponse() {
		
	}
    
    
//    private List<Long> classroomSessionIds;
//    private List<Long> assessmentIds;

}
