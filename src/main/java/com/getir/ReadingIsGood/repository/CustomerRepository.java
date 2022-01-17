package com.getir.ReadingIsGood.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.getir.ReadingIsGood.entity.CustomerEntity;
@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {

	boolean existsByCustomerEmail(String email);

	boolean existsByCustomerPhoneNumber(String phoneNumber);

}
