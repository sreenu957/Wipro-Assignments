package com.booking.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.booking.exception.ResourceNotFoundException;
import com.booking.model.Customer;
import com.booking.repository.CustomerRepository;
import com.booking.service.CustomerService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
	
	private final CustomerRepository customerRepository;


	@Override
	public Customer getCustomerById(Long id) {
		return customerRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Customer with the "+id+" is not found"));
	}

	@Override
	public List<Customer> getAllCustomers() {
		return customerRepository.findAll();
	}


	@Override
	public void deleteCustomer(Long id) {
		customerRepository.deleteById(id);
		
	}

	@Override
	public Customer saveCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

}
