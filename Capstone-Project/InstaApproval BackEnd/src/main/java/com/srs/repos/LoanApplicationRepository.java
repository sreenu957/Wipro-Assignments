package com.srs.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.srs.entity.LoanApplication;
import com.srs.entity.LoanStatus;

@Repository
public interface LoanApplicationRepository extends JpaRepository<LoanApplication, Long> {
	
	List<LoanApplication> findByCustomerCustomerId(Long customerId);
    List<LoanApplication> findByStatus(LoanStatus status);

}
