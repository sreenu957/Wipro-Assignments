package com.example.appointment_service.dto;

import java.time.LocalDateTime;

public class AppointmentDTO {

	 private Long appointmentId;
	    private LocalDateTime appointmentTime;
	    private String status;

	    private PatientDTO patient;
	    private DoctorDTO doctor;
		public Long getAppointmentId() {
			return appointmentId;
		}
		public void setAppointmentId(Long appointmentId) {
			this.appointmentId = appointmentId;
		}
		public LocalDateTime getAppointmentTime() {
			return appointmentTime;
		}
		public void setAppointmentTime(LocalDateTime appointmentTime) {
			this.appointmentTime = appointmentTime;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		public PatientDTO getPatient() {
			return patient;
		}
		public void setPatient(PatientDTO patient) {
			this.patient = patient;
		}
		public DoctorDTO getDoctor() {
			return doctor;
		}
		public void setDoctor(DoctorDTO doctor) {
			this.doctor = doctor;
		}
	    
	    
	    
	
}
