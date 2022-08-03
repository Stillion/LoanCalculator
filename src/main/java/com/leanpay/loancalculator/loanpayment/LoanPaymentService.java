package com.leanpay.loancalculator.loanpayment;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoanPaymentService {

	@Autowired
	LoanPaymentRepository loanPaymentRepository;
	
	public List<LoanPayment> getAllLoanPayments(){
		return loanPaymentRepository.findAll();
	}
	
	public Optional<LoanPayment> getLoanPaymentById(long loanPaymentId){
		return loanPaymentRepository.findById(loanPaymentId);
	}
	
	
	public List<LoanPayment> getAllLoanPaymentsForLoan(long loanId){
		return null;
	}
	
	public void addLoanPayment(LoanPayment loanPayment) {
		loanPaymentRepository.save(loanPayment);
	}
	
	
}
