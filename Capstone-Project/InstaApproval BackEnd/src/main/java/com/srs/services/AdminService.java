package com.srs.services;

import com.srs.entity.LoanApplication;

public interface AdminService {
    LoanApplication approve(Long loanId, Long adminId, String remarks);
    LoanApplication reject(Long loanId, Long adminId, String remarks);
}

