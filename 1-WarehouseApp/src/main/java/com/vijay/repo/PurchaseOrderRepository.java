package com.vijay.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vijay.model.PurchaseOrder;

public interface PurchaseOrderRepository extends JpaRepository<PurchaseOrder, Integer> {

}
