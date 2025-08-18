package com.example.appointment_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.appointment_service.dto.AppointmentDTO;
import com.example.appointment_service.model.Appointment;
import com.example.appointment_service.service.AppointmentService;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {

	 @Autowired
	    private AppointmentService appointmentService;

	    @PostMapping
	    public AppointmentDTO bookAppointment(@RequestBody Appointment appointment) {
	        return appointmentService.bookAppointment(appointment);
	    }

	    @GetMapping("/{id}")
	    public AppointmentDTO getAppointment(@PathVariable Long id) {
	        return appointmentService.getAppointment(id);
	    }
}
