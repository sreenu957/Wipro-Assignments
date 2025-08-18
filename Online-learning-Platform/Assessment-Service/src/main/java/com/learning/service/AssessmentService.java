package com.learning.service;

import java.util.List;

import com.learning.dto.AssessmentRequest;
import com.learning.dto.AssessmentResponse;

public interface AssessmentService {

	AssessmentResponse createAssessment(Long courseId, AssessmentRequest request);

    List<AssessmentResponse> getAllAssessments();

    AssessmentResponse getAssessmentById(Long id);

    List<AssessmentResponse> getAssessmentsByCourse(Long courseId);

    AssessmentResponse updateAssessment(Long id, AssessmentRequest request);

    String deleteAssessment(Long id);
    
    AssessmentResponse assignAssessmentToUser(Long userId, Long assessmentId);
}
