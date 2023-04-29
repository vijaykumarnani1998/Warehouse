package com.vijay.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.vijay.model.SaleOrder;
import com.vijay.service.SaleOrderService;
import com.vijay.service.ShipmentService;
import com.vijay.service.UserService;


@Controller
@RequestMapping("/saleOrder")
public class SaleOrderController {
	@Autowired
	private SaleOrderService saleOrderService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ShipmentService shipmentService;
	
	@GetMapping("/register")
	public String showReg(Model model)
	{
		
		SaleOrder  saleOrder=new SaleOrder();
		saleOrder.setStatus("OPEN");
		model.addAttribute("saleOrder", saleOrder);
		model.addAttribute("userTypeCustomers",userService.getUserTypeVendorIdAndCodeByUserType("Customer"));
		model.addAttribute("shipments", shipmentService.getShipmentIdAndCodeByEnabled("Yes"));
		return "SaleOrderRegister";
	}
	@PostMapping("/save")
	public String saveSaleOrder(@ModelAttribute SaleOrder saleOrder,Model model)
	{
		Integer id=saleOrderService.saveSaleOrder(saleOrder);
		model.addAttribute("message", "SaleOrder '"+id+"' Saved");
		SaleOrder  saleOrder1=new SaleOrder();
		saleOrder1.setStatus("OPEN");
		model.addAttribute("saleOrder", saleOrder1);
		model.addAttribute("userTypeCustomers",userService.getUserTypeVendorIdAndCodeByUserType("Customer"));
		model.addAttribute("shipments", shipmentService.getShipmentIdAndCodeByEnabled("Yes"));
	
		return "SaleOrderRegister";
	}
	@GetMapping("/all")
	public String getAllSaleOrder(Model model)
	{
		List<SaleOrder> list=saleOrderService.getAllSaleOrders();
		model.addAttribute("list", list);
		return "SaleOrderData";
	}
	@GetMapping("/edit")
	public String getOneSaleOrder(@RequestParam Integer id,Model model)
	{ 
		SaleOrder saleOrder=saleOrderService.getOneSaleOrder(id);
		model.addAttribute("saleOrder", saleOrder);
		model.addAttribute("userTypeCustomers",userService.getUserTypeVendorIdAndCodeByUserType("Customer"));
		model.addAttribute("shipments", shipmentService.getShipmentIdAndCodeByEnabled("Yes"));
	
		return "SaleOrderEdit";
	}
	@GetMapping("/delete")
	public String deleteSaleOrder(@RequestParam Integer id,Model model)
	{ 
		saleOrderService.deleteSaleOrder(id);
		model.addAttribute("message", "SaleOrder '"+id+"' Deleted");
		model.addAttribute("list", saleOrderService.getAllSaleOrders());
		return "SaleOrderData";
	}
	@PostMapping("/update")
	public String updateSaleOrder(@ModelAttribute SaleOrder saleOrder,Model model)
	{
		saleOrderService.updateSaleOrder(saleOrder);
		model.addAttribute("message", "SaleOrder '"+saleOrder.getId()+"' Updated");
		model.addAttribute("list", saleOrderService.getAllSaleOrders());
		return "SaleOrderData";
	}
	
	
	

}
