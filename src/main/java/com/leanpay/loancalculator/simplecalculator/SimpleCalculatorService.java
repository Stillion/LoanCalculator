package com.leanpay.loancalculator.simplecalculator;

import java.text.DecimalFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leanpay.loancalculator.loan.Loan;
import com.leanpay.loancalculator.loan.LoanRepository;

@Service
public class SimpleCalculatorService {

	@Autowired
	LoanRepository loanRepository;
	
	public String calculateLoan(Loan loan) {
		
		DecimalFormat df = new DecimalFormat("0.00");
		
		double monthlyPayment;
		double totalAmountPaid;
		double totalInterestPaid;
		double loanAmount = loan.getLoanAmount();
		double interestRatePercentage = loan.getInterestRate();
		double interestRate;
		int loanTerm = loan.getLoanTerm();
		int termTypeId = loan.getTermTypeId();
		int numOfMonths = loanTerm;
		
		interestRate = interestRatePercentage / 100 / 12;
		
		if(termTypeId == 2) { // 1 - months, 2 - years
			numOfMonths *= 12;
		}
		
		//Payment = Loan Amount × i(1 + i)^n / (1 + i)^n − 1
		monthlyPayment = (loanAmount * interestRate * Math.pow(1 + interestRate, numOfMonths)) / (Math.pow(1 + interestRate, numOfMonths) - 1);
	
		totalAmountPaid = monthlyPayment * numOfMonths;
		
		totalInterestPaid = totalAmountPaid - loanAmount;
		
		loan.setMonthlyPayment(Double.valueOf(df.format(monthlyPayment)));
		loan.setTotalInterest(Double.valueOf(df.format(totalInterestPaid)));
		
		try {
			loanRepository.save(loan);
		}
		catch(Exception e) {
			e.printStackTrace();
			return"ERROR: Couldn't save a loan to the database!";
		}
		
		return "Monthly Payment: " + loan.getMonthlyPayment() + ", Total Interest Payed: " + loan.getTotalInterest();
	}
	
}
