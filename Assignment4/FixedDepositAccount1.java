/*
Sub class for Fixed Deposit Accounts inheriting from the base Account class.
It contains attributes to store interest rate, accrued and paid interest,
tenure duration, maturity date, interest payment frequency,
and the date of last interest payment.
It provides methods to add interest based on frequency,
and calculate the total maturity amount.
Author: Akshay Basak
Date: 10-07-2025
*/

package Assignment4;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
//Represents a fixed deposit account with maturity
public class FixedDepositAccount1 extends Account1 {
    float interest_rate;
	double interest_accrued;
	double interest_paid;
	int tenure_time_in_days;
	LocalDate maturity_date;
	int payment_frequency;
	LocalDate last_interest_paid_date;
	
	// Constructor to initialize fixed deposit account
	FixedDepositAccount1(String account_no, double account_balance, LocalDate account_opening_date, float interest_rate , int tenure_time_in_days , LocalDate maturity_date , int payment_frequency ,LocalDate last_interest_paid_date)
	{
		super(account_no , account_balance ,account_opening_date);
		this.interest_rate = interest_rate;
		this.interest_accrued = 0.0;
		this.interest_paid = 0.0;
		this.tenure_time_in_days = tenure_time_in_days;
		this.maturity_date = maturity_date;
		this.payment_frequency = payment_frequency;
		this.last_interest_paid_date =  last_interest_paid_date;
	}
	
	float getInterestRate() {
		return interest_rate;
	}
	
	double getInterestAccrued()
	{
		return interest_accrued;
	}
	
	double getInterestPaid()
	{
		return interest_paid;
	}
	
	// Adds interest based on time and frequency
	void addInterest()
	{
		long months = ChronoUnit.MONTHS.between(last_interest_paid_date, LocalDate.now());
       if (months >= payment_frequency) {
           interest_accrued = (getAccountBalance() * interest_rate * months) / 1200;
           interest_paid += interest_accrued;
           last_interest_paid_date = LocalDate.now();
       }
	}
	
	 // Returns maturity value including interest paid
	double getMaturityAmount()
	{
		return account_balance + interest_paid;
	}
	LocalDate getMaturityDate()
	{
		return maturity_date;
	}
}
