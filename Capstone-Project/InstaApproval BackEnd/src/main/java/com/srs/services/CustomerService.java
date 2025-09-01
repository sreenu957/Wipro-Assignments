package com.srs.services;

import com.srs.entity.Customer;

public interface CustomerService {

	Customer register(Customer customer);
    Customer findByEmail(String email);
    Customer findById(Long id);
}
