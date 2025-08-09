/*
Represents a Current Account1 inheriting from the Account class1.
This class includes additional attributes to handle overdraft limit and the last overdrawn date.
It provides methods to retrieve the overdraft limit and the overdrawn amount (if applicable).
Author: Akshay Basak
Date: 10-07-2025
*/
package Assignment4;

import java.time.LocalDate;
//Represents a current account with overdraft limit
public class CurrentAccount1 extends Account1{
    double overdraft_limit;
	LocalDate last_overdrawn_date;
	
	// Constructor to initialize current account
	CurrentAccount1(String account_no , double account_balance ,LocalDate account_opening_date, double overdraft_limit , LocalDate last_overdrawn_date)
	{
		super(account_no , account_balance ,account_opening_date);
		this.overdraft_limit = overdraft_limit;
		this.last_overdrawn_date = last_overdrawn_date;
	}
	
	double getOverdraftLimit()
	{
		return overdraft_limit;
	}
	public double getOverdrawnAmount()
	{
		if(account_balance < 0) {
           return -(account_balance);      //returns the absolute value of negative balance
       }
       return 0.0;
	}
}
