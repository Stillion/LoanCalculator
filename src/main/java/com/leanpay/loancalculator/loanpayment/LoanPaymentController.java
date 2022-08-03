package com.leanpay.loancalculator.loanpayment;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoanPaymentController {

	@Autowired
	LoanPaymentService loanPaymentService;
	
	@CrossOrigin
	@RequestMapping("/loanPayments")
	public List<LoanPayment> getAllLoanPayments(){
		return loanPaymentService.getAllLoanPayments();
	}
	
	@CrossOrigin
	@RequestMapping("/loanPayments/{loanPaymentId}")
	public Optional<LoanPayment> getLoanPaymentById(@PathVariable long loanPaymentId){
		return loanPaymentService.getLoanPaymentById(loanPaymentId);
	}
	
	@CrossOrigin
	@RequestMapping("/loans/{loanId}/loanPayments")
	public List<LoanPayment> getAllLoanPaymentsForLoan(@PathVariable long loanId){
		return loanPaymentService.getAllLoanPaymentsForLoan(loanId);
	}
	
}
