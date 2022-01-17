package com.getir.ReadingIsGood.service.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.getir.ReadingIsGood.dto.StatisticsResponseDto;
import com.getir.ReadingIsGood.service.StatisticsService;

@Service
public class StatisticsServiceImpl implements StatisticsService {
	private static final String SELECT_CUSTOMER_STATISTICS_SQL="select MONTH(o.creation_date)  as month, count(o.id) as totalOrderCount "
																		+ ",count(b.id) as totalBookCount, sum(b.price) as totalPurchasedAmount from orders o ,"
																		+ " books b where o.book_id=b.id  and o.customer_id=? group by MONTH(o.creation_date) ";

	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	class StatisticsServiceRowMapper implements RowMapper<StatisticsResponseDto> {
		@Override
		public StatisticsResponseDto mapRow(ResultSet rs, int rowNum) throws SQLException {
			StatisticsResponseDto statisticsResponseDto = new StatisticsResponseDto();
			statisticsResponseDto.setMonth(rs.getString("month"));
			statisticsResponseDto.setTotalOrderCount(rs.getInt("totalOrderCount"));
			statisticsResponseDto.setTotalBookCount(rs.getInt("totalBookCount"));
			statisticsResponseDto.setTotalPurchasedAmount(rs.getLong("totalPurchasedAmount"));
			
			return statisticsResponseDto;
		}
	}
	
	
	@Override
	public List<StatisticsResponseDto> getAllStatistics(String customerId){

	List<StatisticsResponseDto> list =null ;

		try {
		list = jdbcTemplate.query(SELECT_CUSTOMER_STATISTICS_SQL,new Object[] {customerId}, new StatisticsServiceRowMapper());
		
		 }catch (Exception e) {
				System.out.print(e);
		 }

		return list;
	}

}
