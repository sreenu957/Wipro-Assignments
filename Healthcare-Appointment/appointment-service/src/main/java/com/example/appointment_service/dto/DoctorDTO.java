package com.example.appointment_service.dto;

public class DoctorDTO {

	 private Long id;
	    private String name;
	    private String specialization;
	    private String availableSchedule;
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getSpecialization() {
			return specialization;
		}
		public void setSpecialization(String specialization) {
			this.specialization = specialization;
		}
		public String getAvailableSchedule() {
			return availableSchedule;
		}
		public void setAvailableSchedule(String availableSchedule) {
			this.availableSchedule = availableSchedule;
		}
	    
	    

	
}
