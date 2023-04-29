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

import com.vijay.model.Part;
import com.vijay.service.OrderService;
import com.vijay.service.PartService;
import com.vijay.service.UomService;

@Controller
@RequestMapping("/part")
public class PartController {
	
	@Autowired
	private UomService uomService;
	@Autowired
	private OrderService orderService;

	@Autowired
	private PartService partService;
	

	@GetMapping("/register")
	public String showReg(Model model) {
		model.addAttribute("part", new Part());
		model.addAttribute("uoms", uomService.getUomIdAndModel());
		
		model.addAttribute("orderPurchases",orderService.getOrderIdAndCodeByMode("Purchase"));
		model.addAttribute("orderSales",orderService.getOrderIdAndCodeByMode("Sale"));
		return "PartRegister";
	}

	@PostMapping("/save")
	public String savePart(@ModelAttribute Part part, Model model) {
		String id = partService.savepart(part);
		model.addAttribute("message", "Part '" + id + "' Saved");
		model.addAttribute("part", new Part());
		model.addAttribute("uoms", uomService.getUomIdAndModel());
		model.addAttribute("orderSales",orderService.getOrderIdAndCodeByMode("Sale"));
		model.addAttribute("orderPurchases",orderService.getOrderIdAndCodeByMode("Purchase"));
		
		return "PartRegister";

	}

	@GetMapping("/all")
	public String getAllParts(Model model) {
		List<Part> list = partService.getAllParts();
		model.addAttribute("list", list);
		return "PartData";
	}

	@GetMapping("/edit")
	public String getOnePart(@RequestParam String id, Model model) {
		Part part = partService.getOnePart(id);
		model.addAttribute("part", part);
		model.addAttribute("uoms", uomService.getUomIdAndModel());
		model.addAttribute("orderSales",orderService.getOrderIdAndCodeByMode("Sale"));
		model.addAttribute("orderPurchases",orderService.getOrderIdAndCodeByMode("Purchase"));
		return "PartEdit";
	}

	@GetMapping("/delete")
	public String deletePart(@RequestParam String id, Model model) {
		partService.deletePart(id);
		model.addAttribute("message", "Part '" + id + "' Deleted");
		model.addAttribute("list", partService.getAllParts());
		return "PartData";

	}

	@PostMapping("/update")
	public String updatePart(@ModelAttribute Part part, Model model) {
		partService.updatePart(part);
		model.addAttribute("message", "Part '" + part.getPartId() + "' Updated");
		model.addAttribute("list", partService.getAllParts());
		return "PartData";

	}

}
