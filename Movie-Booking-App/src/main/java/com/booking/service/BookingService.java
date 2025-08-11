package com.booking.service;

import java.util.List;

import com.booking.dto.BookingRequest;
import com.booking.model.Booking;

public interface BookingService {
	
	List<Booking> getAllBookings();
	Booking getBookingById(Long id);
	Booking saveBooking(Booking booking);	
	void deleteBooking(Long id);
	Booking createBookingFromRequest(BookingRequest request);

}
