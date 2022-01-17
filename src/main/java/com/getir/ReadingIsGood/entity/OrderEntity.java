package com.getir.ReadingIsGood.entity;


import java.time.LocalDateTime;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="orders")
public class OrderEntity {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long orderId;
	
	@Basic
	@Column(name = "customer_id",nullable = false)
	private Long customerId;
	
	@Basic
	@Column(name = "book_id",nullable = false)
	private Long bookId;
	@Basic
	@Column(name = "creation_date")
	private LocalDateTime creationDate;
	
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
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
	@Override
	public String toString() {
		return "OrderEntity [orderId=" + orderId + ", customerId=" + customerId + ", bookId=" + bookId
				+ ", creationDate=" + creationDate + "]";
	}

	
}
