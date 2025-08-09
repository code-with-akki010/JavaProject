/*
Program to input a decimal number from user and convert it into corresponding binary value
This program can be done easily using this method: Integer.toBinaryString(n)
Author: Akshay Basak
Date: 10-07-2025
*/
package Assignment6;
import java.util.Scanner;
public class DecimalToBinary {
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
       // Take input from user
		System.out.println("Enter any decimal number : ");
		int decimal = sc.nextInt();
		
		//Convert decimal to binary number using Built-in method
		String binary = Integer.toBinaryString(decimal);
		
		// Output result
		System.out.println("The Binary representation of the decimal number is : "+binary);
		sc.close();
		
	}
    // This main method takes a decimal number input from the user,
    // converts it to binary using Integer.toBinaryString(),
    // and prints the binary representation.
}
