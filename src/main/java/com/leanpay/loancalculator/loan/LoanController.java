package com.leanpay.loancalculator.loan;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoanController {
	
	@Autowired
	LoanService loanService;
	
	@CrossOrigin
	@RequestMapping("/loans")
	public List<Loan> getAllLoans(){
		return loanService.getAllLoans();
	}
	
	@CrossOrigin
	@RequestMapping("/loans/{loanId}")
	public Optional<Loan> getLoanById(@PathVariable long loanId){
		return loanService.getLoanById(loanId);
	}
	
	@CrossOrigin
	@RequestMapping(method = RequestMethod.POST, value = "/loans")
	public void addLoan(@RequestBody Loan loan) {
		loanService.addLoan(loan);
	}
}
