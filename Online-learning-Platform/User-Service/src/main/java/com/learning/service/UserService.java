package com.learning.service;

import java.util.List;

import com.learning.dto.CourseResponse;
import com.learning.dto.UserRequest;
import com.learning.dto.UserResponse;

public interface UserService {

	UserResponse createUser(UserRequest userRequest);

    UserResponse getUserById(Long id);

    List<UserResponse> getAllUsers();

    UserResponse updateUser(Long id, UserRequest userRequest);

    void deleteUser(Long id);
    
    UserResponse addCourseToUser(Long userId, CourseResponse courseResponse);
    UserResponse addAssessmentToUser(Long userId, Long assessmentId);
//    List<Long> getUsersByCourseId(Long courseId);
 //   List<Long> getCoursesByUserId(Long userId);
//    List<Long> getUserAssessments(Long userId);
//    List<Long> getUserClassroomSessions(Long userId);
}
