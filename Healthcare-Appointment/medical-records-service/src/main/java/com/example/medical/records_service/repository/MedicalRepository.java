package com.example.medical.records_service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.medical.records_service.model.Medical;
@Repository
public interface MedicalRepository extends JpaRepository<Medical, Long> {
}
