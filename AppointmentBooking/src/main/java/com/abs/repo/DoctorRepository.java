package com.abs.repo;

import java.time.LocalDate;
import java.util.List;


public interface DoctorRepository {
	
	
	boolean isAvailable(String doctorId, LocalDate date);
    boolean book(String doctorId, LocalDate date);
    List<LocalDate> getSchedule(String doctorId);

}
