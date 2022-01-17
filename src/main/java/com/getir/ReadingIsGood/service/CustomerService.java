package com.getir.ReadingIsGood.service;

import java.util.List;

import com.getir.ReadingIsGood.dto.CustomerRequestDto;
import com.getir.ReadingIsGood.dto.GeneralResponseDto;
import com.getir.ReadingIsGood.entity.CustomerEntity;

public interface CustomerService {
	public GeneralResponseDto addCustomer(CustomerRequestDto customerRequestDto) ;

	public GeneralResponseDto deleteCutomer(Long customerId);

	public CustomerEntity getCustomerById(Long Id);

	public List<CustomerEntity> getAllCustomer();

	public boolean isCustomerExist(Long customerId);
	
	public boolean isPhoneOrEmailExist(String email,String phoneNumber);
}
