package com.example.medical.records_service.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.medical.records_service.dto.PatientDTO;

@FeignClient(name = "patient-service", url = "http://localhost:1111")
public interface PatientClient {

    @GetMapping("/api/patients/{id}")
    PatientDTO getPatientById(@PathVariable("id") Long id);
}
