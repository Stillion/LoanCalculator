package com.leanpay.loancalculator.loan;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoanService {

	@Autowired
	LoanRepository loanRepository;
	
	public List<Loan> getAllLoans(){
		return loanRepository.findAll();
	}
	
	public Optional<Loan> getLoanById(long loanId){
		return loanRepository.findById(loanId);
	}
	
	public void addLoan(Loan loan) {
		loanRepository.save(loan);
	}
	
}
