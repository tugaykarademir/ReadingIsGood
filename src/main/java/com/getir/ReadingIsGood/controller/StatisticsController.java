package com.getir.ReadingIsGood.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.getir.ReadingIsGood.dto.StatisticsResponseDto;
import com.getir.ReadingIsGood.service.StatisticsService;

@Controller
@RequestMapping(value="/statistics")
public class StatisticsController {
	
	@Autowired
	private StatisticsService statisticsService;

	@RequestMapping(value = "/getAllStatistics", method = RequestMethod.GET,produces = "application/json", consumes = "application/json" )
	public ResponseEntity<List<StatisticsResponseDto>>  getStatistics(@RequestParam(name = "customerId") String customerId ){
		
		List<StatisticsResponseDto> statisticsResponse  = statisticsService.getAllStatistics(customerId);
		
		return new ResponseEntity<List<StatisticsResponseDto>>(statisticsResponse,HttpStatus.OK);
		
		
	}

}
