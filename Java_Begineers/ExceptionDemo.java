package Java_Begineers;

import java.util.Scanner;

public class ExceptionDemo {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int dividend = sc.nextInt();
        int divisor = sc.nextInt();
        // Handling division by zero using try-catch block
        // This will prevent the program from crashing if divisor is zero
        try {
        int result = dividend / divisor;
        System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Divisor cannot be zero. Please enter a valid divisor.");
            // Optionally, you can log the exception or handle it in a specific way
        }
        sc.close();
    }
}
