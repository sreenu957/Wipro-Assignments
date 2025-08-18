package com.example.doctor_service.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Doctor {
	
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String docname;
	    private String docemail;
	    private String docphone;

	   
	    private String specialization;

	    // Simple schedule (e.g., "Mon-Fri 10:00-16:00")
	    private String schedule;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getDocname() {
			return docname;
		}

		public void setDocname(String docname) {
			this.docname = docname;
		}

		public String getDocemail() {
			return docemail;
		}

		public void setDocemail(String docemail) {
			this.docemail = docemail;
		}

		public String getDocphone() {
			return docphone;
		}

		public void setDocphone(String docphone) {
			this.docphone = docphone;
		}

		public String getSpecialization() {
			return specialization;
		}

		public void setSpecialization(String specialization) {
			this.specialization = specialization;
		}

		public String getSchedule() {
			return schedule;
		}

		public void setSchedule(String schedule) {
			this.schedule = schedule;
		}

		public Doctor(Long id, String docname, String docemail, String docphone, String specialization,
				String schedule) {
			super();
			this.id = id;
			this.docname = docname;
			this.docemail = docemail;
			this.docphone = docphone;
			this.specialization = specialization;
			this.schedule = schedule;
		}
	    
		public Doctor() {}

}
