package com.learning.dto;

import java.time.LocalDateTime;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CourseResponse {
	private Long id;
    private String title;
    private String description;
    private Integer duration;
    private LocalDateTime createdAt;
    
	public CourseResponse(Long id, String title, String description, Integer duration) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.duration = duration;
	}
    
   
    

}
