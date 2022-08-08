# LoanCalculator
 
### Application diagrams ###
 On this link can find the Database ER diagram, as well as the UML Sequence diagram: https://miro.com/app/board/uXjVOgyYzH4=/
 
### Starting the application ###
 To start the application, clone this repository and start the project. The runtime database H2 was used for storing data. In the **create.sql** file you can find the database table scripts.
 
 In the file **LoanCalculator.postman_collection.json** you can find the Postman request used for testing.
 
 The **Simple Loan Calculator** request will provide result set as needed for https://www.calculatorsoup.com/calculators/financial/loan-calculator-simple.php.
 
 The **Amortization Schedule** request will provide result set as needed for https://www.calculatorsoup.com/calculators/financial/amortization-schedule-calculator.php
 
 The **termTypeId** field in the request body determines the term type as follows: 1 - Month, 2 - Year
 
 The **Get All Loans** request will return all of the created loans.
 
 

 
 
 
