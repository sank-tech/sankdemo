package com.dao;

 //  Creating DAO objects for Books class
 //This program is an integration towards accessing the objects of book class
 //this program takes input using scanner class and saves the session using hibernate 
 //and connect to hibernate 
 
 // Note: Exception handeling is been added and thread has been . 
 // 
 //@author Ramkrishna Dakwa (Great Learning FSD 10th Batch)
//@version 17.0 
  //@since 2nd April 2022 
  
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.bean.Book;

import javassist.bytecode.stackmap.BasicBlock.Catch;

public class Bookdao {
	Scanner scan = new Scanner(System.in);

	public int storeBook(Book b) {
		// creating a session in order to commit transaction adn save the data
		SessionFactory f = new Configuration().configure().addAnnotatedClass(Book.class).buildSessionFactory();
		Session s = f.openSession();
		try {
			s.beginTransaction();
			s.save(b);
			s.getTransaction().commit();
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			f.close();
			s.close();
		}
		return 0;
	}

	public int DeleteBook(int id) {
		SessionFactory f = new Configuration().configure().addAnnotatedClass(Book.class).buildSessionFactory();
		Session s = f.openSession();
		try {
			//try and catch block for handeling the skip trace error
			s.beginTransaction();
			Book b = s.get(Book.class, id);
			s.delete(b);
			s.getTransaction().commit();
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			f.close();
			s.close();
		}
		return 0;
	}

	public int UpdateBook(int id) {
		SessionFactory f = new Configuration().configure().addAnnotatedClass(Book.class).buildSessionFactory();
		Session s = f.openSession();
		try {
			//saving the input the data from the user 
			s.beginTransaction();
			Book b = s.get(Book.class, id);
			System.out.println("Enter the Book id");
			int ids = Integer.parseInt(scan.nextLine());
			System.out.println("Enter the Book name");
			String bname = scan.nextLine();
			System.out.println("Enter the Book Author");
			String Bauthor = scan.nextLine();
			System.out.println("Enter the Book description");
			String Bdiscription = scan.nextLine();
			System.out.println("Enter the Book Genre");
			String genre= scan.nextLine();
			System.out.println("Enter the Price");
			double price = Double.parseDouble(scan.nextLine()); 
			b.setId(ids);
			b.setAuthorname(Bauthor);
			b.setDescription(Bdiscription);
			b.setName(bname);
			b.setGenre(genre);
			b.setPrice(price);
			s.getTransaction().commit();
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			f.close();
			s.close();
		}
		return 0;
	}

	public List<Book> RetriveBooks() {
		SessionFactory f = new Configuration().configure().addAnnotatedClass(Book.class).buildSessionFactory();
		Session s = f.openSession();
		List<Book> bookslist = null;
		try {
			s.beginTransaction();
			bookslist = s.createQuery("from Book").list();
			s.getTransaction().commit();
			return bookslist;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			f.close();
			s.close();
		}
		return null;
	}
	
	public List<Book> ArrangeOrder(String stmt) {
		SessionFactory f = new Configuration().configure().addAnnotatedClass(Book.class).buildSessionFactory();
		Session s = f.openSession();
		List<Book> bookslist = null;
		try {
			s.beginTransaction();
			bookslist = s.createQuery(stmt).list();
			s.getTransaction().commit();
			return bookslist;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			f.close();
			s.close();
		}
		return null;
	}
	

}
