package Java_Begineers;

import java.util.Scanner;

public class ExceptionDemo1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Handling division by zero and array index out of bounds using try-catch blocks
        // This will prevent the program from crashing if divisor is zero or if array index is out
        int arr[] = new int[5];
        try {
             arr[6] = 10 / 0;
        }
        // catch (ArithmeticException | ArrayIndexOutOfBoundsException e)
        // {
        //     System.out.println("An exception occurred: " + e.getMessage());
        //     // You can log the exception or handle it in a specific way
        // }
        catch(ArithmeticException e){
            System.out.println("Divisor cannot be zero. Please enter a valid divisor.");
        }
        catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("Array index is out of bounds. Please check the index.");

        }
        sc.close();
    }
}
