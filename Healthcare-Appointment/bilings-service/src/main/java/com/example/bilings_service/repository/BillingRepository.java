package com.example.bilings_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.bilings_service.model.Billing;
@Repository
public interface BillingRepository extends JpaRepository<Billing, Long>{

	
	
	
	
	
}
