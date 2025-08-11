package com.fbs.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.fbs.service.TicketService;

import org.springframework.context.ApplicationContext;

public class FlightMain {

	public static void main(String[] args) {
		
		 	ApplicationContext context = new ClassPathXmlApplicationContext("airline.xml");

	        TicketService ticketService = (TicketService) context.getBean("ticketService");

	        System.out.println(ticketService.confirmBooking("FL123", "USER456"));
	        System.out.println(ticketService.confirmBooking("FL999", "USER789"));
        

	}

}
