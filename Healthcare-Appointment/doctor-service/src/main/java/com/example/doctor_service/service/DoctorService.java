package com.example.doctor_service.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.doctor_service.model.Doctor;
import com.example.doctor_service.repository.DoctorRepository;

@Service
public class DoctorService {

	@Autowired
	DoctorRepository doctorRepository;
	
	public List< Doctor> getAllDoctors(){
		return doctorRepository.findAll();
	}
	
	public Doctor saveDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }
	
	public Optional<Doctor> getDoctorById(Long id) {
        return doctorRepository.findById(id);
    }

    public void deleteDoctor(Long id) {
        doctorRepository.deleteById(id);
    }
	
}
