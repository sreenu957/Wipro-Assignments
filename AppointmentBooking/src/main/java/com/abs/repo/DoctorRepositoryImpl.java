package com.abs.repo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DoctorRepositoryImpl implements DoctorRepository {

	    private final Map<String, List<LocalDate>> bookedDates = new HashMap<>();

	    public DoctorRepositoryImpl() {
	        bookedDates.put("DOC101", new ArrayList<>(Arrays.asList(
	                LocalDate.of(2025, 4, 1),
	                LocalDate.of(2025, 4, 2)
	        )));
	        bookedDates.put("DOC102", new ArrayList<>());
	    }

	    @Override
	    public boolean isAvailable(String doctorId, LocalDate date) {
	        List<LocalDate> dates = bookedDates.get(doctorId);

	        if (dates == null) {
	            return true;
	        }
	        return !dates.contains(date);
	    }

	    @Override
	    public boolean book(String doctorId, LocalDate date) {

	        List<LocalDate> dates = bookedDates.get(doctorId);
	        if (dates == null) {
	            dates = new ArrayList<>();
	            bookedDates.put(doctorId, dates);
	        }
	        if (dates.contains(date)) {
	            return false;
	        }
	        
	        dates.add(date);
	        return true;
	    }

	    @Override
	    public List<LocalDate> getSchedule(String doctorId) {
	        return bookedDates.getOrDefault(doctorId, new ArrayList<>());
	    }
	}
