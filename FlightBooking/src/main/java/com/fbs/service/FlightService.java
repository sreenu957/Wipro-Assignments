package com.fbs.service;

public interface FlightService {
	
	boolean hasAvailableSeats(String flightId);
    boolean bookSeat(String flightId);

}
