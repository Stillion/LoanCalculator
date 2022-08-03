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
	
	@Column(name = "loanTerm")
	private int loanTerm; 
	
	@Column(name = "termTypeId")
	private int termTypeId; 
	

	public Loan() {}
	
	public Loan(long loanId, double loanAmount, int loanTerm, int termTypeId) {
		super();
		this.loanId = loanId;
		this.loanAmount = loanAmount;
		this.loanTerm = loanTerm;
		this.termTypeId = termTypeId;
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

	
	@Override
	public String toString() {
		return "Loan [loanId=" + loanId + ", loanAmount=" + loanAmount + ", loanTerm=" + loanTerm + ", termTypeId="
				+ termTypeId + "]";
	}

	
}
