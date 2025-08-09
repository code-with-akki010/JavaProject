/* 
Sub class for Current Accounts inheriting data from Parent class Account.
It has an attribute to store the overdraft limit.
It has a constructor to initialize these values,
and a method to retrieve the overdraft limit.

Author: Akshay Basak
Date: 10-07-2025
*/
package Assignment2;

public class CurrentAccount extends Account {
    private double overdraft_limit; // Overdraft limit for the account

    // Constructor
	public CurrentAccount(String account_no , double account_balance , double overdraft_limit)
	{
		super(account_no , account_balance);
		this.overdraft_limit = overdraft_limit;

	}
	
	public double getOverdraftLimit()
	{
		return overdraft_limit;
	}
}
