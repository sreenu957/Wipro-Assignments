package com.learning.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.learning.client.CourseClient;
import com.learning.client.UserClient;
import com.learning.dto.AssessmentRequest;
import com.learning.dto.AssessmentResponse;
import com.learning.dto.NotificationRequest;
import com.learning.exception.ResourceNotFoundException;
import com.learning.model.Assessment;
import com.learning.repository.AssessmentRepository;
import com.learning.service.AssessmentService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AssessmentServiceImpl implements AssessmentService{
	private final AssessmentRepository repository;
    private final ModelMapper mapper;
    private final CourseClient courseClient;
    private final UserClient userClient;
    private final KafkaTemplate<String, NotificationRequest> kafkaTemplate;
    

    @Override
    public AssessmentResponse createAssessment(Long courseId, AssessmentRequest request) {
        courseClient.getCourseById(courseId);

        Assessment assessment = mapper.map(request, Assessment.class);
        Assessment saved = repository.save(assessment);
        return mapper.map(saved, AssessmentResponse.class);
    }

    @Override
    public List<AssessmentResponse> getAllAssessments() {
        return repository.findAll()
                .stream()
                .map(a -> mapper.map(a, AssessmentResponse.class))
                .collect(Collectors.toList());
    }

    @Override
    public AssessmentResponse getAssessmentById(Long id) {
        Assessment assessment = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Assessment not found"));
        return mapper.map(assessment, AssessmentResponse.class);
    }

    @Override
    public List<AssessmentResponse> getAssessmentsByCourse(Long courseId) {
        courseClient.getCourseById(courseId);
        return repository.findAll()
                .stream()
                .map(a -> mapper.map(a, AssessmentResponse.class))
                .collect(Collectors.toList());
    }

    @Override
    public AssessmentResponse updateAssessment(Long id, AssessmentRequest request) {
        Assessment assessment = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Assessment not found"));

        assessment.setTitle(request.getTitle());
        assessment.setDescription(request.getDescription());
        assessment.setTotalMarks(request.getTotalMarks());
        assessment.setDeadline(request.getDeadline());

        Assessment updated = repository.save(assessment);
        return mapper.map(updated, AssessmentResponse.class);
    }

    @Override
    public String deleteAssessment(Long id) {
        Assessment assessment = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Assessment not found"));
        repository.delete(assessment);
		return "Assessment "+assessment.getTitle()+" Deleted Successfully";
    }
    
    @Override
    public AssessmentResponse assignAssessmentToUser(Long userId, Long assessmentId) {
        Assessment assessment = repository.findById(assessmentId)
                .orElseThrow(() -> new ResourceNotFoundException("Assessment not found with id: " + assessmentId));


        userClient.addAssessmentToUser(userId, assessmentId);


        NotificationRequest notificationRequest = new NotificationRequest();
        notificationRequest.setUserId(userId);
        notificationRequest.setTitle("New Assessment Assigned");
        notificationRequest.setMessage("You have been assigned the assessment: " + assessment.getTitle());

        kafkaTemplate.send("notifications", notificationRequest);

        AssessmentResponse response = mapper.map(assessment, AssessmentResponse.class);
        response.setMessage("Assessment assigned successfully");
        return response;
    }


}
