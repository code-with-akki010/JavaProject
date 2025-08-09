//Floyd's Triangle
// 1
// 23
// 456
// 78910

package Java_Begineers;

import java.util.Scanner;

public class pattern8 {
    public static void main(String[] args) {
        // Program to print a triangle pattern of numbers
        // The pattern is such that each row contains consecutive numbers starting from 1
		try(
				Scanner sc=new Scanner(System.in)) {
			int n=sc.nextInt();
			int i,j,k=1;
			for(i=1;i<=n;i++)
			{
				for(j=1;j<=i;j++)
				{
					System.out.printf("%d ",k);
					k++;
				}
				System.out.print("\n");
			}
		}
	}
}
