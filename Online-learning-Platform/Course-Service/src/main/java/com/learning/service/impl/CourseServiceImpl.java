package com.learning.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.learning.client.UserClient;
import com.learning.dto.CourseRequest;
import com.learning.dto.CourseResponse;
import com.learning.dto.UserResponse;
import com.learning.exception.ResourceNotFoundException;
import com.learning.model.Course;
import com.learning.repository.CourseRepository;
import com.learning.service.CourseService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService{
	
	private final CourseRepository courseRepository;
	private final ModelMapper modelMapper;
	private final UserClient userClient;
	
	@Override
	public CourseResponse createCourse(CourseRequest courseRequest) {
		Course course = modelMapper.map(courseRequest, Course.class);
		Course saved = courseRepository.save(course);
		return modelMapper.map(saved, CourseResponse.class);
	}

	@Override
	public CourseResponse getCourseById(Long id) {
		Course course = courseRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Course with "+id+" is not found"));
		return modelMapper.map(course, CourseResponse.class);
	}

	@Override
	public List<CourseResponse> getAllCourses() {
	
		return courseRepository.findAll()
				.stream()
				.map(course -> modelMapper.map(course, CourseResponse.class))
				.toList();
	}

	@Override
	public CourseResponse updateCourse(Long id, CourseRequest courseRequest) {
		
		Course course = courseRepository.findById(id)
								.orElseThrow(()-> new ResourceNotFoundException("Course with the "+id+" is not found"));
		course.setTitle(courseRequest.getTitle());
		course.setDescription(course.getDescription());
		course.setDuration(courseRequest.getDuration());
		
		Course updated = courseRepository.save(course);
		return modelMapper.map(updated, CourseResponse.class);
	}

	@Override
	public String deleteCourse(Long id) {
		
		if(!courseRepository.existsById(id)) {
			return "course with the "+id+" is not found";
		}
		courseRepository.deleteById(id);

		return "Course Deleted Successfully";
	}
	
	@Override
	public UserResponse enrollUserInCourse(Long courseId, Long userId) {
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new ResourceNotFoundException("Course not found with id: " + courseId));

        CourseResponse courseResponse = new CourseResponse(
                course.getId(),
                course.getTitle(),
                course.getDescription(),
                course.getDuration()
        );

        return userClient.addCourseToUser(userId, courseResponse);
    }

}
