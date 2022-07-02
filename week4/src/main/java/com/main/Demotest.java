package com.main;

 import java.nio.file.AccessDeniedException;

//Creating a recursive menu for user
 // This program is an integration towards accessing the different options of book class
// this program uses while loop and switch case and is connected to DAO classes
 
 // Note: Exception handeling is been added and thread has been .
 // custom exception has been added below 
   
 // @author Ramkrishna Dakwa (Great Learning FSD 10th Batch)
 // @version 17.0 
 // @since 2nd April 2022 
 

import java.util.Scanner;
import java.util.Spliterators;

import org.hibernate.exception.spi.AbstractSQLExceptionConversionDelegate;

import com.bean.Book;
import com.service.Bookservice;

public class Demotest {
	public static void main(String[] args) throws AccessDeniedException {
		Bookservice bs = new Bookservice();
		
		Scanner scan = new Scanner(System.in);
		try {
			//try block for custom exception faced by the user
		
		int choice;
		String con;
		//using a do while loop with switch case for an interactive menu
		System.out.println("Please enter your Role (Admin/User)");
		String use = scan.nextLine();
		String use2="Admin";
		if (use.equalsIgnoreCase(use2)) {
			do {
				System.out.println("1:Add Books\n"+"2.Delete Books\n"+
									"3.UpdateBooks\n"+"4.Display all the Books\n"+
									"5.Total count Of Books\n"+"6.Books under Autobiography genre\n"+"7.Arrange in Order\n"+
									"Enter your Choice");
				 choice = Integer.parseInt(scan.nextLine());
				switch(choice) {
				case 1:
					Book b = bs.insertBook();
					System.out.println(bs.storeBook(b));
					break;
				case 2:
					System.out.println(bs.deleteBook());
					break;
				case 3:
					System.out.println(bs.UpdateBook());
					break;
				case 4:
					System.out.println(bs.Displayall());
					break;
				case 5:
					System.out.println(bs.CountBooks());
					break;
				case 6:
					bs.DisplayallbyType();
					break;
				case 7:
					bs.Arrange();
					break;
					
				default:
					break;

				
					
				}
				System.out.println("do you want to Continue ?(y/n)");
				con=scan.nextLine();
			}while(con.equals("y"));
			
			
		}
		else if (use.compareTo(use2)!=0) {
			System.out.println("Invalid Role");
			System.out.println("Plese ReEnter");
		}
		
		
		
		
		
	
	} 
		catch (ArithmeticException e) {
			// custom exception if user enters the option of more than 5
		System.out.println("please choose a option between option 1 to 5");
	}
		catch (AbstractMethodError e) {
			// custom exception if the menu is taking long time to respond
			System.out.println("the menu is not working please try again");
		}

}}

