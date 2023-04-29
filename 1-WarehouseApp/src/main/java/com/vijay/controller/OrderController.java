package com.vijay.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.vijay.model.Order;
import com.vijay.service.OrderService;
import com.vijay.view.OrderExcelView;
import com.vijay.view.OrderPdfView;

@Controller
@RequestMapping("/order")
public class OrderController {
	@Autowired
	private OrderService orderService;
	
	@GetMapping("/register")
	public String showReg(Model model)
	{
		
		
		model.addAttribute("order", new Order());
		return "OrderRegister";
	}
	@PostMapping("/save")
	public String saveOrder(@ModelAttribute Order order,Model model)
	{
		String id=orderService.saveOrder(order);
		model.addAttribute("message", "Order '"+id+"' Saved");
		model.addAttribute("order", new Order());
		return "OrderRegister";
	}
	@GetMapping("/all")
	public String getAllOrder(Model model)
	{
		List<Order> list=orderService.getAllOrders();
		model.addAttribute("list", list);
		return "OrderData";
	}
	@GetMapping("/edit")
	public String getOneOrder(@RequestParam String id,Model model)
	{ 
		Optional<Order> order=orderService.getOneOrder(id);
		model.addAttribute("order", order);
		return "OrderEdit";
	}
	@GetMapping("/delete")
	public String deleteOrder(@RequestParam String id,Model model)
	{ 
		orderService.deleteOrder(id);
		model.addAttribute("message", "Order '"+id+"' Deleted");
		model.addAttribute("list", orderService.getAllOrders());
		return "OrderData";
	}
	@PostMapping("/update")
	public String updateOrder(@ModelAttribute Order order,Model model)
	{
		orderService.updateOrder(order);
		model.addAttribute("message", "Order '"+order.getOrderId()+"' Updated");
		model.addAttribute("list", orderService.getAllOrders());
		return "OrderData";
	}
	@GetMapping("/excel")
	public ModelAndView exportToExcel()
	{
		ModelAndView m=new ModelAndView();
		m.setView(new OrderExcelView());
		List<Order> list=orderService.getAllOrders();
		m.addObject("list", list);
		return m;
	}
	@GetMapping("/pdf")
	public ModelAndView exportToPdf()
	{
		ModelAndView m=new ModelAndView();
		m.setView(new OrderPdfView());
		List<Order>list=orderService.getAllOrders();
		m.addObject("list", list);
		return m;
	}
	
	

}
