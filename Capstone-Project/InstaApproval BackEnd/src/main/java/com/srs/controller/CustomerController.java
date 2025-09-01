package com.srs.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.srs.entity.Customer;
import com.srs.entity.LoanApplication;
import com.srs.services.CustomerService;
import com.srs.services.LoanService;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {
	
	@Autowired
    private CustomerService customerService;

    @Autowired
    private LoanService loanService;
    
 // Apply for loan
    
    @PostMapping("/{customerId}/apply")
    public ResponseEntity<?> applyLoan(@PathVariable Long customerId, @RequestBody LoanApplication loanApplication) {
        Customer c = customerService.findById(customerId);
        if (c == null) return ResponseEntity.badRequest().body("Customer not found");
        loanApplication.setCustomer(c);
        LoanApplication saved = loanService.applyLoan(loanApplication);
        return ResponseEntity.ok(saved);
    }
    
    // View all loans of a customer
    @GetMapping("/{customerId}/loans")
    public ResponseEntity<?> myLoans(@PathVariable Long customerId) {
        List<LoanApplication> list = loanService.getLoansByCustomer(customerId);
        return ResponseEntity.ok(list);
    }
    

 // Update loan (only if PENDING)
    @PutMapping("/loan/{loanId}")
    public ResponseEntity<?> updateLoan(@PathVariable Long loanId, @RequestBody LoanApplication update) {
        LoanApplication updated = loanService.updateLoan(loanId, update);
        return ResponseEntity.ok(updated);
    }
    
    
    // Cancel loan (only if PENDING)
    @DeleteMapping("/loan/{loanId}")
    public ResponseEntity<?> cancelLoan(@PathVariable Long loanId) {
        loanService.cancelLoan(loanId);
        return ResponseEntity.ok(Map.of("status", "cancelled"));
    }
    
    
 // Get loan status
    @GetMapping("/loan/{loanId}/status")
    public ResponseEntity<?> getStatus(@PathVariable Long loanId) {
        LoanApplication loan = loanService.getLoanById(loanId);
        if (loan == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(Map.of("status", loan.getStatus(), "remarks", loan.getRemarks()));
    }
    

}
