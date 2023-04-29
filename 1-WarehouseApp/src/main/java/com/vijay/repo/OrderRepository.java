package com.vijay.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.vijay.model.Order;

public interface OrderRepository extends JpaRepository<Order, String> {
	
	@Query("SELECT orderId,orderCode from Order where orderMode=:mode")
	List<Object[]> getOrderIdAndOrderCodeByMode(String mode);

}
