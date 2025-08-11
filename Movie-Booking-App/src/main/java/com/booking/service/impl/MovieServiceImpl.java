package com.booking.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.booking.exception.ResourceNotFoundException;
import com.booking.model.Movie;
import com.booking.repository.MovieRepository;
import com.booking.service.MovieService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {
	
	private final MovieRepository movieRepository;
	

	@Override
	public Movie getMovieById(Long id) {
		return movieRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Movie with the "+id+" is not found"));
	}

	@Override
	public List<Movie> getAllMovies() {
		return movieRepository.findAll();
	}

	@Override
	public void deleteMovie(Long id) {
		movieRepository.deleteById(id);
		
	}

	@Override
	public Movie saveMovie(Movie movie) {
		
		return movieRepository.save(movie);
	}

}
