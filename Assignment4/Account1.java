/*
Base class for different types of bank accounts such as Saving, Current, and Fixed Deposit.
It contains attributes to store account number, balance, and opening date.
It provides a constructor to initialize these values,
and getter methods to access the account details.
Author: Akshay Basak
Date: 10-07-2025
*/
package Assignment4;

import java.time.LocalDate;

public class Account1 {
    String account_no;
	double account_balance;
	LocalDate account_opening_date;
	
	Account1(String account_no , double account_balance , LocalDate account_opening_date)
	{
		this.account_no = account_no;
		this.account_balance = account_balance;
		this.account_opening_date = account_opening_date;
	}
	
	String getAccountNo()
	{
		return account_no;
	}
	
	double getAccountBalance()
	{
		return account_balance;
	}
	
	LocalDate getAccountOpeningDate()
	{
		return account_opening_date;
	}
}
