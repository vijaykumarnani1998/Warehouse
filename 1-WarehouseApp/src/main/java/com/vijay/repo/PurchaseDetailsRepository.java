package com.vijay.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vijay.model.PurchaseDetails;

public interface PurchaseDetailsRepository extends JpaRepository<PurchaseDetails, Integer> {


}
