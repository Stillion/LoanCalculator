package com.leanpay.loancalculator.simplecalculator;

import java.text.DecimalFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leanpay.loancalculator.loan.Loan;
import com.leanpay.loancalculator.loan.LoanRepository;
import com.leanpay.loancalculator.loanpayment.LoanPaymentRepository;

@Service
public class SimpleCalculatorService {

	@Autowired
	LoanRepository loanRepository;
	
	@Autowired
	LoanPaymentRepository loanPaymentRepository;
	
	public String calculateLoan(Loan loan) {
		
		DecimalFormat df = new DecimalFormat("#.##");
		
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
		monthlyPayment = Double.valueOf(df.format((loanAmount * interestRate * Math.pow(1 + interestRate, numOfMonths)) / (Math.pow(1 + interestRate, numOfMonths) - 1)));
	
		totalAmountPaid = monthlyPayment * numOfMonths;
		
		totalInterestPaid = Double.valueOf(df.format(totalAmountPaid - loanAmount));
		
		loan.setMonthlyPayment(monthlyPayment);
		loan.setTotalInterest(totalInterestPaid);
		
		try {
			loanRepository.save(loan);
		}
		catch(Exception e) {
			e.printStackTrace();
			return"ERROR: Couldn't save a loan to the database!";
		}
		
		return "Monthly Payment: " + monthlyPayment + ", Total Interest Payed: " + totalAmountPaid;
	}
	
}
