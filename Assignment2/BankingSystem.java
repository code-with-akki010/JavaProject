/**
* Main driver class to test different types of bank accounts.
* Demonstrates SavingAccount, CurrentAccount, and FixedDepositAccount.
*
* Author: Akshay Basak
* Date: 10-07-2025
*/

package Assignment2;
import java.time.LocalDate;

public class BankingSystem {
    public static void main(String[] args) {
       System.out.println("======== Your Banking History Summary ========");
       // ================== Saving Account ==================
       System.out.println("\n------ Saving Account ------");
       SavingAccount sa = new SavingAccount("SA123", 56000.36, 5.7f);
       System.out.println("Account No       : " + sa.getAccountNo());
       System.out.printf("Initial Balance  : ₹%.2f\n", sa.getAccountBalance());
       sa.addInterest();  // Adds interest to the balance
       System.out.printf("Interest Paid    : ₹%.2f\n", sa.getInterestPaid());
       System.out.printf("Updated Balance  : ₹%.2f\n", sa.getAccountBalance());
       // ================== Current Account ==================
       System.out.println("\n------ Current Account ------");
       CurrentAccount cr = new CurrentAccount("CA456", 56000.36, 60000.00);
       System.out.println("Account No       : " + cr.getAccountNo());
       System.out.printf("Balance          : ₹%.2f\n", cr.getAccountBalance());
       System.out.printf("Overdraft Limit  : ₹%.2f\n", cr.getOverdraftLimit());
       // ================== Fixed Deposit Account ==================
       System.out.println("\n------ Fixed Deposit Account ------");
       LocalDate maturityDate = LocalDate.of(2025, 12, 26);
       FixedDepositAccount fx = new FixedDepositAccount(
           "FD789",
           60000.50,
           7.5f,
           456,
           maturityDate,
           10  // Duration in months
       );
       fx.addInterest(); // Calculates maturity amount
       System.out.println("FD Account No    : " + fx.getAccountNo());
       System.out.printf("FD Balance       : ₹%.2f\n", fx.getAccountBalance());
       System.out.printf("Interest Rate    : %.2f%%\n", fx.getInterestRate());
       System.out.printf("Interest Paid    : ₹%.2f\n", fx.getInterestPaid());
       System.out.printf("Maturity Amount  : ₹%.2f\n", fx.getMaturityAmount());
       System.out.println("\n======== Thank you for banking with us! ========");
   }
}
