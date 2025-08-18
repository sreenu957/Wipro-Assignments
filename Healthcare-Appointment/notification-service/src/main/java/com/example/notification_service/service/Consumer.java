package com.example.notification_service.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
@Service
public class Consumer {
	 @KafkaListener(topics = "appointment-confirmed", groupId = "notification-group")
	    public void listenAppointment(String message) {
	        System.out.println("Received message from Appointment Service: " + message);
	        System.out.println("Simulating sending SMS/Email to patient: " + message);
	    }

}
