package com.vijay.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vijay.model.Order;

public interface OrderRepository extends JpaRepository<Order, String> {

}
