package com.getir.ReadingIsGood.service.impl;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.getir.ReadingIsGood.dto.GeneralResponseDto;
import com.getir.ReadingIsGood.dto.OrderRequestDto;
import com.getir.ReadingIsGood.entity.OrderEntity;
import com.getir.ReadingIsGood.repository.OrderRepositrory;
import com.getir.ReadingIsGood.service.BookService;
import com.getir.ReadingIsGood.service.CustomerService;
import com.getir.ReadingIsGood.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepositrory orderRepositrory;

	@Autowired
	private BookService bookService;

	@Autowired
	private CustomerService customerService;

	@Override
	@Transactional
	public GeneralResponseDto addOrder(OrderRequestDto orderRequestDto) {
		OrderEntity orderEntity = new OrderEntity();

		if(!isBookAndCustomerExist(orderRequestDto)) {
			GeneralResponseDto generalResponse = new GeneralResponseDto("Customer or Book Does not exist. Order could not added.","0");
			return generalResponse;
		}
		orderEntity.setBookId(orderRequestDto.getBookId());
		orderEntity.setCustomerId(orderRequestDto.getCustomerId());
		orderEntity.setCreationDate(LocalDateTime.now());
		orderRepositrory.save(orderEntity);
		bookService.decreaseBookStock(orderRequestDto.getBookId());
			
		GeneralResponseDto generalResponse = new GeneralResponseDto("order successfully added.","0");
		return generalResponse;
	}

	@Override
	@Transactional
	public GeneralResponseDto deleteOrder( Long orderId) {
		orderRepositrory.deleteById(orderId);
		GeneralResponseDto generalResponse = new GeneralResponseDto("order successfully deleted.","0");

		return generalResponse;
	}

	@Override
	@Transactional
	public OrderEntity getOrderById(Long Id) {
		OrderEntity orderEntity = orderRepositrory.getById(Id);
		return orderEntity;
	}

	@Override
	@Transactional
	public List<OrderEntity> getAllOrders() {
		List<OrderEntity> orderList = orderRepositrory.findAll();

		return orderList;
	}

	@Override
	@Transactional
	public boolean isBookAndCustomerExist(OrderRequestDto orderRequestDto) {

		return bookService.isBookExist(orderRequestDto.getBookId())&& customerService.isCustomerExist(orderRequestDto.getCustomerId());
	}
	
	@Override
	public List<OrderEntity> getCustomerOrders(Long customerId){
		return orderRepositrory.findAllByCustomerId(customerId);
	}

	@Override
	public List<OrderEntity> getOrdersByDateInterval(Date startDate,Date endDate) {
		return orderRepositrory.findAllByCreationDateBetween(startDate,endDate);
	}
}
