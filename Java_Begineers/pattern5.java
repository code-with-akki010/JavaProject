//Inverted Half Pyramid (rotated 180 degree)
//    * 
//   **
//  *** 
// ****

package Java_Begineers;

import java.util.Scanner;

public class pattern5 {
    public static void main(String[] args) {
		// Program to print an inverted half pyramid pattern of stars
		// The pattern starts with the maximum number of stars and decreases by one in each row

			Scanner sc=new Scanner(System.in);
            // Input the number of rows for the pyramid
			int n=sc.nextInt();
			int i,j;
			for(i=1;i<=n;i++)
			{
				for(j=i;j<=n;j++)
					System.out.print(" ");
				for(j=1;j<=i;j++)
					System.out.print("*");
				System.out.print("\n");
			}
            sc.close();
		}
}
