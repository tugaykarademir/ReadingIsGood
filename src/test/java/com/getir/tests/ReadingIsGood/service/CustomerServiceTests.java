package com.getir.tests.ReadingIsGood.service;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.getir.ReadingIsGood.ReadingIsGoodApplication;
import com.getir.ReadingIsGood.dto.CustomerRequestDto;
import com.getir.ReadingIsGood.entity.CustomerEntity;
import com.getir.ReadingIsGood.repository.CustomerRepository;
import com.getir.ReadingIsGood.service.CustomerService;

@SpringBootTest(classes = ReadingIsGoodApplication.class)
@RunWith(SpringRunner.class)
public class CustomerServiceTests {

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private CustomerService customerService;

	@Test
	@Transactional
	public void addCustomerServiceTest() {

		CustomerRequestDto customerRequestDto = new CustomerRequestDto();

		customerRequestDto.setId(1L);
		customerRequestDto.setCustomerName("getir");
		customerRequestDto.setCustomerEmail("getir@getir.com");
		customerRequestDto.setCustomerPhoneNumber("111");
		customerRequestDto.setCustomerSurname("mutluluk");
		customerRequestDto.setCustomerAddress("Istanbul");
		customerRequestDto.setCreationDate(LocalDateTime.now());

		customerService.addCustomer(customerRequestDto);

		CustomerEntity result = customerRepository.getById(customerRequestDto.getId());

		Assert.assertTrue(result.getCustomerId() == customerRequestDto.getId());

	}

	@Test
	@Transactional
	public void deleteCutomerServiceTest() {

		CustomerEntity entity = new CustomerEntity();

		entity.setCustomerId(1L);
		entity.setCustomerName("getir");
		entity.setCustomerPhoneNumber("111");
		entity.setCustomerSurname("mutluluk");
		entity.setCustomerEmail("getir@getir.com");
		entity.setCustomerAddress("Istanbul");
		entity.setCreationDate(LocalDateTime.now());
		customerRepository.save(entity);
		
		customerService.deleteCutomer(entity.getCustomerId());

		

		boolean result = customerRepository.existsByCustomerId(entity.getCustomerId());

		Assert.assertFalse(result);

	}
	
	@Test
	@Transactional
	public void getCutomerServiceTest() {


		CustomerEntity entity = new CustomerEntity();

		entity.setCustomerId(1L);
		entity.setCustomerName("getir");
		entity.setCustomerPhoneNumber("111");
		entity.setCustomerSurname("mutluluk");
		entity.setCustomerEmail("getir@getir.com");
		entity.setCustomerAddress("Istanbul");
		entity.setCreationDate(LocalDateTime.now());
		customerRepository.save(entity);

		CustomerEntity result = customerService.getCustomerById(entity.getCustomerId());

		Assert.assertTrue(entity.getCustomerId() == result.getCustomerId());

	}
	
	@Test
	@Transactional
	public void getAllCutomerServiceTest() {


		CustomerEntity entity = new CustomerEntity();

		entity.setCustomerId(1L);
		entity.setCustomerName("getir");
		entity.setCustomerPhoneNumber("111");
		entity.setCustomerSurname("mutluluk");
		entity.setCustomerEmail("getir@getir.com");
		entity.setCustomerAddress("Istanbul");
		entity.setCreationDate(LocalDateTime.now());
		customerRepository.save(entity);
		
		entity.setCustomerId(2L);
		entity.setCustomerName("getir2");
		entity.setCustomerPhoneNumber("1112");
		entity.setCustomerSurname("mutluluk2");
		entity.setCustomerEmail("getir2@getir.com");
		entity.setCustomerAddress("Istanbul2");
		entity.setCreationDate(LocalDateTime.now());
		customerRepository.save(entity);

		List<CustomerEntity> result = customerService.getAllCustomer();

		Assert.assertTrue(2 == result.size() && entity.getCustomerId() == result.get(0).getCustomerId());

	}
	
	@Test
	@Transactional
	public void isPhoneOrEmailExistServiceTest() {


		CustomerEntity entity = new CustomerEntity();

		entity.setCustomerId(1L);
		entity.setCustomerName("getir");
		entity.setCustomerPhoneNumber("111");
		entity.setCustomerSurname("mutluluk");
		entity.setCustomerEmail("getir@getir.com");
		entity.setCustomerAddress("Istanbul");
		entity.setCreationDate(LocalDateTime.now());
		customerRepository.save(entity);
		
		entity.setCustomerId(2L);
		entity.setCustomerName("getir2");
		entity.setCustomerPhoneNumber("1112");
		entity.setCustomerSurname("mutluluk2");
		entity.setCustomerEmail("getir2@getir.com");
		entity.setCustomerAddress("Istanbul2");
		entity.setCreationDate(LocalDateTime.now());
		customerRepository.save(entity);

		boolean result = customerService.isPhoneOrEmailExist("getir2@getir.com", "111");

		Assert.assertTrue(result == true);

	}
}
