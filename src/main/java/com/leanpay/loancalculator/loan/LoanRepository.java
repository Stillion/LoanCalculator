package com.leanpay.loancalculator.loan;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
public interface LoanRepository extends JpaRepository<Loan, Long>{
}
