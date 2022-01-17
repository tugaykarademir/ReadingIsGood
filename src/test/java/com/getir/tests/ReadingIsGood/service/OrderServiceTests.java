package com.getir.tests.ReadingIsGood.service;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.jaxb.SpringDataJaxb.OrderDto;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.getir.ReadingIsGood.ReadingIsGoodApplication;
import com.getir.ReadingIsGood.dto.CustomerRequestDto;
import com.getir.ReadingIsGood.dto.GeneralResponseDto;
import com.getir.ReadingIsGood.dto.OrderRequestDto;
import com.getir.ReadingIsGood.entity.BookEntity;
import com.getir.ReadingIsGood.entity.CustomerEntity;
import com.getir.ReadingIsGood.entity.OrderEntity;
import com.getir.ReadingIsGood.repository.BookRepository;
import com.getir.ReadingIsGood.repository.CustomerRepository;
import com.getir.ReadingIsGood.repository.OrderRepositrory;
import com.getir.ReadingIsGood.service.CustomerService;
import com.getir.ReadingIsGood.service.OrderService;

@SpringBootTest(classes = ReadingIsGoodApplication.class)
@RunWith(SpringRunner.class)
public class OrderServiceTests {
	@Autowired
	private OrderRepositrory orderRepository;

	@Autowired
	private OrderService orderService;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private BookRepository bookRepository;
	
	@Test
	@Transactional
	public void addOrderServiceTest() {

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
		
		OrderRequestDto orderRequestDto = new OrderRequestDto();
		orderRequestDto.setBookId(1L);
		orderRequestDto.setId(1L);
		orderRequestDto.setCustomerId(1L);
		orderRequestDto.setCreationDate(LocalDateTime.now());

		
		orderService.addOrder(orderRequestDto);
		boolean result = orderRepository.existsByOrderId(orderRequestDto.getId());
	
		Assert.assertTrue(result);

	}

	
	@Test
	@Transactional
	public void deleteOrderServiceTest() {

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
		
		
		OrderRequestDto orderRequestDto = new OrderRequestDto();
		orderRequestDto.setBookId(1L);
		orderRequestDto.setId(1L);
		orderRequestDto.setCustomerId(1L);
		orderRequestDto.setCreationDate(LocalDateTime.now());

		
		orderService.addOrder(orderRequestDto);
		orderService.deleteOrder(orderRequestDto.getId());
		boolean result = orderRepository.existsByOrderId(orderRequestDto.getId());
	

		Assert.assertFalse(result);

	}
	
	@Test
	@Transactional
	public void getOrderByIdServiceTest() {
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
		
		
		OrderRequestDto orderRequestDto = new OrderRequestDto();
		orderRequestDto.setBookId(1L);
		orderRequestDto.setId(1L);
		orderRequestDto.setCustomerId(1L);
		orderRequestDto.setCreationDate(LocalDateTime.now());

		
		orderService.addOrder(orderRequestDto);
		
		OrderEntity result = orderRepository.findByOrderId(orderRequestDto.getId());
	

		Assert.assertTrue(result.getOrderId() == orderRequestDto.getId());

	}
	
	@Test
	@Transactional
	public void getAllOrdersServiceTest() {
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
	
		
		OrderRequestDto orderRequestDto = new OrderRequestDto();
		orderRequestDto.setBookId(1L);
		orderRequestDto.setId(1L);
		orderRequestDto.setCustomerId(1L);
		orderRequestDto.setCreationDate(LocalDateTime.now());
		orderService.addOrder(orderRequestDto);
		
		OrderRequestDto orderRequestDto2 = new OrderRequestDto();
		orderRequestDto2.setBookId(2L);
		orderRequestDto2.setId(2L);
		orderRequestDto2.setCustomerId(1L);
		orderRequestDto2.setCreationDate(LocalDateTime.now());

		orderService.addOrder(orderRequestDto2);
		
		List<OrderEntity> result = orderService.getAllOrders();
	

		Assert.assertTrue(result.size()==2 && result.get(0).getCustomerId()==customerEntity.getCustomerId());

	}
	@Test
	@Transactional
	public void getCustomerOrdersServiceTest() {
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
		
		
		OrderRequestDto orderRequestDto = new OrderRequestDto();
		orderRequestDto.setBookId(1L);
		orderRequestDto.setId(1L);
		orderRequestDto.setCustomerId(1L);
		orderRequestDto.setCreationDate(LocalDateTime.now());

		
		orderService.addOrder(orderRequestDto);
		
		List<OrderEntity> result = orderService.getCustomerOrders(customerEntity.getCustomerId());
	
		Assert.assertTrue(result.get(0).getCustomerId() == customerEntity.getCustomerId());

	}
/*

	public boolean isBookAndCustomerExist(OrderRequestDto orderRequestDto);
	
	public List<OrderEntity> getOrdersByDateInterval(Date startDate,Date endDate);
	*/
	
    public boolean doesRecordExist(String id){

    return id!=null;

    }

}
