package com.srs.servicesImpl;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.srs.entity.Customer;
import com.srs.repos.CustomerRepository;
import com.srs.services.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

	@Override
	public Customer register(Customer customer) {
		customer.setPassword(passwordEncoder.encode(customer.getPassword()));
        return customerRepository.save(customer);
	}

	@Override
	public Customer findByEmail(String email) {
		return customerRepository.findByEmail(email).orElse(null);
	}

	@Override
	public Customer findById(Long id) {
		return customerRepository.findById(id).orElse(null);
	}

}
