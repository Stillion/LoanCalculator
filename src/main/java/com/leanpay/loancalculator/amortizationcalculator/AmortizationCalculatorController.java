package com.leanpay.loancalculator.amortizationcalculator;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.leanpay.loancalculator.loan.Loan;
import com.leanpay.loancalculator.loanpayment.LoanPayment;

@RestController
public class AmortizationCalculatorController {

	@Autowired
	AmortizationCalculatorService amortizationCalulatorService;
	
	@CrossOrigin
	@RequestMapping(method = RequestMethod.POST, value = "calculator/amortization")
	public List<LoanPayment> calculateLoan(@RequestBody Loan loan) {
		return amortizationCalulatorService.calculateLoan(loan);
	}
}
