package com.example.appointment_service.feign;

import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.appointment_service.dto.PatientDTO;

@FeignClient (name="patient-service", url="http://localhost:1111/api/patients")
public interface PatientClient {
	
	@GetMapping("/{id}")
	PatientDTO getPatientById(@PathVariable("id") Long id);

}
