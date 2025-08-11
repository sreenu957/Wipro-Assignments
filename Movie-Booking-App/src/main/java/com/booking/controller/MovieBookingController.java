package com.booking.controller;


import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.booking.dto.BookingRequest;
import com.booking.model.Booking;
import com.booking.model.Customer;
import com.booking.model.Movie;
import com.booking.model.Theater;
import com.booking.service.BookingService;
import com.booking.service.CustomerService;
import com.booking.service.MovieService;
import com.booking.service.TheaterService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class MovieBookingController {


	    private final CustomerService customerService;
	    private final MovieService movieService;
	    private final TheaterService theaterService;
	    private final BookingService bookingService;

	    @GetMapping("/customers")
	    public List<Customer> getAllCustomers() {
	        return customerService.getAllCustomers();
	    }

	    @PostMapping("/customers")
	    public Customer createCustomer(@RequestBody Customer customer) {
	        return customerService.saveCustomer(customer);
	    }
	    
	    @GetMapping("/customer/{id}")
		public Customer getCustomerById(@PathVariable Long id) {
			return customerService.getCustomerById(id);	
		}
	    
	    @PutMapping("/customers/{id}")
		public Customer updateCustomer(@RequestBody Customer customer, @PathVariable Long id) {
			
			Customer existingMovie = customerService.getCustomerById(id);
			existingMovie.setName(customer.getName());
			existingMovie.setEmail(customer.getEmail());
			return customerService.saveCustomer(existingMovie);	
		}
	    
	    @DeleteMapping("/customers/{id}")
		public String deleteCustomer(@PathVariable Long id) {
			customerService.deleteCustomer(id);
			return "Customer with "+ id + " is Successfully deleted";	
		}

	    @GetMapping("/movies")
	    public List<Movie> getAllMovies() {
	        return movieService.getAllMovies();
	    }

	    @GetMapping("/movie/{id}")
		public Movie getMovieById(@PathVariable Long id) {
			return movieService.getMovieById(id);	
		}

		@PostMapping("/movies")
		public Movie createMovie(@RequestBody Movie movie) {
			return movieService.saveMovie(movie);	
		}
		
		@PutMapping("/movies/{id}")
		public Movie updateMovie(@RequestBody Movie movie, @PathVariable Long id) {
			
			Movie existingMovie = movieService.getMovieById(id);
			existingMovie.setTitle(movie.getTitle());
			existingMovie.setGenre(movie.getGenre());
			return movieService.saveMovie(existingMovie);	
		}

		@DeleteMapping("/movies/{id}")
		public String deleteMovie(@PathVariable Long id) {
			movieService.deleteMovie(id);
			return "Movie with "+ id + " is Successfully deleted";	
		}

	    @GetMapping("/theaters")
	    public List<Theater> getAllTheaters() {
	        return theaterService.getAllTheaters();
	    }

	    @GetMapping("/theater/{id}")
		public Theater getTheaterById(@PathVariable Long id) {
			return theaterService.getTheaterById(id);	
		}

		@PostMapping("/theaters")
		public Theater createTheater(@RequestBody Theater theater) {
			return theaterService.saveTheater(theater);	
		}
		
		@PutMapping("/theaters/{id}")
		public Theater updateTheater(@RequestBody Theater theater, @PathVariable Long id) {
			
			Theater existingBooking = theaterService.getTheaterById(id);
			existingBooking.setName(theater.getName());
			existingBooking.setLocation(theater.getLocation());
			
			return theaterService.saveTheater(existingBooking);	
		}
		
		@DeleteMapping("/theaters/{id}")
		public String deleteTheater(@PathVariable Long id) {
			theaterService.deleteTheater(id);
			return "Theater with "+ id + " is Successfully deleted";	
		}

	    @GetMapping("/bookings")
	    public List<Booking> getAllBookings() {
	        return bookingService.getAllBookings();
	    }

	    @PostMapping("/bookings")
	    public Booking createFullBooking(@RequestBody BookingRequest request) {
	        return bookingService.createBookingFromRequest(request);
	    }
	    
	    @DeleteMapping("/bookings/{id}")
		public String deletebooking(@PathVariable Long id) {
			bookingService.deleteBooking(id);
			return "Booking with "+ id + " is Successfully deleted";	
		}
	}

