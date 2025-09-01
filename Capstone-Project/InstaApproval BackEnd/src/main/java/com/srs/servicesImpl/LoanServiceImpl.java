package com.srs.servicesImpl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.srs.entity.Customer;
import com.srs.entity.LoanApplication;
import com.srs.entity.LoanStatus;
import com.srs.repos.CustomerRepository;
import com.srs.repos.LoanApplicationRepository;
import com.srs.services.LoanService;

@Service
public class LoanServiceImpl implements LoanService {
	
	@Autowired
    private LoanApplicationRepository loanRepository;

    @Autowired
    private CustomerRepository customerRepository;

	@Override
	public LoanApplication applyLoan(LoanApplication loanApplication) {
		loanApplication.setStatus(LoanStatus.PENDING);
        loanApplication.setApplicationDate(LocalDate.now());
        if (loanApplication.getCustomer() != null) {
            Customer c = customerRepository.findById(loanApplication.getCustomer().getCustomerId())
                    .orElseThrow(() -> new RuntimeException("Customer not found"));
            loanApplication.setCustomer(c);
        }
        return loanRepository.save(loanApplication);
	}

	@Override
	public LoanApplication updateLoan(Long id, LoanApplication update) {
		LoanApplication existing = loanRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Loan not found"));
        if (existing.getStatus() != LoanStatus.PENDING) throw new RuntimeException("Cannot update after processing");
        existing.setLoanAmount(update.getLoanAmount());
        existing.setLoanType(update.getLoanType());
        existing.setLoanDescription(update.getLoanDescription());
        return loanRepository.save(existing);
	}

	@Override
	public void cancelLoan(Long id) {
		LoanApplication existing = loanRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Loan not found"));
        if (existing.getStatus() != LoanStatus.PENDING) throw new RuntimeException("Cannot cancel after processing");
        existing.setStatus(LoanStatus.CANCELLED);
        loanRepository.save(existing);
	}

	@Override
	public LoanApplication getLoanById(Long id) {
		return loanRepository.findById(id).orElse(null);
	}

	@Override
	public List<LoanApplication> getLoansByCustomer(Long customerId) {
		return loanRepository.findByCustomerCustomerId(customerId);
	}

	@Override
	public List<LoanApplication> getLoansByStatus(String status) {
		return loanRepository.findByStatus(LoanStatus.valueOf(status));
	}

}
