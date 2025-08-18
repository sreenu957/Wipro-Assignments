package com.learning.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AssessmentRequest {
    private String title;
    private String description;
    private Integer totalMarks;
    private LocalDateTime deadline;
}