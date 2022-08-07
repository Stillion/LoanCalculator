package com.leanpay.loancalculator.amortizationcalculator;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leanpay.loancalculator.loan.Loan;
import com.leanpay.loancalculator.loan.LoanRepository;
import com.leanpay.loancalculator.loanpayment.LoanPayment;
import com.leanpay.loancalculator.loanpayment.LoanPaymentRepository;

@Service
public class AmortizationCalculatorService {

	@Autowired
	LoanRepository loanRepository;
	
	@Autowired
	LoanPaymentRepository loanPaymentRepository;
	
	public List<LoanPayment> calculateLoan(Loan loan) {
		
		DecimalFormat df = new DecimalFormat("#.##");
		List<LoanPayment> loanPayments = new ArrayList<LoanPayment>();
		
		double monthlyPayment;
		double principalAmount;
		double loanAmount = loan.getLoanAmount();
		double balanceOwed = loanAmount;
		double interestRatePercentage = loan.getInterestRate();
		double interestRate;
		double interestAmount;
		double totalAmountPaid;
		double totalInterestPaid;
		int loanTerm = loan.getLoanTerm();
		int termTypeId = loan.getTermTypeId();
		int numOfMonths = loanTerm;
		
		interestRate = interestRatePercentage / 100 / 12;
		
		if(termTypeId == 2) { // 1 - months, 2 - years
			numOfMonths *= 12;
		}
		
		monthlyPayment = (loanAmount * interestRate * Math.pow(1 + interestRate, numOfMonths)) / (Math.pow(1 + interestRate, numOfMonths) - 1);
		
		totalAmountPaid = monthlyPayment * numOfMonths;
		
		totalInterestPaid = Double.valueOf(df.format(totalAmountPaid - loanAmount));
		
		monthlyPayment = Double.valueOf(df.format(monthlyPayment));
		
		loan.setMonthlyPayment(monthlyPayment);
		loan.setTotalInterest(totalInterestPaid);
		
		try {
			loanRepository.save(loan);
			
			for(int i = 0; i < numOfMonths; i++) {
				interestAmount = balanceOwed * interestRate;
				principalAmount = monthlyPayment - interestAmount;
				balanceOwed = balanceOwed - principalAmount;
				
				if(balanceOwed < 0) {
					monthlyPayment = monthlyPayment + Double.valueOf(df.format(balanceOwed));
					principalAmount = principalAmount + Double.valueOf(df.format(balanceOwed));
					balanceOwed = 0;
				}
				
				LoanPayment loanPayment = new LoanPayment();
				
				loanPayment.setLoan(loan);
				loanPayment.setPaymentAmount(Double.valueOf(df.format(monthlyPayment)));
				loanPayment.setPrincipalAmount(Double.valueOf(df.format(principalAmount)));
				loanPayment.setInterestAmount(Double.valueOf(df.format(interestAmount)));
				loanPayment.setBalanceOwed(Double.valueOf(df.format(balanceOwed)));
				
				loanPaymentRepository.save(loanPayment);
				
				loanPayments.add(loanPayment);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return loanPayments;
	}
}
