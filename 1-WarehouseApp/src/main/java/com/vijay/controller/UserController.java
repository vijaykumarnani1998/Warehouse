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
import org.springframework.web.bind.annotation.ResponseBody;

import com.vijay.model.User;
import com.vijay.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/register")
	public String showReg(Model model)
	{
		model.addAttribute("user",new User());
		return "UserRegister";
	}
	
	@PostMapping("/save")
	public String saveUser(@ModelAttribute User user,Model model)
	{
		Integer id=userService.saveUser(user);
		model.addAttribute("message","User '"+id+"' saved");
		model.addAttribute("user",new User());
		return "UserRegister";
	}
	
	@GetMapping("/all")
	public String getAll(Model model)
	{
		List<User>list=userService.getAllUsers();
		model.addAttribute("list", list);
		return "UserData";
	}
	@GetMapping("/edit")
	public String getOneUser(@RequestParam Integer id,Model model)
	{
        User user=userService.getOneUser(id);
		model.addAttribute("user",user);
		return "UserEdit";
	}
	@GetMapping("/delete")
	public String deleteUser(@RequestParam Integer id,Model model)
	{
      userService.deleteUser(id);
        model.addAttribute("message","User '"+id+"' Deleted");	
        model.addAttribute("list", userService.getAllUsers());
        return "UserData";
	}
	@PostMapping("/update")
	public String updateUser(@ModelAttribute User user,Model model)
	{  
		userService.updateUser(user);
        model.addAttribute("message","User '"+user.getUserId()+"' Updated");	
        model.addAttribute("list", userService.getAllUsers());
        return "UserData";
	}
	 @GetMapping("/validateEmail")
	 public @ResponseBody String validateEmail(@RequestParam String email)
	 {
		 String message="";
		 if(userService.isUserEmailExist(email))
		 {
			 message=email +"Already Exists";
		 }
		 return message;
	 }

}
