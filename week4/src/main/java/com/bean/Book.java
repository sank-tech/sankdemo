package com.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/** 
 * Creating Setters and getters objects for Books class 
 * This program is an integration towards accessing the objects of book class
 * this program is forming getters and setters in terms of POJO class and to ensure safety 
 * 
 * Note: Getters and Setters have been generated generated and to string method is used to overide the method. 
 *  
 * @author Ramkrishna Dakwa (Great Learning FSD 10th Batch)
 * @version 17.0 
 * @since 2nd April 2022 
 */
@Entity
@Table(name="MagicBooks")
public class Book {
	@Id
	private int id;
	private String name;
	private String authorname;
	private String description;
	private String genre;
	private double Price;
	public Book() {
		
	}
	public Book(int id,String name, String authorname, double price,String description,String genre) {
		super();
		this.id=id;
		this.name = name;
		this.authorname = authorname;
		this.description = description;
		this.genre =genre;
		this.Price =price;
	}
	
	public double getPrice() {
		return Price;
	}
	public void setPrice(double price) {
		Price = price;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthorname() {
		return authorname;
	}
	public void setAuthorname(String authorname) {
		this.authorname = authorname;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", authorname=" + authorname + ", description=" + description
				+ ", genre=" + genre + ", Price=" + Price + "]";
	}
	
	
	
	

}
