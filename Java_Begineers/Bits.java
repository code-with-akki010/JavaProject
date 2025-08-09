package Java_Begineers;

import java.util.Scanner;

public class Bits {
    public static void main(String[] args) {
		//Get Bit
		int n=5;// 0101
		int pos=2;
		int bitMask=1<<pos;
		
		if((bitMask & n)== 0)
		{
			System.out.println("Bit was zero");
		}
		else {
			System.out.println("Bit was one");
		} 
	
	        //Set Bit
			int n1=5;// 0101
			int pos1=1;
			int bitMask1=1<<pos1;
			
			int newNumber=bitMask1 | n1;
			System.out.println(newNumber);
			
			//Clear Bit
			int n2=5;// 0101
			int pos2=2;
			int bitMask2=1<<pos2;
			
			int newNumber1= ~bitMask2 & n2;
			System.out.println(newNumber1);
			
			int newNumber2;
			Scanner sc=new Scanner(System.in);
			int oper=sc.nextInt();
			int n3=5;
			int pos3=1;
			int bitMask3=1<<pos3;
			if(oper==1)
			{
				newNumber2= bitMask3 | n3;
				System.out.println(newNumber2);
			}
			else {
				newNumber2= ~(bitMask3) & n3;
				System.out.println(newNumber2);
			}
			sc.close();
	}
}
