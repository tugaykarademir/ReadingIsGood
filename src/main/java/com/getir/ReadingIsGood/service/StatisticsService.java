package com.getir.ReadingIsGood.service;

import java.util.List;

import com.getir.ReadingIsGood.dto.StatisticsResponseDto;

public interface StatisticsService {

	
	public List<StatisticsResponseDto> getAllStatistics(String CustomerId);
}
