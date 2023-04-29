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

import com.vijay.model.PurchaseDetails;
import com.vijay.model.PurchaseOrder;
import com.vijay.service.PartService;
import com.vijay.service.PurchaseOrderService;
import com.vijay.service.ShipmentService;
import com.vijay.service.UserService;


@Controller
@RequestMapping("/purchaseorder")
public class PurchaseOrderController {
	@Autowired
	private PurchaseOrderService purchaseOrderService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ShipmentService shipmentService;
	
	@Autowired
	 private PartService partService;
	
	@GetMapping("/register")
	public String showReg(Model model)
	{
		
		PurchaseOrder  purchaseorder=new PurchaseOrder();
		purchaseorder.setStatus("OPEN");
		model.addAttribute("purchaseOrder", purchaseorder);
		model.addAttribute("userTypeVendors",userService.getUserTypeVendorIdAndCodeByUserType("Vendor"));
		model.addAttribute("shipments", shipmentService.getShipmentIdAndCodeByEnabled("Yes"));
		return "PurchaseOrderRegister";
	}
	@PostMapping("/save")
	public String savePurchaseOrder(@ModelAttribute PurchaseOrder purchaseOrder,Model model)
	{
		Integer id=purchaseOrderService.savePurchaseOrder(purchaseOrder);
		model.addAttribute("message", "PurchaseOrder '"+id+"' Saved");
		PurchaseOrder  purchaseorder=new PurchaseOrder();
		purchaseorder.setStatus("OPEN");
		model.addAttribute("purchaseOrder", purchaseorder);
		model.addAttribute("userTypeVendors",userService.getUserTypeVendorIdAndCodeByUserType("Vendor"));
		model.addAttribute("shipments", shipmentService.getShipmentIdAndCodeByEnabled("Yes"));
	
		return "PurchaseOrderRegister";
	}
	@GetMapping("/all")
	public String getAllPurchaseOrder(Model model)
	{
		List<PurchaseOrder> list=purchaseOrderService.getAllPurchaseOrders();
		model.addAttribute("list", list);
		return "PurchaseOrderData";
	}
	@GetMapping("/edit")
	public String getOnePurchaseOrder(@RequestParam Integer id,Model model)
	{ 
		PurchaseOrder purchaseOrder=purchaseOrderService.getOnePurchaseOrder(id);
		model.addAttribute("purchaseOrder", purchaseOrder);
		model.addAttribute("userTypeVendors",userService.getUserTypeVendorIdAndCodeByUserType("Vendor"));
		model.addAttribute("shipments", shipmentService.getShipmentIdAndCodeByEnabled("Yes"));
	
		return "PurchaseOrderEdit";
	}
	@GetMapping("/delete")
	public String deletePurchaseOrder(@RequestParam Integer id,Model model)
	{ 
		purchaseOrderService.deletePurchaseOrder(id);
		model.addAttribute("message", "PurchaseOrder '"+id+"' Deleted");
		model.addAttribute("list", purchaseOrderService.getAllPurchaseOrders());
		return "PurchaseOrderData";
	}
	@PostMapping("/update")
	public String updatePurchaseOrder(@ModelAttribute PurchaseOrder purchaseOrder,Model model)
	{
		purchaseOrderService.updatePurchaseOrder(purchaseOrder);
		model.addAttribute("message", "PurchaseOrder '"+purchaseOrder.getId()+"' Updated");
		model.addAttribute("list", purchaseOrderService.getAllPurchaseOrders());
		return "PurchaseOrderData";
	}
	
	//Second Screen
	
	@GetMapping("/addparts")
	public String addParts(@RequestParam Integer id,Model model)
	{
		
	//For Section -1 getting order code,status,id(hidden input)
	PurchaseOrder purchaseOrder=purchaseOrderService.getOnePurchaseOrder(id);
	model.addAttribute("purchaseOrder",purchaseOrder )	;
	
	//Form Backing Object in Section 2
	model.addAttribute("purchaseDetails", new PurchaseDetails());
	
	//Send Part details to drop down
	model.addAttribute("parts", partService.getPartIdAndCode());
	
	return "PurchaseOrderParts";
	
	}
	@PostMapping("/saveparts")
	public String saveParts(@ModelAttribute PurchaseDetails purchaseDetails)
	{
		purchaseOrderService.savePurchaseDetail(purchaseDetails);
		
		return  " redirect:/addparts?id="+purchaseDetails.getPurchaseorder().getId();
		
	}
	

	

}
