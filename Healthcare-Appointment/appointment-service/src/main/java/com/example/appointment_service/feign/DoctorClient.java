package com.example.appointment_service.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.appointment_service.dto.DoctorDTO;
@FeignClient(name="doctor-service", url="http://localhost:2222/api/doctors")
public interface DoctorClient {

	@GetMapping("/{id}")
	  DoctorDTO getDoctorById(@PathVariable("id") Long id);
	}
