/* 
 Class to represent Complex Numbers and perform basic operations.
 It contains attributes for real and imaginary parts,
 provides constructors to initialize values,
 and includes methods to display the number, calculate sum, and compute magnitude.

 Author: Akshay Basak
 Date: 10-07-2025
*/

package Assignment1;
 
import java.util.Scanner;

public class ComplexNum {
    public static class Complex_Number {
        // Attributes for Real and Imaginary parts
    private int real;
	    private int img;

	    // Default Constructor
	    public Complex_Number() {
	        this.real = 0;
	        this.img = 0;
	    }

	    // Parameterized Constructor
	    public Complex_Number(int real, int img) {
	        this.real = real;
	        this.img = img;
	    }

	    // Copy Constructor
	    public Complex_Number(Complex_Number c) {
	        this.real = c.real;
	        this.img = c.img;
	    }
	    
	    //Method to add two Complex Numbers
	    public Complex_Number getSum(Complex_Number c)
	    {
	    	int newReal = this.real + c.real;
	    	int newImg =  this.img + c.img;
	    	return new Complex_Number(newReal , newImg);
	    }
	    
	    //Method to display a Complex Number
	    public void displayNumber()
	    {
	    	if(img >= 0)
	    	{
	    		System.out.println(real + "+" + img + "i");
	    	}
	    	else
	    	{
	    		System.out.println(real + "-" +  Math.abs(img) + "i");
	    	}
	    }
	    
	    //Magnitude of a Complex Numbers
	    public double getMagnitude()
	    {
	    	return Math.sqrt(real*real + img*img);
	    }
	    
	    //Getting only Real part
	    public int getReal()
	    {
	    	return real;
	    }
	    
	    //Getting only Imaginary part
	    public int getImg()
	    {
	    	return img;
	    }
	}

	public static void main(String[] args) {
        // Create a Scanner object for input
		Scanner sc = new Scanner(System.in);
		
		//Input 1st complex number
		System.out.print("Enter the Real part of the 1st Complex Number : ");
		int real1 = sc.nextInt();
		System.out.print("Enter the Img part of the 1st Complex Number : ");
		int img1 = sc.nextInt();
		Complex_Number c1 = new Complex_Number(real1,img1);
		
		//Input 2nd complex number
		System.out.print("Enter the Real part of the 2nd Complex Number : ");
	    int real2 = sc.nextInt();
		System.out.print("Enter the Img part of the 2nd Complex Number : ");
		int img2 = sc.nextInt();
		Complex_Number c2 = new Complex_Number(real2,img2);
		
		//Addition
		Complex_Number sum = c1.getSum(c2);
		
		// Display results
        System.out.print("First Number: ");
        c1.displayNumber();

        System.out.print("Second Number: ");
        c2.displayNumber();

        System.out.print("Sum: ");
        sum.displayNumber();

        System.out.println("Magnitude of first number: " + c1.getMagnitude());
        System.out.println("Magnitude of second number: " + c2.getMagnitude());

        sc.close();
	}    
}
