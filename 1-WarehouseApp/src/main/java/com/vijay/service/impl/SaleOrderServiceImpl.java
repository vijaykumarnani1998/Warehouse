package com.vijay.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vijay.model.SaleOrder;
import com.vijay.repo.SaleOrderRepository;
import com.vijay.service.SaleOrderService;
@Service
public class SaleOrderServiceImpl implements SaleOrderService {
	
	@Autowired
	 private SaleOrderRepository saleOrderRepo;
	@Override
	public Integer saveSaleOrder(SaleOrder saleOrder) {
		return saleOrderRepo.save(saleOrder).getId();
	}

	@Override
	public List<SaleOrder> getAllSaleOrders() {
		return saleOrderRepo.findAll();
	}

	@Override
	public SaleOrder getOneSaleOrder(Integer id) {
		Optional<SaleOrder> opt=saleOrderRepo.findById(id);
		SaleOrder saleOrder=opt.get();
		return saleOrder;
	}

	@Override
	public void deleteSaleOrder(Integer id) {
		saleOrderRepo.deleteById(id);
	}

	@Override
	public void updateSaleOrder(SaleOrder saleOrder) {
if(saleOrder.getId()!=null)
{
	saleOrderRepo.save(saleOrder);
}
	}

}
