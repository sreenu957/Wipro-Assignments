package com.example.medical.records_service.dto;

public class PatientDTO {
	
	  private String name;
	    private int age;
	    private String gender;
	    private String email;
	    private String phone;

	    // Demographics
	    private String address;
	    private String city;
	    private String state;
	    private String country;
	    private String dateOfBirth;  

	    // Insurance details
	    private String insuranceProvider;
	    private String insuranceNumber;
	    private String insuranceValidity;
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
		public String getGender() {
			return gender;
		}
		public void setGender(String gender) {
			this.gender = gender;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getPhone() {
			return phone;
		}
		public void setPhone(String phone) {
			this.phone = phone;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public String getCity() {
			return city;
		}
		public void setCity(String city) {
			this.city = city;
		}
		public String getState() {
			return state;
		}
		public void setState(String state) {
			this.state = state;
		}
		public String getCountry() {
			return country;
		}
		public void setCountry(String country) {
			this.country = country;
		}
		public String getDateOfBirth() {
			return dateOfBirth;
		}
		public void setDateOfBirth(String dateOfBirth) {
			this.dateOfBirth = dateOfBirth;
		}
		public String getInsuranceProvider() {
			return insuranceProvider;
		}
		public void setInsuranceProvider(String insuranceProvider) {
			this.insuranceProvider = insuranceProvider;
		}
		public String getInsuranceNumber() {
			return insuranceNumber;
		}
		public void setInsuranceNumber(String insuranceNumber) {
			this.insuranceNumber = insuranceNumber;
		}
		public String getInsuranceValidity() {
			return insuranceValidity;
		}
		public void setInsuranceValidity(String insuranceValidity) {
			this.insuranceValidity = insuranceValidity;
		}
	    
	    

}
