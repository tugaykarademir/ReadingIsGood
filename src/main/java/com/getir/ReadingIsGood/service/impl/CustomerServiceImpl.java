package com.getir.ReadingIsGood.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.getir.ReadingIsGood.dto.CustomerRequestDto;
import com.getir.ReadingIsGood.dto.GeneralResponseDto;
import com.getir.ReadingIsGood.entity.CustomerEntity;
import com.getir.ReadingIsGood.repository.CustomerRepository;
import com.getir.ReadingIsGood.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	@Transactional
	public GeneralResponseDto addCustomer(CustomerRequestDto customerRequestDto) {
		CustomerEntity customerEntity = customerRequestDto.getCustomerEntity();
		GeneralResponseDto generalResponse = new GeneralResponseDto();
		
		if(isPhoneOrEmailExist(customerRequestDto.getCustomerEmail(),customerRequestDto.getCustomerPhoneNumber()) ) {
			generalResponse.setResponseMessage("Email or PhoneNumber Allready in use.");
			generalResponse.setResponseStatus("-1");
			return generalResponse;
		}
		customerEntity.setCreationDate(LocalDateTime.now());
		CustomerEntity savedCustomer = customerRepository.save(customerEntity);

		generalResponse.setResponseMessage(savedCustomer.getCustomerName() + "  successfully registered as customer");
		generalResponse.setResponseStatus("0");
		return generalResponse;
	}

	@Override
	@Transactional
	public GeneralResponseDto deleteCutomer(Long customerId) {

		customerRepository.deleteById(customerId);

		GeneralResponseDto generalResponse = new GeneralResponseDto("Customer successfully deleted. ","0");
		return generalResponse;
	}

	@Override
	public CustomerEntity getCustomerById(Long Id) {
		CustomerEntity customerEntity = customerRepository.getById(Id);
		return customerEntity;
	}

	@Override
	public List<CustomerEntity> getAllCustomer() {
		List<CustomerEntity> customerList = customerRepository.findAll();
		return customerList;
	}

	@Override
	public boolean isCustomerExist(Long customerId) {

		return customerRepository.existsById(customerId);
	}

	@Override
	public boolean isPhoneOrEmailExist(String email,String phoneNumber) {

		return customerRepository.existsByCustomerEmail(email) || customerRepository.existsByCustomerPhoneNumber(phoneNumber) ;
	}
}
