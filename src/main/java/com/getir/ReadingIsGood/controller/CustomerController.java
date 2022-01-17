package com.getir.ReadingIsGood.controller;

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

import com.getir.ReadingIsGood.dto.CustomerRequestDto;
import com.getir.ReadingIsGood.dto.GeneralResponseDto;
import com.getir.ReadingIsGood.entity.CustomerEntity;
import com.getir.ReadingIsGood.service.CustomerService;

@Controller
@RequestMapping(value = "/v1/customer")
public class CustomerController {
	private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);
	@Autowired
	private CustomerService customerService;

	@RequestMapping(method = RequestMethod.POST, value = "/addCustomer")
	public ResponseEntity<String> addCutomer(@Valid @RequestBody CustomerRequestDto customerRequestDto) {
		try {
			GeneralResponseDto response = customerService.addCustomer(customerRequestDto);

			return new ResponseEntity<String>(response.getResponseMessage(), "0".equals(response.getResponseStatus())?HttpStatus.OK:HttpStatus.BAD_REQUEST);
		}
		catch (Exception e) {
			logger.error("<CustomerController> - <addCutomer> - Throw Error." + e);
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(method = RequestMethod.POST, value = "/deleteCustomer")
	public ResponseEntity<String> deleteCutomer(@RequestParam(name = "customerId") Long customerId) {
		try {
			GeneralResponseDto response = customerService.deleteCutomer(customerId);

			return new ResponseEntity<String>(response.toString(), HttpStatus.OK);
		} catch (Exception e) {
			logger.error("<CustomerController> - <updateCutomerStatus> - Throw Error." + e);
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(method = RequestMethod.POST, value = "/getCustomer" )
	public ResponseEntity<CustomerEntity> getCutomer(@RequestParam(name = "customerId") Long customerId) {

		CustomerEntity customer = customerService.getCustomerById(customerId);

		return new ResponseEntity<CustomerEntity>(customer, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/getAllCustomer")
	public ResponseEntity<List<CustomerEntity>> getCutomer() {

		List<CustomerEntity> customerList = customerService.getAllCustomer();

		return new ResponseEntity<List<CustomerEntity>>(customerList, HttpStatus.OK);
	}
}
