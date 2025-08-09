//Inverted Half Pyramid with numbers
// 1234
// 123
// 12
// 1

package Java_Begineers;

import java.util.Scanner;

public class pattern7 {
    public static void main(String[] args) {
        // Program to print an inverted half pyramid pattern of numbers
        // The pattern starts with the maximum number of columns and decreases by one in each row
		try(
				Scanner sc=new Scanner(System.in)) {
			int n=sc.nextInt();
			int i,j;
			for(i=1;i<=n;i++)
			{
				for(j=1;j<=n-i+1;j++)
					System.out.printf("%d",j);
				System.out.print("\n");
			}
		}
	}
}
