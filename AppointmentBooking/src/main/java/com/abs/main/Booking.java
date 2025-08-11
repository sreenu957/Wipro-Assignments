package com.abs.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.abs.service.AppointmentService;

import java.time.LocalDate;


public class Booking {

	public static void main(String[] args) {
		
		try (ClassPathXmlApplicationContext ctx =
                new ClassPathXmlApplicationContext("beans.xml")) {

       AppointmentService appointmentService = ctx.getBean("appointmentService", AppointmentService.class);

       String result1 = appointmentService.book("DOC101", LocalDate.of(2025, 4, 10));
       System.out.println("Input: appointmentService.book(\"DOC101\", \"2025-04-10\")");
       System.out.println("Output: " + result1);


       String result2 = appointmentService.book("DOC101", LocalDate.of(2025, 4, 1));
       System.out.println("book DOC101 on 2025-04-01 => " + result2);
		
		}
	}
}
