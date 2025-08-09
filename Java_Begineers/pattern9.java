//0-1 Triangle 
// 1
// 01
// 101
// 0101
// 10101

package Java_Begineers;

import java.util.Scanner;

public class pattern9 {
    public static void main(String[] args) {
        // Program to print a triangle pattern of 1s and 0s
        // The pattern is such that the sum of row and column indices determines the value printed
		try(
				Scanner sc=new Scanner(System.in)) {
			int n=sc.nextInt();
			int i,j;
			for(i=1;i<=n;i++)
			{
				for(j=1;j<=i;j++)
				{
					if((i+j)%2==0)
						System.out.print("1");
					else
						System.out.print("0");
				}
				System.out.print("\n");
			}
		}
	}
}
