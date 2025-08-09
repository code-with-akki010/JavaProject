/* 
Sub class for Fixed Deposit Accounts inheriting data from Parent class Account.
It has attributes to store interest rate, interest accrued, interest paid, 
tenure period, maturity date, and interest payment frequency.
It has a constructor to initialize these values,
and methods to calculate interest and maturity amount.

Author: Akshay Basak
Date: 10-07-2025
*/

package Assignment2;
import java.time.LocalDate;

//Represents a fixed deposit account
public class FixedDepositAccount extends Account{
    public float interest_rate;       //Stores the percentage a bank pays over time
	public double interest_accrued;  //Stores interest that has been earned but not paid yet
	private double interest_paid;     //Stores total interest that has been paid
    public int tenure_time_in_days;  //Total duration of fixed deposit
    public LocalDate maturity_date;   //The Date at which fixed deposit terms end
    public int payment_frequency;     //Stores the payment frequency


	 // Constructor
	public FixedDepositAccount(String account_no, double account_balance, float interest_rate , int tenure_time_in_days , LocalDate maturity_date , int payment_frequency )
	{
		super(account_no , account_balance);
		this.interest_rate = interest_rate;
		this.interest_accrued = 0.0;
		this.interest_paid = 0.0;
		this.tenure_time_in_days = tenure_time_in_days;
		this.maturity_date = maturity_date;
		this.payment_frequency = payment_frequency;
	}
	
	//Methods
	public float getInterestRate() {
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
	// Calculates and adds interest (does not modify balance)
	public void addInterest()
	{
		interest_accrued = account_balance * interest_rate / 100;
		interest_paid += interest_accrued;
	}
	
	public double getMaturityAmount()
	{
		return account_balance + interest_paid;
	}
}
