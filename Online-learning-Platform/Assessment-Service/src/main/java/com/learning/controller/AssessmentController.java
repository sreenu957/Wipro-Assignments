package com.learning.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.dto.AssessmentRequest;
import com.learning.dto.AssessmentResponse;
import com.learning.service.AssessmentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/assessments")
@RequiredArgsConstructor
public class AssessmentController {

    private final AssessmentService service;

    @PostMapping("/course/{courseId}")
    public ResponseEntity<AssessmentResponse> create(@PathVariable Long courseId,
                                                     @RequestBody AssessmentRequest request) {
        return ResponseEntity.ok(service.createAssessment(courseId, request));
    }

    @GetMapping
    public ResponseEntity<List<AssessmentResponse>> getAll() {
        return ResponseEntity.ok(service.getAllAssessments());
    }


    @GetMapping("/{id}")
    public ResponseEntity<AssessmentResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getAssessmentById(id));
    }


    @GetMapping("/course/{courseId}")
    public ResponseEntity<List<AssessmentResponse>> getByCourse(@PathVariable Long courseId) {
        return ResponseEntity.ok(service.getAssessmentsByCourse(courseId));
    }

  
    @PutMapping("/{id}")
    public ResponseEntity<AssessmentResponse> update(@PathVariable Long id,
                                                     @RequestBody AssessmentRequest request) {
        return ResponseEntity.ok(service.updateAssessment(id, request));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        String message = service.deleteAssessment(id);
        return ResponseEntity.ok(message);
    }
    
    @PostMapping("/{assessmentId}/assign/{userId}")
    public ResponseEntity<AssessmentResponse> assignAssessmentToUser(
            @PathVariable Long userId,
            @PathVariable Long assessmentId) {
        
        AssessmentResponse response = service.assignAssessmentToUser(userId, assessmentId);
        return ResponseEntity.ok(response);
    }
}

