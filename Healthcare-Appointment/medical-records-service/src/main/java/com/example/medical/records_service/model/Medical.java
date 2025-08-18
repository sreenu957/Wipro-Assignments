package com.example.medical.records_service.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Medical {

	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private Long patientId;       
	    private Long doctorId;        
	    private LocalDate visitDate;
	    private String diagnosis;
	    private String prescription;
	    private String testResults;
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public Long getPatientId() {
			return patientId;
		}
		public void setPatientId(Long patientId) {
			this.patientId = patientId;
		}
		public Long getDoctorId() {
			return doctorId;
		}
		public void setDoctorId(Long doctorId) {
			this.doctorId = doctorId;
		}
		public LocalDate getVisitDate() {
			return visitDate;
		}
		public void setVisitDate(LocalDate visitDate) {
			this.visitDate = visitDate;
		}
		public String getDiagnosis() {
			return diagnosis;
		}
		public void setDiagnosis(String diagnosis) {
			this.diagnosis = diagnosis;
		}
		public String getPrescription() {
			return prescription;
		}
		public void setPrescription(String prescription) {
			this.prescription = prescription;
		}
		public String getTestResults() {
			return testResults;
		}
		public void setTestResults(String testResults) {
			this.testResults = testResults;
		}
	    
	    
	    
	
}
