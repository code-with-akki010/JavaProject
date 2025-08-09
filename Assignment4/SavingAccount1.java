/*
Sub class for Saving Accounts1 inheriting from the base Account class1.
It contains attributes to manage interest rate, interest accrued, interest paid,
and the date when interest was last paid.
It provides a method to calculate and add monthly interest
based on the time elapsed using ChronoUnit.
Author: Akshay Basak
Date: 10-07-2025
*/
package Assignment4;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

//Represents a savings account with interest calculation
public class SavingAccount1 extends Account1{
    private float interest_rate;
	private double interest_accrued;
	private double interest_paid;
	private LocalDate last_interest_paid_date;
	
	// Constructor to initialize savings account
	public SavingAccount1(String account_no , double account_balance , float interest_rate,LocalDate account_opening_date , LocalDate last_interest_paid_date)
	{
		super(account_no , account_balance ,account_opening_date);
		this.account_opening_date = account_opening_date;
		this.interest_rate = interest_rate;
		this.interest_accrued = 0.0;
		this.interest_paid = 0.0;
		this.last_interest_paid_date = last_interest_paid_date;
	}
	
	public float getInterestRate()
	{
		return interest_rate;
	}
	
	public double getInterestAccrued()
	{
		return interest_accrued;
	}
	
	public double getInterestPaid()
	{
		return interest_paid;
	}
	// Adds interest based on months passed since last payment
	public void addInterest()
	{
		if (account_opening_date == null) {
	        System.out.println("Opening date not set! Cannot calculate interest.");
	        return;
	    }
		long months = ChronoUnit.MONTHS.between(last_interest_paid_date, LocalDate.now());
       if (months > 0) {
           interest_accrued = (getAccountBalance() * interest_rate * months) / 1200;
           interest_paid += interest_accrued;
           last_interest_paid_date = LocalDate.now();
       }
	}
}
