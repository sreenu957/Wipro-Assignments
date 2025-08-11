package com.fbs.service;

import java.util.HashMap;
import java.util.Map;

public class FlightServiceImpl implements FlightService{
	
	private Map<String, Integer> seats = new HashMap<>();

    public void setSeats(Map<String, Integer> seats) {
        this.seats = seats;
    }

    @Override
    public boolean hasAvailableSeats(String flightId) {
        return seats.getOrDefault(flightId, 0) > 0;
    }

    @Override
    public boolean bookSeat(String flightId) {
        int available = seats.getOrDefault(flightId, 0);
        if (available > 0) {
            seats.put(flightId, available - 1);
            return true;
        }
        return false;
    }

}
