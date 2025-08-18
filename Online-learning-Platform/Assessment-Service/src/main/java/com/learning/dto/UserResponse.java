package com.learning.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {
	
	private Long id;
    private String name;
    private String email;
    private List<CourseDTO> courses;
    private List<Long> assessments;

}
