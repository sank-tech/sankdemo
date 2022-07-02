package com.service;
// Creating a recursive menu for user


 //This program is an integration towards accessing the different options of book class
 // this program uses while loop and switch case and is connected to DAO classes
  
 // Note: Exception handeling is been added and thread has been . 
   
 // @author Anshika Singh (Great Learning FSD C - 7th Batch)
 //@version 17.0 
 // @since 2nd April 2022 
 
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.bean.Book;
import com.dao.Bookdao;

public class Bookservice {
	Scanner scan = new Scanner(System.in);
	//taking input from the user by using DAO manpiulation
	public Book insertBook() {
		System.out.println("Enter the Book Id");
		int id = Integer.parseInt(scan.nextLine());
		System.out.println("Enter the Bookname");
		String bname = scan.nextLine();
		System.out.println("Enter the BookAuthor");
		String bauthor = scan.nextLine();
		System.out.println("Enter the description");
		String bdescription = scan.nextLine();
		System.out.println("Enter the Book Price");
		double price = Double.parseDouble(scan.nextLine());
		System.out.println("Enter the Book Genre");
		String genre= scan.nextLine();
		Book book = new Book(id, bname, bauthor, price, bdescription, genre);
		return book;
	}
	// a DAO class object for user to check if book data stored successfully 
	public String storeBook(Book b) {
		Bookdao bdao = new Bookdao();
		if (bdao.storeBook(b) > 0) {
			return "Record Inserted Sucessfully";
		} else {
			return "Recod dint't store";
		}
	} 
	// a DAO class object for deleting a book

	public String deleteBook() {
		System.out.println("Enter the ID of the Book");
		int id = Integer.parseInt(scan.nextLine());
		Bookdao bdao = new Bookdao();
		if (bdao.DeleteBook(id) > 0) {
			return "Record Deleted Sucessfully";
		} else {
			return "Record Not Deleted";
		}
	}
	//A DAO class object for updating the book
	public String UpdateBook() {
		System.out.println("Enter the id Of the Book");
		int id = Integer.parseInt(scan.nextLine());
		Bookdao bdao = new Bookdao();
		if (bdao.UpdateBook(id) > 0) {
			return "Updated Sucessful";
		} else {
			return "Update UnSuccessful";
		}
	}
	// a DAO class object for display of data
	public String Displayall() {
		Bookdao bdao = new Bookdao();
		if (!bdao.RetriveBooks().isEmpty()) {
			List<Book> bookslist = bdao.RetriveBooks();
			System.out.println("=====================================================================================");
			for (Book book : bookslist) {
				System.out.println(book);
			}
			System.out.println("=====================================================================================");

			return "Successfully retrived";
		} else {
			return "Sorry UnSucessFul";
		}
	}

	public String CountBooks() {
		Bookdao bdao = new Bookdao();
		if (!bdao.RetriveBooks().isEmpty()) {
			System.out.println("TOTAL BOOKS :" + bdao.RetriveBooks().size());
			return "Successfully retrived";
		} else {
			return "Sorry UnSucessFul";
		}
	}

	public void Arrange() {
		Bookdao bdao = new Bookdao();
		int choice;
		List<Book> booklist = null;
		String con;
		String s;
		System.out.println("1:Price - Low to High\n" + "2.Price - High to Low");
		choice = Integer.parseInt(scan.nextLine());
		if (choice>0 && choice<=2){
			switch (choice) {
			case 1:
				 s = "from Book order by Price";
				booklist = bdao.ArrangeOrder(s);
				System.out.println("=============================================================");
				for (Book book : booklist) {
					System.out.println(book);
				}
				System.out.println("=============================================================");
				break;
			case 2:
				 s = "from Book order by Price desc";
				booklist = bdao.ArrangeOrder(s);
				System.out.println("=============================================================");
				for (Book book : booklist) {
					System.out.println(book);
				}
				System.out.println("=============================================================");
				break;
			default:
				System.out.println("Wrong Input");
			}
		}

	}
	public String DisplayallbyType() {
		Bookdao bdao = new Bookdao();
		if (!bdao.RetriveBooks().isEmpty()) {
			List<Book> bookslist = bdao.RetriveBooks();
			System.out.println("=====================================================================================");
			for (Book book : bookslist) {
				if(book.getGenre().equalsIgnoreCase("Autobiography")) {
					System.out.println(book);
				}
			}
			System.out.println("=====================================================================================");

			return "Successfully retrived";
		} else {
			return "Sorry UnSucessFul";
		}
	}
	

}
