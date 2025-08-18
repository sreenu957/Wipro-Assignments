package com.example.bilings_service.dto;

import java.time.LocalDate;

public class BillingDTO {
	
	
	private Long id;

    private PatientDTO patient;          
    private Long medicalRecordId;    
    private double amount;           
    private LocalDate billingDate;
    private boolean paid;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public PatientDTO getPatient() {
		return patient;
	}
	public void setPatient(PatientDTO patient) {
		this.patient = patient;
	}
	public Long getMedicalRecordId() {
		return medicalRecordId;
	}
	public void setMedicalRecordId(Long medicalRecordId) {
		this.medicalRecordId = medicalRecordId;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public LocalDate getBillingDate() {
		return billingDate;
	}
	public void setBillingDate(LocalDate billingDate) {
		this.billingDate = billingDate;
	}
	public boolean isPaid() {
		return paid;
	}
	public void setPaid(boolean paid) {
		this.paid = paid;
	}
    
    

}
