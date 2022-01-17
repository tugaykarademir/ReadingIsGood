package com.getir.ReadingIsGood.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.getir.ReadingIsGood.entity.CustomerEntity;


public class CustomerRequestDto {
	private long id;
	@NotNull(message = "The Customer name can not be null")
	@NotBlank(message = "The Customer name can not be empty")
	private String customerName;
	@NotNull(message = "The Customer surname can not be null")
	@NotBlank(message = "The Customer surname can not be empty")
	private String customerSurname;
	@NotNull(message = "The Customer phonenumber can not be null")
	@NotBlank(message = "The Customer phonenumber can not be empty")
	private String customerPhoneNumber;
	@NotNull(message = "The Customer email can not be null")
	@NotBlank(message = "The Customer email can not be empty")
	@Email(message = "Email Should be valid")
	private String customerEmail;
	@NotNull(message = "The Customer address can not be null")
	@NotBlank(message = "The Customer address can not be empty")
	private String customerAddress;
	private LocalDateTime creationDate;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerSurname() {
		return customerSurname;
	}
	public void setCustomerSurname(String customerSurname) {
		this.customerSurname = customerSurname;
	}
	public String getCustomerPhoneNumber() {
		return customerPhoneNumber;
	}
	public void setCustomerPhoneNumber(String customerPhoneNumber) {
		this.customerPhoneNumber = customerPhoneNumber;
	}
	public String getCustomerEmail() {
		return customerEmail;
	}
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}
	public String getCustomerAddress() {
		return customerAddress;
	}
	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}
	public LocalDateTime getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}
	
	@JsonIgnore
	public CustomerEntity getCustomerEntity() {
		CustomerEntity customerEntity =new CustomerEntity();
		customerEntity.setCustomerName(getCustomerName());
		customerEntity.setCustomerPhoneNumber(getCustomerPhoneNumber());
		customerEntity.setCustomerSurname(getCustomerSurname());
		customerEntity.setCustomerEmail(getCustomerEmail());
		customerEntity.setCustomerAddress(getCustomerAddress());
		return customerEntity;
	}
	
}
