package com.booking.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.booking.exception.ResourceNotFoundException;
import com.booking.model.Theater;
import com.booking.repository.TheaterRepository;
import com.booking.service.TheaterService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TheaterServiceImpl implements TheaterService{

	private final TheaterRepository theaterRepository;

	@Override
	public List<Theater> getAllTheaters() {
		
		return theaterRepository.findAll();
	}

	@Override
	public Theater getTheaterById(Long id) {
		return theaterRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Theater with the "+id+" is not found"));
	}

	@Override
	public void deleteTheater(Long id) {
		theaterRepository.deleteById(id);
		
	}

	@Override
	public Theater saveTheater(Theater theater) {
		
		return theaterRepository.save(theater);
	}


	

}
