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
import org.springframework.web.servlet.ModelAndView;

import com.vijay.model.Uom;
import com.vijay.service.UomService;
import com.vijay.view.UomExcelView;
import com.vijay.view.UomPdfView;

import jakarta.mail.MessagingException;

@Controller
@RequestMapping("/uom")
public class UomController {
	
	@Autowired
	private UomService uomService;
	

	
	//1.Show Register page
	@GetMapping("/register")
	public String showReg(Model model)
	{
		model.addAttribute("uom", new Uom());
		return "UomRegister";
	}
	//2.Save Method 
	@PostMapping("/save")
	public String saveUom(@ModelAttribute Uom uom,Model model) throws MessagingException
	{
		String id=uomService.saveUom(uom);
		model.addAttribute("message", "Uom '"+id+"' Saved ");
		model.addAttribute("uom", new Uom());
		return "UomRegister";
	}
	//3.Getting All
	@GetMapping("/all")
	public String getAllUoms(Model model)
	{
		List<Uom> list=uomService.getAllUoms();
		model.addAttribute("list", list);
		return "UomData";
	}
	//4.Get One
	@GetMapping("/edit")
	public String getOneUom(@RequestParam String id,Model model)
	{
        Uom uom=uomService.getOneUom(id);
		model.addAttribute("uom", uom);
		return "UomEdit";
	}
	//5.Delete 
	@GetMapping("/delete")
	public String deleteUom(@RequestParam String id,Model model)
	{  
		uomService.deleteUom(id);
		model.addAttribute("message", "Uom '"+id+"  Deleted");
		List<Uom> list=uomService.getAllUoms();
		model.addAttribute("list", list);
		return "UomData";
	}
	//6.Update
	@PostMapping("/update")
	public String updateUom(@ModelAttribute Uom uom,Model model)
	{
		uomService.updateUom(uom);
		model.addAttribute("message", "Uom '"+uom.getUomId()+"' Updated ");
		List<Uom> list=uomService.getAllUoms();
		model.addAttribute("list", list);
		return "UomData";
	
}
	@GetMapping("/excel")
	public ModelAndView exportToExcel()
	{
		ModelAndView m=new ModelAndView();
		m.setView(new UomExcelView());
	    List<Uom>list=uomService.getAllUoms();
		m.addObject("list", list);
		return m;
	}
	@GetMapping("/pdf")
	public ModelAndView exportToPdf()
	{
		ModelAndView m=new ModelAndView();
		m.setView(new UomPdfView());
		List<Uom>list=uomService.getAllUoms();
		m.addObject("list", list);
		return m;
	}
	
	@GetMapping("/checkUomModel")
	public String validateUomModel(@RequestParam String uomModel)
	{
		
		String message="";
		boolean flag=uomService.isUomModelExist(uomModel);
		if (flag)
		{
			message="Uom Model '"+uomModel+"' Already Exists";
		}
		return  message;
	}
}
