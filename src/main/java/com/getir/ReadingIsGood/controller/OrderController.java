package com.getir.ReadingIsGood.controller;


import java.sql.Date;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.getir.ReadingIsGood.dto.GeneralResponseDto;
import com.getir.ReadingIsGood.dto.OrderRequestDto;
import com.getir.ReadingIsGood.entity.OrderEntity;
import com.getir.ReadingIsGood.service.OrderService;

@Controller
@RequestMapping(value = "/order")
public class OrderController {
	private static final Logger logger = LoggerFactory.getLogger(OrderController.class);
	@Autowired
	private OrderService orderService;

	@RequestMapping(method = RequestMethod.POST, value = "/addOrder", produces = "application/json", consumes = "application/json")
	public ResponseEntity<String> addOrder(@Valid @RequestBody OrderRequestDto orderRequestDto) {

		try {
			GeneralResponseDto response = orderService.addOrder(orderRequestDto);

			return new ResponseEntity<String>(response.toString(), HttpStatus.OK);
		} catch (Exception e) {
			logger.error("<OrderController> - <addOrder> - Throw Error." + e);
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.OK);
		}
	}

	@RequestMapping(method = RequestMethod.POST, value = "/deleteOrder", produces = "application/json", consumes = "application/json")
	public ResponseEntity<String> deleteOrder(@RequestParam(name = "orderId") Long orderId) {
		GeneralResponseDto response = new GeneralResponseDto();
		try {
			response = orderService.deleteOrder(orderId);

			return new ResponseEntity<String>(response.toString(), HttpStatus.OK);
		} catch (Exception e) {
			logger.error("<OrderController> - <deleteOrder> - Throw Error." + e);
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.OK);
		}
	}

	@RequestMapping(method = RequestMethod.POST, value = "/getOrderById", produces = "application/json", consumes = "application/json")
	public ResponseEntity<OrderEntity> getOrderById(@RequestParam(name = "orderId") Long orderId) {

		OrderEntity order = orderService.getOrderById(orderId);
		return new ResponseEntity<OrderEntity>(order, HttpStatus.OK);

	}

	@RequestMapping(method = RequestMethod.POST, value = "/getOrderByDate", produces = "application/json", consumes = "application/json")
	public ResponseEntity<List<OrderEntity>> getOrderById(@RequestParam(name = "startDate") Date startDate,@RequestParam(name = "endDate") Date endDate) {
		
		List<OrderEntity> order = orderService.getOrdersByDateInterval(startDate,endDate);
		return new ResponseEntity<List<OrderEntity>>(order, HttpStatus.OK);

	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/getAllOrders", produces = "application/json", consumes = "application/json")
	public ResponseEntity<List<OrderEntity>> getAllOrders() {
		List<OrderEntity> orderList = orderService.getAllOrders();

		return new ResponseEntity<List<OrderEntity>>(orderList, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/getAllCustomerOrders", produces = "application/json", consumes = "application/json")
	public ResponseEntity<List<OrderEntity>> getAllCustomerOrders(@RequestParam(name = "customerId") Long customerId) {
		List<OrderEntity> orderList = orderService.getCustomerOrders(customerId);

		return new ResponseEntity<List<OrderEntity>>(orderList, HttpStatus.OK);
	}
	
}
