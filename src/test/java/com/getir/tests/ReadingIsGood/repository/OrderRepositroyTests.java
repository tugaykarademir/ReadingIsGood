package com.getir.tests.ReadingIsGood.repository;

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
import com.getir.ReadingIsGood.entity.BookEntity;
import com.getir.ReadingIsGood.entity.CustomerEntity;
import com.getir.ReadingIsGood.entity.OrderEntity;
import com.getir.ReadingIsGood.repository.BookRepository;
import com.getir.ReadingIsGood.repository.CustomerRepository;
import com.getir.ReadingIsGood.repository.OrderRepositrory;

@SpringBootTest(classes = ReadingIsGoodApplication.class)
@RunWith(SpringRunner.class)
public class OrderRepositroyTests {

	@Autowired
	private OrderRepositrory orderRepositroy;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private BookRepository bookRepository;
	
	
	@Test
	@Transactional
	public void saveOrderTest() {

		BookEntity bookEntity =new BookEntity();
		bookEntity.setId(1L);
		bookEntity.setBookName("Test");
		bookEntity.setBookIsbnNumber("Test");
		bookEntity.setBookAuthor("test");
		bookEntity.setPrice(100L);
		bookEntity.setStock(10);
		bookEntity.setSalable(true);
		bookEntity.setCreationDate(LocalDateTime.now());
		bookRepository.save(bookEntity);
		
		CustomerEntity customerEntity =new CustomerEntity();	
		customerEntity.setCustomerId(1L);
		customerEntity.setCustomerName("getir");
		customerEntity.setCustomerPhoneNumber("111");
		customerEntity.setCustomerSurname("mutluluk");
		customerEntity.setCustomerEmail("getir@getir.com");
		customerEntity.setCustomerAddress("Istanbul");
		customerEntity.setCreationDate(LocalDateTime.now());
		customerRepository.save(customerEntity);
		
		OrderEntity entity =new OrderEntity();
		entity.setOrderId(1L);
		entity.setCustomerId(1L);
		entity.setBookId(1L);
		entity.setCreationDate(LocalDateTime.now());
	
		
		orderRepositroy.save(entity);
		OrderEntity result = orderRepositroy.getById(entity.getOrderId());
		
		Assert.assertTrue(result.getOrderId()==entity.getOrderId());
		

	}
	
	@Test
	@Transactional
	public void getOrdersByCustomerTest() {
		

		BookEntity bookEntity =new BookEntity();
		bookEntity.setId(1L);
		bookEntity.setBookName("Test");
		bookEntity.setBookIsbnNumber("Test");
		bookEntity.setBookAuthor("test");
		bookEntity.setPrice(100L);
		bookEntity.setStock(10);
		bookEntity.setSalable(true);
		bookEntity.setCreationDate(LocalDateTime.now());
		bookRepository.save(bookEntity);
		
		BookEntity bookEntity2 =new BookEntity();
		bookEntity2.setId(2L);
		bookEntity2.setBookName("Test2");
		bookEntity2.setBookIsbnNumber("Test2");
		bookEntity2.setBookAuthor("test2");
		bookEntity2.setPrice(100L);
		bookEntity2.setStock(10);
		bookEntity2.setSalable(true);
		bookEntity2.setCreationDate(LocalDateTime.now());
		bookRepository.save(bookEntity2);
		
		CustomerEntity customerEntity =new CustomerEntity();	
		customerEntity.setCustomerId(1L);
		customerEntity.setCustomerName("getir");
		customerEntity.setCustomerPhoneNumber("111");
		customerEntity.setCustomerSurname("mutluluk");
		customerEntity.setCustomerEmail("getir@getir.com");
		customerEntity.setCustomerAddress("Istanbul");
		customerEntity.setCreationDate(LocalDateTime.now());
		customerRepository.save(customerEntity);
		
		OrderEntity entity =new OrderEntity();
		entity.setOrderId(1L);
		entity.setCustomerId(1L);
		entity.setBookId(1L);
		entity.setCreationDate(LocalDateTime.now());
		orderRepositroy.save(entity);
		
		OrderEntity entity2 =new OrderEntity();
		entity.setOrderId(2L);
		entity.setCustomerId(1L);
		entity.setBookId(2L);
		entity.setCreationDate(LocalDateTime.now());
		orderRepositroy.save(entity);
		
		List<OrderEntity>  result = orderRepositroy.findAllByCustomerId(customerEntity.getCustomerId());
		
		Assert.assertTrue(result.size()==2 && result.get(0).getCustomerId()==customerEntity.getCustomerId());
		

	}
}
