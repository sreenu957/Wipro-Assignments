package com.example.medical.records_service.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.medical.records_service.dto.DoctorDTO;

@FeignClient(name = "doctor-service", url = "http://localhost:2222")
public interface DoctorClient {

    @GetMapping("/api/doctors/{id}")
    DoctorDTO getDoctorById(@PathVariable("id") Long id);
}
