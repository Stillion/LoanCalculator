CREATE SEQUENCE hibernate_sequence START WITH 1 INCREMENT BY 1;

CREATE TABLE loan (loan_id bigint not null, 
				   interest_rate double, 
				   loan_amount double, 
				   loan_term integer, 
				   monthly_payment double, 
				   term_type_id integer, 
				   total_interest double, 
				   PRIMARY KEY (loan_id));

CREATE TABLE loan_payment (loan_payment_id bigint not null, 
						   balance_owed double, 
						   interest_amount double, 
						   payment_amount double, 
						   principal_amount double, 
						   loan_id bigint not null, 
						   PRIMARY KEY (loan_payment_id));

ALTER TABLE loan_payment 
ADD CONSTRAINT FK_LoanPayment_Loan_LoanId FOREIGN KEY (loan_id) REFERENCES loan;
