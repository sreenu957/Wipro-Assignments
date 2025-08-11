package com.booking.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	
	 	@ExceptionHandler(ResourceNotFoundException.class)
	    public ResponseEntity<Map<String, Object>> handleBookingNotFound(ResourceNotFoundException ex) {
	        return buildErrorResponse(HttpStatus.NOT_FOUND, ex.getMessage());
	    }


	    @ExceptionHandler(Exception.class)
	    public ResponseEntity<Map<String, Object>> handleGenericException(Exception ex) {
	        return buildErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
	    }
	    
	    private ResponseEntity<Map<String, Object>> buildErrorResponse(HttpStatus status, String message) {
	        Map<String, Object> response = new HashMap<>();
	        response.put("timestamp", LocalDateTime.now());
	        response.put("status", status.value());
	        response.put("error", status.getReasonPhrase());
	        response.put("message", message);
	        return new ResponseEntity<>(response, status);
	    }

}
