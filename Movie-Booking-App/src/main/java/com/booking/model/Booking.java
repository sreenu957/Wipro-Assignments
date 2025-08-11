package com.booking.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="bookings")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Booking {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
    private LocalDate bookingDate;
    private int seats;
    
    @ManyToOne
    @JoinColumn(name ="customer_id")
    private Customer customer;
    
    @ManyToOne
    @JoinColumn(name ="movie_id")
    private Movie movie;
    
    @ManyToOne
    @JoinColumn(name ="theater_id")
    private Theater theater;

}
