package com.booking.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="movies")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Movie {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
    private String title;
    private String genre;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "movie_theater",
    	joinColumns = @JoinColumn(name = "movie_id"),
    	inverseJoinColumns = @JoinColumn(name = "theater_id")) 
    private List<Theater> theaters;

}
