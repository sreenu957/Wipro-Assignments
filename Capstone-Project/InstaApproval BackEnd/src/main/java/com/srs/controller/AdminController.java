package com.srs.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.srs.entity.LoanApplication;
import com.srs.entity.LoanStatus;
import com.srs.repos.LoanApplicationRepository;
import com.srs.services.AdminService;
@RestController
@RequestMapping("/api/v1/admin")
public class AdminController {

	 @Autowired
	    private LoanApplicationRepository loanRepository;

	    @Autowired
	    private AdminService adminService;

	    // View all pending loans
	    @GetMapping("/loans/pending")
	    public ResponseEntity<?> pendingLoans() {
	        List<LoanApplication> pending = loanRepository.findByStatus(LoanStatus.PENDING);
	        return ResponseEntity.ok(pending);
	    }

	    // Approve a loan
	    @PutMapping("/loans/approve/{loanId}/by/{adminId}")
	    public ResponseEntity<?> approve(@PathVariable Long loanId,
	                                     @PathVariable Long adminId,
	                                     @RequestBody(required = false) String remarks) {
	        LoanApplication loan = adminService.approve(loanId, adminId, remarks == null ? "Approved" : remarks);
	        return ResponseEntity.ok(Map.of("status", loan.getStatus(), "remarks", loan.getRemarks()));
	    }

	    // Reject a loan
	    @PutMapping("/loans/reject/{loanId}/by/{adminId}")
	    public ResponseEntity<?> reject(@PathVariable Long loanId,
	                                    @PathVariable Long adminId,
	                                    @RequestBody(required = false) String remarks) {
	        LoanApplication loan = adminService.reject(loanId, adminId, remarks == null ? "Rejected" : remarks);
	        return ResponseEntity.ok(Map.of("status", loan.getStatus(), "remarks", loan.getRemarks()));
	    }
}
