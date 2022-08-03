package com.leanpay.loancalculator.loanpayment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
public interface LoanPaymentRepository extends JpaRepository<LoanPayment, Long>{

}
