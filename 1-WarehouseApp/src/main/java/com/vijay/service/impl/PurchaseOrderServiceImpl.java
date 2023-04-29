package com.vijay.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vijay.model.PurchaseDetails;
import com.vijay.model.PurchaseOrder;
import com.vijay.repo.PurchaseDetailsRepository;
import com.vijay.repo.PurchaseOrderRepository;
import com.vijay.service.PurchaseOrderService;

@Service
public class PurchaseOrderServiceImpl implements PurchaseOrderService {
	
	@Autowired
	private PurchaseOrderRepository purchaseOrderRepo;
	@Autowired
	 private PurchaseDetailsRepository purchaseDetailsRepo;

	@Override
	public Integer savePurchaseOrder(PurchaseOrder purchaseOrder) {
		return purchaseOrderRepo.save(purchaseOrder).getId();
	}

	@Override
	public List<PurchaseOrder> getAllPurchaseOrders() {
		return purchaseOrderRepo.findAll();
	}

	@Override
	public PurchaseOrder getOnePurchaseOrder(Integer id) {
		Optional<PurchaseOrder> opt=purchaseOrderRepo.findById(id);
		PurchaseOrder purchaseOrder=opt.get();
		return purchaseOrder;
	}

	@Override
	public void deletePurchaseOrder(Integer id) {
		purchaseOrderRepo.deleteById(id);
	}

	@Override
	public void updatePurchaseOrder(PurchaseOrder purchaseOrder) {
if(purchaseOrder.getId()!=null)
{
	purchaseOrderRepo.save(purchaseOrder);
}
	}

	@Override
	public Integer savePurchaseDetail(PurchaseDetails purchaseDetails) {
		return purchaseDetailsRepo.save(purchaseDetails).getId();
	}

}
