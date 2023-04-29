package com.vijay.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vijay.model.SaleOrder;

public interface SaleOrderRepository extends JpaRepository<SaleOrder,Integer> {

}
