package com.vijay.service;

import java.util.List;

import com.vijay.model.PurchaseDetails;
import com.vijay.model.PurchaseOrder;


public interface PurchaseOrderService {
	public Integer savePurchaseOrder( PurchaseOrder purchaseOrder);
	public List<PurchaseOrder> getAllPurchaseOrders();
	public PurchaseOrder getOnePurchaseOrder(Integer id);
	public void deletePurchaseOrder(Integer id);
	public void updatePurchaseOrder(PurchaseOrder purchaseOrder);
	
	//Screen 2
	public  Integer savePurchaseDetail(PurchaseDetails purchaseDetails);
	
	
	 
}
