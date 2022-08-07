package com.leanpay.loancalculator.loanpayment;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.leanpay.loancalculator.loan.Loan;

@Entity
@Table(name = "LoanPayment")
public class LoanPayment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long loanPaymentId;
	
	@ManyToOne
	@JoinColumn(name ="loanId", nullable = false)
	private Loan loan;
	
	@Column(name = "paymentAmount")
	private double paymentAmount;

	@Column(name = "principalAmount")
	private double principalAmount;
	
	@Column(name = "interestAmount")
	private double interestAmount;
	
	@Column(name = "balanceOwed")
	private double balanceOwed;

	
	public LoanPayment() {
		
	}
	
	public long getLoanPaymentId() {
		return loanPaymentId;
	}
	
	public void setLoanPaymentId(long loanPaymentId) {
		this.loanPaymentId = loanPaymentId;
	}

	public Loan getLoan() {
		return loan;
	}

	public void setLoan(Loan loan) {
		this.loan = loan;
	}

	public double getPaymentAmount() {
		return paymentAmount;
	}

	public void setPaymentAmount(double paymentAmount) {
		this.paymentAmount = paymentAmount;
	}

	public double getPrincipalAmount() {
		return principalAmount;
	}

	public void setPrincipalAmount(double principalAmount) {
		this.principalAmount = principalAmount;
	}

	public double getInterestAmount() {
		return interestAmount;
	}

	public void setInterestAmount(double interestAmount) {
		this.interestAmount = interestAmount;
	}

	public double getBalanceOwed() {
		return balanceOwed;
	}

	public void setBalanceOwed(double balanceOwed) {
		this.balanceOwed = balanceOwed;
	}

	@Override
	public String toString() {
		return "LoanPayment [loanPaymentId=" + loanPaymentId + ", loan=" + loan + ", paymentAmount=" + paymentAmount
				+ ", principalAmount=" + principalAmount + ", interestAmount=" + interestAmount + ", balanceOwed="
				+ balanceOwed + "]";
	}
	
	
	
}
