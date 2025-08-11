package com.booking.dto;


import lombok.Data;

@Data
public class BookingRequest {
	
	private Customer customer;
	private Movie movie;
	private Theater theater;
    private int seats;
   
    private String bookingDate;

}
