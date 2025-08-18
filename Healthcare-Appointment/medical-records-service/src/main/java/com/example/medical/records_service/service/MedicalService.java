package com.example.medical.records_service.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.medical.records_service.dto.DoctorDTO;
import com.example.medical.records_service.dto.MedicalDTO;
import com.example.medical.records_service.dto.PatientDTO;
import com.example.medical.records_service.feign.DoctorClient;
import com.example.medical.records_service.feign.PatientClient;
import com.example.medical.records_service.model.Medical;
import com.example.medical.records_service.repository.MedicalRepository;

@Service
public class MedicalService {
	

    @Autowired
    private MedicalRepository repository;

    @Autowired
    private PatientClient patientClient;

    @Autowired
    private DoctorClient doctorClient;
    
    
    public Medical addRecord(Medical medical) {
        return repository.save(medical);
    }

    public List<Medical> getAllRecords() {
        return repository.findAll();
    }
    
    public Optional<Medical> getMedicalById(Long Id) {
    	return repository.findById(Id);
    }
   
    
    public void deleteRecord(Long id) {
        repository.deleteById(id);
    }
    
    
    public List<MedicalDTO> getAllRecordsFull() {
        List<Medical> records = repository.findAll();
        List<MedicalDTO> fullDTOs = new ArrayList<>();

        for (Medical record : records) {
            PatientDTO patient = patientClient.getPatientById(record.getPatientId());
            DoctorDTO doctor = doctorClient.getDoctorById(record.getDoctorId());

            MedicalDTO fullDTO = new MedicalDTO();
            fullDTO.setId(record.getId());
            fullDTO.setPatientId(record.getPatientId());
            fullDTO.setDoctorId(record.getDoctorId());
            fullDTO.setVisitDate(record.getVisitDate());
            fullDTO.setDiagnosis(record.getDiagnosis());
            fullDTO.setPrescription(record.getPrescription());
            fullDTO.setTestResults(record.getTestResults());
            fullDTO.setPatient(patient);
            fullDTO.setDoctor(doctor);

            fullDTOs.add(fullDTO);
        }

        return fullDTOs;
    }
    
    
    
    
    
    
}
