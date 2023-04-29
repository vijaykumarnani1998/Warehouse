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

import com.vijay.model.Shipment;
import com.vijay.service.ShipmentService;

@Controller
@RequestMapping("/shipment")
public class ShipmentController {
	@Autowired
	private ShipmentService shipmentService;
	
	@GetMapping("/register")
	public String showReg(Model model)
	{
		model.addAttribute("shipment", new Shipment());
		return "ShipmentRegister";
	}
	@PostMapping("/save")
	public String saveShipment(@ModelAttribute Shipment shipment,Model model)
	{
		String id=shipmentService.saveShipment(shipment);
		model.addAttribute("message", "Shipment '"+id+"' Saved");
		model.addAttribute("shipment", new Shipment());
		return "ShipmentRegister";
	}
	@GetMapping("/all")
	public String getAllShipments(Model model)
	{
		List<Shipment> list=shipmentService.getAllShipments();
		model.addAttribute("list", list);
		return "ShipmentData";
	}
	@GetMapping("/edit")
	public String getOneShipment(@RequestParam String id,Model model)
	{
		Shipment shipment=shipmentService.getOneShipment(id);
		model.addAttribute("shipment", shipment);
		return "ShipmentEdit";
	}
	@GetMapping("/delete")
	public String deleteShipment(@RequestParam String id,Model model)
	{
		shipmentService.deleteShipment(id);
		model.addAttribute("message", "Shipment '"+id+"' Deleted");
		model.addAttribute("list",shipmentService.getAllShipments() );
		
		return "ShipmentData";
	}
	@PostMapping("/update")
	public String updateShipment(@ModelAttribute  Shipment shipment,Model model)
	{
		shipmentService.updateShipment(shipment);
		model.addAttribute("message", "Shipment '"+shipment.getShipmentId()+"' Updated");
		model.addAttribute("list",shipmentService.getAllShipments() );
		return "ShipmentData";
	}

}
