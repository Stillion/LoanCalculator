package com.leanpay.loancalculator.simplecalculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.leanpay.loancalculator.loan.Loan;

@RestController
public class SimpleCalculatorController {

	@Autowired
	SimpleCalculatorService calulatorService;
	
	@CrossOrigin
	@RequestMapping(method = RequestMethod.POST, value = "/calculator/simple")
	public String calulateLoan(@RequestBody Loan loan) {
		 return calulatorService.calculateLoan(loan);
	}
	
}
