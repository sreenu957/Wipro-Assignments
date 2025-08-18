package com.example.bilings_service.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.bilings_service.dto.PatientDTO;

@FeignClient(name = "patient-service", url = "http://localhost:8081")
public interface PatientClient {

    @GetMapping("/patients/{id}")
    PatientDTO getPatientById(@PathVariable("id") Long id);

}
