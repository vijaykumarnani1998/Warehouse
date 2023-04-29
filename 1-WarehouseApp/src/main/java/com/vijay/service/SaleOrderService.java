package com.vijay.service;

import java.util.List;

import com.vijay.model.SaleOrder;


public interface SaleOrderService {
	public Integer saveSaleOrder( SaleOrder saleOrder);
	public List<SaleOrder> getAllSaleOrders();
	public SaleOrder getOneSaleOrder(Integer id);
	public void deleteSaleOrder(Integer id);
	public void updateSaleOrder(SaleOrder saleOrder);
	
}
