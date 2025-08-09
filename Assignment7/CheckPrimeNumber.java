/*
Program to check whether a number given by the user is prime or not.
A number having only two factors (1 and the number itself) is called Prime number
Author: Akshay Basak
Date: 10-07-2025
*/
package Assignment7;
import java.util.Scanner;
public class CheckPrimeNumber {
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int flag =0;
		
       // Take input from user
		System.out.println("Enter any  number : ");
		int n = sc.nextInt();
		
		if(n<=1)
		{
			System.out.println("Error:Wrong Input\nThe given number is not catagorised under Prime number!!!");
		}
		
		else
		{
			for(int i = 2; i<n/2;i++)
			{
				if(n%i == 0)
				{
					flag = 1;
					break;
				}
			}
			if(flag == 0)
			{
				System.out.println(n + "is a Prime Number!");
			}
			else
			{
				System.out.println(n + "is not a Prime Number!");
			}
		}
		sc.close();
	}
    // This main method checks if a number entered by the user is prime or not.
    // It uses a loop to check divisibility and prints the result accordingly.
}
