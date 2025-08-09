package Java_Begineers;

import java.util.Scanner;
public class Hello {
    public static void main(String[] args) {
		try (
		Scanner sc = new Scanner(System.in)) {
			int a=sc.nextInt();
			int b=sc.nextInt();
			int sum=a+b;
			//next() -> for single name
			//nextLine() -> for input full name
			//nextInt() -> for integer number
			//nextFloat() ->for floating number
			System.out.println(sum);
		}
	}

}
