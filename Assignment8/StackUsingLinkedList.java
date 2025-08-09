/*
Program to Implement Stack using linked list with a menu driven program
Menu:
1: PUSH
2: POP
3: PEEK(displays top element)
4: Display no. of elements
5. Exit
Author: Akshay Basak
Date: 10-07-2025
*/
package Assignment8;

import java.util.Scanner;
//Stack class using Linked List
class Stack
{
	Node top;
	// Inner class for Node
	class Node
	{
		int data;
		Node next;
		
		Node(int data)
		{
			this.data = data;
			this.next =null;
		}
	}
	
	// Constructor
   Stack() {
       this.top = null;
   }
   // Push method
	public void Push(int data)
	{
		Node temp = new Node(data);
		temp.next = null;
		
		if(top == null)
		{
			temp.next = null;
			top = temp;
		}
		else
		{
			temp.next = top;
			top = temp;
		}
		System.out.println("Pushed: " + data);
	}
	
	// Pop method
	public int Pop()
	{
		if(top == null)
		{
			System.out.println("\nStack is Empty!");
			return -1;
		}
		else
		{
			int data = top.data;
			top = top.next;
			return data;
		}
	}
	
	// Peek method
	public int Peek()
	{
		if(top == null)
		{
			System.out.println("\nStack is Empty!");
			return -1;
		}
		else {
			return top.data;
		}
	}
	
	public int items() {        //Display the number of items present in the stack
       int n=0;
       Node temp = top;
       while(temp!=null) {
           n++;
           temp = temp.next;
       }
       return n;
   }
}
public class StackUsingLinkedList {
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Stack stk = new Stack();
		int n,choice;
		
		while(true)
		{
			  System.out.println("=============================================");
		      System.out.println(" WELCOME TO STACK OPERATIONS ");
		      System.out.println("=============================================");
			System.out.println("\n 1.PUSH");
			System.out.println("\n 2.POP");
			System.out.println("\n 3.PEEK");
			System.out.println("\n 4.Display no. of elements");
			System.out.println("\n 5.EXIT");
			
			System.out.println("\n Enter your choice that you want to perform from the menu : ");
			choice = sc.nextInt();
			
			switch(choice)
			{
			case 1:
				System.out.print("Enter number to push: ");
               n = sc.nextInt();
				stk.Push(n);
				break;
			case 2:
				n = stk.Pop();
				
				if(n!= -1)
				{	
				    System.out.println("\n The value deleted from the stack is : "+ n);
				}
				break;
			case 3:
				n = stk.Peek();
				
				if(n!= -1)
				{	
				    System.out.println("\n The value stored at top of stack is : "+n);
				}
				break;
			case 4:     //Display number of elements
               System.out.println("Number of element in Stack is : "+stk.items());
               break;	
			case 5:
				System.out.println("Exiting!!!");
				sc.close();
				return ;
			default:
				System.out.println("Invalid Input!!!!");			
			}
		}
	}
    // This main method provides a menu-driven interface for stack operations using a linked list.
    // It allows the user to push, pop, peek, and display the number of elements in the stack.
    // The stack is implemented using an inner Node class to represent each element.
}
