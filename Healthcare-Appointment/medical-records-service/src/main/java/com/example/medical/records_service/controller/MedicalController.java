package com.example.medical.records_service.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.medical.records_service.dto.MedicalDTO;
import com.example.medical.records_service.model.Medical;
import com.example.medical.records_service.service.MedicalService;

@RestController
@RequestMapping("/medicals")
public class MedicalController {

	@Autowired
    private MedicalService service;

    
    @PostMapping
    public Medical addRecord(@RequestBody Medical record) {
        return service.addRecord(record);
    }
    
    
    @GetMapping
    public List<Medical> getAllRecorde(){
    	return service.getAllRecords();
    }
    
    @GetMapping("/{id}")
    public Optional<Medical> getById(@PathVariable Long id){
    	return service.getMedicalById(id);
    }
    
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
    	service.deleteRecord(id);
    }
	
    @GetMapping("/full")
    public List<MedicalDTO> getAllRecordsFull() {
        return service.getAllRecordsFull();
    }
    
}
