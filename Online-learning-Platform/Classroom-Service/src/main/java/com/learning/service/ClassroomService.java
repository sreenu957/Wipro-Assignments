package com.learning.service;

import java.util.List;

import com.learning.dto.ClassroomDTO;

public interface ClassroomService {

	ClassroomDTO createClassroom(ClassroomDTO classroomDTO);

    ClassroomDTO getClassroomById(Long id);

    List<ClassroomDTO> getAllClassrooms();

    ClassroomDTO updateClassroom(Long id, ClassroomDTO classroomDTO);

    void deleteClassroom(Long id);
}
