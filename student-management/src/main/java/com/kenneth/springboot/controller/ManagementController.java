package com.kenneth.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kenneth.springboot.entity.User;
import com.kenneth.springboot.service.UserService;

@Controller
@RequestMapping("/")
public class ManagementController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping
	public String showHome(Model model) {
		
		List<User> users = userService.listUsers();
		
		model.addAttribute("users",users);
		
		return "/management/home";
	}
	
	@GetMapping("/update")
	public String showFormForUpdate(@RequestParam("userId") int userid, Model model) {
		
		User user = userService.findUserById(userid);
		
		model.addAttribute("user", user);
		
		return"/management/registration";
	}
	
	@GetMapping("/delete")
	public String deleteUser(@RequestParam("userId") int userid) {
		
		userService.deleteUser(userid);
		
		return "redirect:/";
	}
}
