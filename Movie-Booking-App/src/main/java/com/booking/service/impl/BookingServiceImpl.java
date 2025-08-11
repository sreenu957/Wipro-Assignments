package com.booking.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.booking.config.AppConfig;
import com.booking.dto.BookingRequest;
import com.booking.exception.ResourceNotFoundException;
import com.booking.model.Booking;
import com.booking.model.Customer;
import com.booking.model.Movie;
import com.booking.model.Theater;
import com.booking.repository.BookingRepository;
import com.booking.repository.CustomerRepository;
import com.booking.repository.MovieRepository;
import com.booking.repository.TheaterRepository;
import com.booking.service.BookingService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService{

	private final BookingRepository bookingRepository;
	private final CustomerRepository customerRepo;
    private final MovieRepository movieRepo;
    private final TheaterRepository theaterRepo;
    private final AppConfig.DateParser dateParser;

	
	@Override
	public List<Booking> getAllBookings() {
		return bookingRepository.findAll();
	}


	@Override
	public Booking getBookingById(Long id) {
		return bookingRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Booking with the "+id+" is not found"));
		
	}
	
	@Override
	public void deleteBooking(Long id) {

		bookingRepository.deleteById(id);
	}

	@Override
	public Booking saveBooking(Booking booking) {

		return bookingRepository.save(booking);
	}
	
	 @Override
	 @Transactional
	 public Booking createBookingFromRequest(BookingRequest request) {
		    Customer customer = new Customer();
		    customer.setName(request.getCustomer().getName());
		    customer.setEmail(request.getCustomer().getEmail());
		    customer = customerRepo.save(customer);

		    Movie movie = new Movie();
		    movie.setTitle(request.getMovie().getTitle());
		    movie.setGenre(request.getMovie().getGenre());
		    movie = movieRepo.save(movie);

		    Theater theater = new Theater();
		    theater.setName(request.getTheater().getName());
		    theater.setLocation(request.getTheater().getLocation());
		    theater = theaterRepo.save(theater);

		    LocalDate bookingDate = dateParser.parse(request.getBookingDate());

		    Booking booking = new Booking();
		    booking.setCustomer(customer);
		    booking.setMovie(movie);
		    booking.setTheater(theater);
		    booking.setBookingDate(bookingDate);
		    booking.setSeats(request.getSeats());

		    return bookingRepository.save(booking);
	    }
	}
