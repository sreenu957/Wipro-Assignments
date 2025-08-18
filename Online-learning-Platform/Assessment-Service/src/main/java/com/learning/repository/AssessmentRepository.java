package com.learning.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learning.model.Assessment;

@Repository
public interface AssessmentRepository extends JpaRepository<Assessment, Long> {

}
