package com.getir.ReadingIsGood.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.getir.ReadingIsGood.entity.BookEntity;

public class BookRequestDto {
	private Long id;
	
	@NotNull(message = "The Book name can not be null")
	@NotBlank(message = "The Book name can not be empty")
	private String bookName;
	
	@NotNull(message = "The Book author can not be null")
	@NotBlank(message = "The Book author can not be empty")
	private String bookAuthor;
	
	@NotNull(message = "The Book isbn Number can not be null")
	@NotBlank(message = "The Book isbn Number can not be empty")
	private String bookIsbnNumber;
	
	@NotNull(message = "The Book price can not be null")
	@Positive(message = "The Book Price shoul be grather then zero")
	private Long price;
	
	@NotNull(message = "The Book stock can not be null")
	@Min(value = 1,message = "Stock should be equal or grather then zero")
	private int stock;

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

	@JsonIgnore
	public BookEntity getBookEntity() {
		BookEntity bookEntity = new BookEntity();
		bookEntity.setBookAuthor(getBookAuthor());
		bookEntity.setBookIsbnNumber(getBookIsbnNumber());
		bookEntity.setBookName(getBookName());
		bookEntity.setPrice(getPrice());
		bookEntity.setStock(getStock());
		return bookEntity;
	}
	
}
