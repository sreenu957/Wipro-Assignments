package com.example.appointment_service.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.example.appointment_service.dto.AppointmentDTO;
import com.example.appointment_service.dto.DoctorDTO;
import com.example.appointment_service.dto.PatientDTO;
import com.example.appointment_service.feign.DoctorClient;
import com.example.appointment_service.feign.PatientClient;
import com.example.appointment_service.model.Appointment;
import com.example.appointment_service.repository.AppointmentRepository;

@Service
public class AppointmentService {

    @Autowired
    AppointmentRepository appointmentRepository;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    private PatientClient patientClient;

    @Autowired
    private DoctorClient doctorClient;

    private static final String TOPIC = "appointment-confirmed";

    public AppointmentDTO bookAppointment(Appointment appointment) {
        // Save appointment
        appointment.setStatus("BOOKED");
        Appointment saved = appointmentRepository.save(appointment);

        // Send Kafka message
        kafkaTemplate.send(TOPIC, "Appointment Confirmed with ID: " + saved.getId());

        // Fetch patient
        PatientDTO patient;
        try {
            patient = patientClient.getPatientById(saved.getPatientId());
        } catch (Exception e) {
            throw new RuntimeException("Patient with id " + saved.getPatientId() + " not found.");
        }

        // Fetch doctor
        DoctorDTO doctor;
        try {
            doctor = doctorClient.getDoctorById(saved.getDoctorId());
        } catch (Exception e) {
            throw new RuntimeException("Doctor with id " + saved.getDoctorId() + " not found.");
        }

        // Build response
        AppointmentDTO response = new AppointmentDTO();
        response.setAppointmentId(saved.getId());
        response.setAppointmentTime(saved.getAppointmentTime());
        response.setStatus(saved.getStatus());
        response.setPatient(patient);
        response.setDoctor(doctor);

        return response;
    }

    public AppointmentDTO getAppointment(Long id) {
        Optional<Appointment> optional = appointmentRepository.findById(id);
        if (optional.isEmpty()) {
            return null;
        }

        Appointment appointment = optional.get();

        // Fetch patient
        PatientDTO patient;
        try {
            patient = patientClient.getPatientById(appointment.getPatientId());
        } catch (Exception e) {
            throw new RuntimeException("Patient with id " + appointment.getPatientId() + " not found.");
        }

        // Fetch doctor
        DoctorDTO doctor;
        try {
            doctor = doctorClient.getDoctorById(appointment.getDoctorId());
        } catch (Exception e) {
            throw new RuntimeException("Doctor with id " + appointment.getDoctorId() + " not found.");
        }

        // Build response
        AppointmentDTO response = new AppointmentDTO();
        response.setAppointmentId(appointment.getId());
        response.setAppointmentTime(appointment.getAppointmentTime());
        response.setStatus(appointment.getStatus());
        response.setPatient(patient);
        response.setDoctor(doctor);

        return response;
    }
}
