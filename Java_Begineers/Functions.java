package Java_Begineers;

import java.util.Scanner;

public class Functions {
    public static int fact(int x)
	{
		if(x<1)
		{
			System.out.println("Invalid Number!");
			return -999;
		}
		int f=1,i;
		for(i=1;i<=x;i++)
			f*=i;
		return f;
	}

	public static void main(String[] args) {
        // Program to calculate factorial of a number using functions
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		
		int c=fact(n);
		System.out.print(c);
		sc.close();

	}
}
