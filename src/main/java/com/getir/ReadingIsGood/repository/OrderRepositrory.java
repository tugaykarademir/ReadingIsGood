package com.getir.ReadingIsGood.repository;


import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.getir.ReadingIsGood.entity.OrderEntity;

@Repository
public interface OrderRepositrory extends JpaRepository<OrderEntity, Long> {
	public List<OrderEntity> findAllByCustomerId(Long customerId);

	public List<OrderEntity> findAllByCreationDateBetween(Date startDate, Date endDate);

}
