package com.abs.service;

import java.time.LocalDate;

import com.abs.repo.DoctorRepository;


public class AppointmentService {
	
	private DoctorRepository doctorRepository;

    public void setDoctorRepository(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public String book(String doctorId, LocalDate date) {
        if (doctorRepository == null) {
            throw new IllegalStateException("DoctorRepository not configured");
        }
        if (doctorRepository.isAvailable(doctorId, date)) {
            boolean booked = doctorRepository.book(doctorId, date);
            return booked ? "Appointment confirmed" : "Doctor not available";
        } else {
            return "Doctor not available";
        }
    }
		
}

