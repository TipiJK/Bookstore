package com.example.Bookstore.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Book {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String title, author, isbn;
	private double price;
	private int bookYear;
	
	@ManyToOne
	@JoinColumn(name="catid")
	private Category category;
	
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
/*	public Book(String title, String author, String isbn, double price, int bookYear) {
		super();
		this.title = title;
		this.author = author;
		this.isbn = isbn;
		this.price = price;
		this.bookYear = bookYear;

	}*/
	public Book(String title, String author, String isbn, double price, int bookYear, Category category) {
		super();
		this.title = title;
		this.author = author;
		this.isbn = isbn;
		this.price = price;
		this.bookYear = bookYear;
		this.category = category;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getBookYear() {
		return bookYear;
	}
	public void setBookYear(int bookYear) {
		this.bookYear = bookYear;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + ", isbn=" + isbn + ", price=" + price
				+ ", bookYear=" + bookYear + "]";
	}

}
