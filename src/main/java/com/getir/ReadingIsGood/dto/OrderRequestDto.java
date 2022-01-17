package com.getir.ReadingIsGood.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;

public class OrderRequestDto {

	private Long id;
	
	@NotNull(message = "The customerId can not be null")
	private Long customerId;
	
	@NotNull(message = "The customerId can not be null")
	private Long bookId;
	
	private LocalDateTime creationDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public Long getBookId() {
		return bookId;
	}

	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}

	public LocalDateTime getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}

}
