package com.learning.dto;

import java.util.List;

import lombok.Data;

@Data
public class UserResponse {
	
	private Long id;
    private String name;
    private String email;
    private List<CourseResponse> courses;

}
