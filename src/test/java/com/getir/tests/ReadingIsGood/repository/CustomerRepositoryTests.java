package com.getir.tests.ReadingIsGood.repository;

import java.time.LocalDateTime;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.getir.ReadingIsGood.ReadingIsGoodApplication;
import com.getir.ReadingIsGood.entity.CustomerEntity;
import com.getir.ReadingIsGood.repository.CustomerRepository;

@SpringBootTest(classes = ReadingIsGoodApplication.class)
@RunWith(SpringRunner.class)
public class CustomerRepositoryTests {
	@Autowired
	private CustomerRepository customerRepository;
	
	
	@Test
	@Transactional
	public void saveCustomerTest() {
		
		CustomerEntity entity =new CustomerEntity();
		
		entity.setCustomerId(1L);
		entity.setCustomerName("getir");
		entity.setCustomerPhoneNumber("111");
		entity.setCustomerSurname("mutluluk");
		entity.setCustomerEmail("getir@getir.com");
		entity.setCustomerAddress("Istanbul");
		entity.setCreationDate(LocalDateTime.now());
	
		
		customerRepository.save(entity);
		CustomerEntity result = customerRepository.getById(entity.getCustomerId());
		
		Assert.assertTrue(result.getCustomerId()==entity.getCustomerId());
		

	}
	



	//public boolean isCustomerExist(Long customerId);
	
	@Test
	@Transactional
	public void getCustomerByIdTest() {
		
		CustomerEntity entity =new CustomerEntity();
		
		entity.setCustomerId(1L);
		entity.setCustomerName("getir");
		entity.setCustomerPhoneNumber("111");
		entity.setCustomerSurname("mutluluk");
		entity.setCustomerEmail("getir@getir.com");
		entity.setCustomerAddress("Istanbul");
		entity.setCreationDate(LocalDateTime.now());
	
		
		customerRepository.save(entity);
		CustomerEntity result = customerRepository.getById(entity.getCustomerId());
		
		Assert.assertTrue(result.getCustomerId()==entity.getCustomerId());
		

	}
	@Test
	@Transactional
	public void deleteCutomerTest() {
		
		CustomerEntity entity =new CustomerEntity();
		
		entity.setCustomerId(1L);
		entity.setCustomerName("getir");
		entity.setCustomerPhoneNumber("111");
		entity.setCustomerSurname("mutluluk");
		entity.setCustomerEmail("getir@getir.com");
		entity.setCustomerAddress("Istanbul");
		entity.setCreationDate(LocalDateTime.now());
		customerRepository.save(entity);
		customerRepository.deleteById(entity.getCustomerId());
		
		boolean isExists =customerRepository.existsById(entity.getCustomerId());
		
		Assert.assertTrue(isExists==false);
		

	}
	
	@Test
	@Transactional
	public void existsByCustomerEmailTest() {
		
		CustomerEntity entity =new CustomerEntity();
		
		entity.setCustomerId(1L);
		entity.setCustomerName("getir");
		entity.setCustomerPhoneNumber("111");
		entity.setCustomerSurname("mutluluk");
		entity.setCustomerEmail("getir@getir.com");
		entity.setCustomerAddress("Istanbul");
		entity.setCreationDate(LocalDateTime.now());
		customerRepository.save(entity);
		
		boolean isExists =customerRepository.existsByCustomerEmail(entity.getCustomerEmail());
		
		Assert.assertTrue(isExists==true);
		

	}
	
	@Test
	@Transactional
	public void existsByCustomerPhoneNumberTest() {
		
		CustomerEntity entity =new CustomerEntity();
		
		entity.setCustomerId(1L);
		entity.setCustomerName("getir");
		entity.setCustomerPhoneNumber("111");
		entity.setCustomerSurname("mutluluk");
		entity.setCustomerEmail("getir@getir.com");
		entity.setCustomerAddress("Istanbul");
		entity.setCreationDate(LocalDateTime.now());
		customerRepository.save(entity);
		
		boolean isExists =customerRepository.existsByCustomerPhoneNumber(entity.getCustomerPhoneNumber());
		
		Assert.assertTrue(isExists==true);
		

	}
	
}
