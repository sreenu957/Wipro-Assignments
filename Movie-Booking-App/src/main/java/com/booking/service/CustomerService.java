package com.booking.service;

import java.util.List;

import com.booking.model.Customer;

public interface CustomerService {

	List<Customer> getAllCustomers();
	
	Customer getCustomerById(Long id);
	
	Customer saveCustomer(Customer customer);
		
	void deleteCustomer(Long id);
}
