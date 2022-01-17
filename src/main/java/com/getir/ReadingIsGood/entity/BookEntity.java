package com.getir.ReadingIsGood.entity;

import java.time.LocalDateTime;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;


@Entity
@Table(name = "books")
public class BookEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long  id;
	@Basic
	@Column(name = "name",nullable = false)
	private String bookName;
	@Basic
	@Column(name = "author",nullable = false)
	private String bookAuthor;
	@Basic
	@Column(name = "isbn_number",nullable = false)
	private String bookIsbnNumber;
	@Positive(message = "The Price should be grather then zero")
	@Basic
	@Column(name="price",nullable = false)
	private Long price;
	
	@Min(value = 0,message = "Stock should be equal or grather then zero")
	@Basic
	@Column(name="stock",nullable = false)
	private int stock;
	@Basic
	@Column(name = "is_salable")
	private boolean isSalable;
	@Basic
	@Column(name = "creation_date")
	private LocalDateTime creationDate;
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getBookAuthor() {
		return bookAuthor;
	}

	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

	public String getBookIsbnNumber() {
		return bookIsbnNumber;
	}

	public void setBookIsbnNumber(String bookIsbnNumber) {
		this.bookIsbnNumber = bookIsbnNumber;
	}

	public boolean isSalable() {
		return isSalable;
	}

	public void setSalable(boolean isSalable) {
		this.isSalable = isSalable;
	}

	public LocalDateTime getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}
	

}
