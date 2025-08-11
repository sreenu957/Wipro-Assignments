package com.booking.service;

import java.util.List;

import com.booking.model.Movie;

public interface MovieService {
	
	List<Movie> getAllMovies();
	
	Movie getMovieById(Long id);
	
	Movie saveMovie(Movie movie);
		
	void deleteMovie(Long id);

}
