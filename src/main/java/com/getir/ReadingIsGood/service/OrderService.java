package com.getir.ReadingIsGood.service;

import java.sql.Date;
import java.util.List;

import com.getir.ReadingIsGood.dto.GeneralResponseDto;
import com.getir.ReadingIsGood.dto.OrderRequestDto;
import com.getir.ReadingIsGood.entity.OrderEntity;

public interface OrderService {
	public GeneralResponseDto addOrder(OrderRequestDto orderRequestDto);

	public GeneralResponseDto deleteOrder(Long orderId);

	public OrderEntity getOrderById(Long Id);

	public List<OrderEntity> getAllOrders();
	
	public List<OrderEntity> getCustomerOrders(Long customerId);

	public boolean isBookAndCustomerExist(OrderRequestDto orderRequestDto);
	
	public List<OrderEntity> getOrdersByDateInterval(Date startDate,Date endDate);
}
