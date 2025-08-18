package com.example.appointment_service.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.appointment_service.model.Appointment;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long>{
	List<Appointment> findByDoctorIdAndAppointmentTime(Long doctorId, LocalDateTime appointmentTime);
	}