//Half Pyramid with numbers
// 1
// 12
// 123
// 1234
package Java_Begineers;

import java.util.Scanner;

public class pattern6 {
    public static void main(String[] args) {
        // Program to print a half pyramid pattern of numbers
        // The pattern starts with one column and increases by one in each row
		Scanner sc=new Scanner(System.in);
            // Input the number of rows for the pyramid
			int n=sc.nextInt();
			int i,j;
			for(i=1;i<=n;i++)
			{
				for(j=1;j<=i;j++)
					System.out.printf("%d",j);
				System.out.print("\n");
			}
            sc.close();
        // End of the program
		}
}
