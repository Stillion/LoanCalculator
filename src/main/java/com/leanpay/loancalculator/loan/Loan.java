package com.leanpay.loancalculator.loan;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Loan")
public class Loan {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long loanId; 
	
	@Column(name = "loanAmount")
	private double loanAmount; 

	@Column(name = "interestRate")
	private double interestRate; 
	
	@Column(name = "loanTerm")
	private int loanTerm; 
	
	@Column(name = "termTypeId")
	private int termTypeId; 
	
	@Column(name = "monthlyPayment")
	private double monthlyPayment; 
	
	@Column(name = "totalInterest")
	private double totalInterest;

	public Loan() {}
	
	public Loan(double loanAmount, double interestRate, int loanTerm, int termTypeId) {
		super();
		this.loanAmount = loanAmount;
		this.interestRate = interestRate;
		this.loanTerm = loanTerm;
		this.termTypeId = termTypeId;
	}

	public Loan(double loanAmount, double interestRate, int loanTerm, int termTypeId, double monthlyPayment, double totalInterest) {
		super();
		this.loanAmount = loanAmount;
		this.interestRate = interestRate;
		this.loanTerm = loanTerm;
		this.termTypeId = termTypeId;
		this.monthlyPayment = monthlyPayment;
		this.totalInterest = totalInterest;
	}
	
	public long getLoanId() {
		return loanId;
	}

	public void setLoanId(long loanId) {
		this.loanId = loanId;
	}

	public double getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(double loanAmount) {
		this.loanAmount = loanAmount;
	}
	
	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

	public int getLoanTerm() {
		return loanTerm;
	}

	public void setLoanTerm(int loanTerm) {
		this.loanTerm = loanTerm;
	}

	public int getTermTypeId() {
		return termTypeId;
	}

	public void setTermTypeId(int termTypeId) {
		this.termTypeId = termTypeId;
	}
	
	public double getMonthlyPayment() {
		return monthlyPayment;
	}

	public void setMonthlyPayment(double monthlyPayment) {
		this.monthlyPayment = monthlyPayment;
	}
	
	public double getTotalInterest() {
		return totalInterest;
	}

	public void setTotalInterest(double totalInterest) {
		this.totalInterest = totalInterest;
	}

	
	@Override
	public String toString() {
		return "Loan [loanId=" + loanId + ", loanAmount=" + loanAmount + ", loanTerm=" + loanTerm + ", termTypeId="
				+ termTypeId + "]";
	}

	
}
