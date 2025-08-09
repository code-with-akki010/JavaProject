/**
* Main class to demonstrate Banking System operations:
* Handles Saving, Current, and Fixed Deposit accounts.
*
* Author: Akshay Basak
* Date: 10-07-2025
*/

package Assignment4;

import java.time.LocalDate;

public class BankingSystem1 {
    public static void main(String[] args) {
       System.out.println("=========================================");
       System.out.println("          YOUR ACCOUNT SUMMARY         ");
       System.out.println("=========================================");
       // ========== SAVING ACCOUNT ==========
       System.out.println("\n SAVING ACCOUNT DETAILS");
       SavingAccount1 savingAcc = new SavingAccount1("SA123", 56000.36, 5.7f, LocalDate.of(2023, 1, 1),LocalDate.of(2025, 5, 11));
       savingAcc.addInterest();
       System.out.printf("Account No       : %s\n", savingAcc.getAccountNo());
       System.out.printf("Initial Balance  : ₹%.2f\n", 56000.36);
       System.out.printf("Interest Rate    : %.2f%%\n", savingAcc.getInterestRate());
       System.out.printf("Interest Paid    : ₹%.2f\n", savingAcc.getInterestPaid());
       System.out.printf("Updated Balance  : ₹%.2f\n", savingAcc.getAccountBalance());
       // ========== CURRENT ACCOUNT ==========
       System.out.println("\n CURRENT ACCOUNT DETAILS");
       CurrentAccount1 currentAcc = new CurrentAccount1(
           "CA456",
           56000.36,
           LocalDate.now(),
           60000.00,
           LocalDate.of(2025, 11, 13)
       );
       System.out.printf("Account No       : %s\n", currentAcc.getAccountNo());
       System.out.printf("Balance          : ₹%.2f\n", currentAcc.getAccountBalance());
       System.out.printf("Overdraft Limit  : ₹%.2f\n", currentAcc.getOverdraftLimit());
       System.out.printf("Overdrawn Amount : ₹%.2f\n", currentAcc.getOverdrawnAmount());
       // ========== FIXED DEPOSIT ACCOUNT ==========
       System.out.println("\n FIXED DEPOSIT ACCOUNT DETAILS");
       FixedDepositAccount1 fdAcc = new FixedDepositAccount1(
           "FD789",
           60000.50,
           LocalDate.now(),
           7.5f,
           456,
           LocalDate.of(2025, 12, 26),
           10,
           LocalDate.of(2025, 11, 13)
       );
       fdAcc.addInterest();  // optional: calculate maturity with interest
       System.out.printf("FD Account No    : %s\n", fdAcc.getAccountNo());
       System.out.printf("Principal Amount : ₹%.2f\n", fdAcc.getAccountBalance());
       System.out.printf("Interest Rate    : %.2f%%\n", fdAcc.getInterestRate());
       System.out.printf("Interest Paid    : ₹%.2f\n", fdAcc.getInterestPaid());
       System.out.printf("Maturity Amount  : ₹%.2f\n", fdAcc.getMaturityAmount());
       System.out.println("Maturity Date    : " + fdAcc.getMaturityDate());
       System.out.println("\n Thank you for banking with us!");
       System.out.println("=========================================");
   }
}
