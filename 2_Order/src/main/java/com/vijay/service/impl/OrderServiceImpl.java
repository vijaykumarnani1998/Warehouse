package com.vijay.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vijay.model.Order;
import com.vijay.repo.OrderRepository;
import com.vijay.service.OrderService;
@Service
public class OrderServiceImpl implements OrderService {

	
	@Autowired
	private OrderRepository orderRepo;
	@Override
	public String saveOrder(Order order) {
		return orderRepo.save(order).getOrderId();
	}

	@Override
	public List<Order> getAllOrders() {
		return orderRepo.findAll();
	}

	@Override
	public Optional<Order> getOneOrder(String id) {
		Optional<Order> order=orderRepo.findById(id);
		return order;
	}

	@Override
	public void deleteOrder(String id) {
		orderRepo.deleteById(id);
	}

	@Override
	public void updateOrder(Order order) {
if(order.getOrderId()!=null)
{
	orderRepo.save(order);
}
	}

}
