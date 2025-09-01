package com.srs.services;


import com.srs.entity.*;
import java.util.List;

public interface LoanService {
    LoanApplication applyLoan(LoanApplication loanApplication);
    LoanApplication updateLoan(Long id, LoanApplication update);
    void cancelLoan(Long id);
    LoanApplication getLoanById(Long id);
    List<LoanApplication> getLoansByCustomer(Long customerId);
    List<LoanApplication> getLoansByStatus(String status);
}
