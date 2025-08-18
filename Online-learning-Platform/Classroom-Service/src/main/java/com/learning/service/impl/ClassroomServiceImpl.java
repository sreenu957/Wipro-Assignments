package com.learning.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.learning.dto.ClassroomDTO;
import com.learning.model.Classroom;
import com.learning.repository.ClassroomRepository;
import com.learning.service.ClassroomService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClassroomServiceImpl implements ClassroomService{

	

	    private final ClassroomRepository classroomRepository;

	    private final ModelMapper modelMapper;

	    @Override
	    public ClassroomDTO createClassroom(ClassroomDTO classroomDTO) {
	        Classroom classroom = modelMapper.map(classroomDTO, Classroom.class);
	        Classroom saved = classroomRepository.save(classroom);
	        return modelMapper.map(saved, ClassroomDTO.class);
	    }

	    @Override
	    public ClassroomDTO getClassroomById(Long id) {
	        Classroom classroom = classroomRepository.findById(id)
	                .orElseThrow(() -> new RuntimeException("Classroom not found"));
	        return modelMapper.map(classroom, ClassroomDTO.class);
	    }

	    @Override
	    public List<ClassroomDTO> getAllClassrooms() {
	        return classroomRepository.findAll()
	                .stream()
	                .map(c -> modelMapper.map(c, ClassroomDTO.class))
	                .collect(Collectors.toList());
	    }

	    @Override
	    public ClassroomDTO updateClassroom(Long id, ClassroomDTO classroomDTO) {
	        Classroom classroom = classroomRepository.findById(id)
	                .orElseThrow(() -> new RuntimeException("Classroom not found"));

	        modelMapper.map(classroomDTO, classroom);

	        Classroom updated = classroomRepository.save(classroom);
	        return modelMapper.map(updated, ClassroomDTO.class);
	    }

	    @Override
	    public void deleteClassroom(Long id) {
	        if (!classroomRepository.existsById(id)) {
	            throw new RuntimeException("Classroom not found");
	        }
	        classroomRepository.deleteById(id);
	    }
}
