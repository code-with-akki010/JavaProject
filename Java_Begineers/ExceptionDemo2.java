package Java_Begineers;

import java.util.Scanner;

public class ExceptionDemo2 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int age = sc.nextInt();
            if(age < 18 )
            {
                throw new RuntimeException("You are not eligible to vote.");
            }
            else{
                System.out.println("You are eligible to vote.");
            }
        }
    }
}
