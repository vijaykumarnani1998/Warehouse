package com.vijay.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.vijay.model.Order;

public interface OrderService {
	public   String saveOrder(Order order);
	public List<Order> getAllOrders();
	public Optional<Order> getOneOrder(String id);
	public void deleteOrder(String id);
	public void updateOrder(Order order);
public Map<String,String> getOrderIdAndCodeByMode(String mode);
}
