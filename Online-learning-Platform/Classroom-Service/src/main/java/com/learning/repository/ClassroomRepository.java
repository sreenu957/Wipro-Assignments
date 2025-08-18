package com.learning.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learning.model.Classroom;

@Repository
public interface ClassroomRepository extends JpaRepository<Classroom, Long>{

}
