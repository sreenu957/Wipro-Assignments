package com.booking.service;

import java.util.List;

import com.booking.model.Theater;

public interface TheaterService {
	
	
	List<Theater> getAllTheaters();
	
	Theater getTheaterById(Long id);
	
	Theater saveTheater(Theater theater);
		
	void deleteTheater(Long id);
	
}
