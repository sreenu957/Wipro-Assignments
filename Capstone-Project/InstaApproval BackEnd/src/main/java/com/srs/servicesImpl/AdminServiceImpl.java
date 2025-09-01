package com.srs.servicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.srs.entity.Admin;
import com.srs.entity.LoanApplication;
import com.srs.entity.LoanStatus;
import com.srs.repos.AdminRepository;
import com.srs.repos.LoanApplicationRepository;
import com.srs.services.AdminService;

@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired
    private LoanApplicationRepository loanApplicationRepository;

    @Autowired
    private AdminRepository adminRepository;

	@Override
	public LoanApplication approve(Long loanId, Long adminId, String remarks) {
		LoanApplication loan = loanApplicationRepository.findById(loanId)
                .orElseThrow(() -> new RuntimeException("Loan not found"));
        Admin admin = adminRepository.findById(adminId)
                .orElseThrow(() -> new RuntimeException("Admin not found"));

        loan.setStatus(LoanStatus.APPROVED);
        loan.setRemarks(remarks);
        loan.setApprovedBy(admin);

        return loanApplicationRepository.save(loan);
	}

	@Override
	public LoanApplication reject(Long loanId, Long adminId, String remarks) {
		LoanApplication loan = loanApplicationRepository.findById(loanId)
                .orElseThrow(() -> new RuntimeException("Loan not found"));
        Admin admin = adminRepository.findById(adminId)
                .orElseThrow(() -> new RuntimeException("Admin not found"));

        loan.setStatus(LoanStatus.REJECTED);
        loan.setRemarks(remarks);
        loan.setApprovedBy(admin);

        return loanApplicationRepository.save(loan);
	}

}
