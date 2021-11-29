package com.kenneth.springboot.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kenneth.springboot.entity.User;
import com.kenneth.springboot.service.UserService;

@Controller
@RequestMapping("/save")
public class RegistrationController {

	@Autowired
	private UserService userService;
	
	@GetMapping
	public String showRegistrationPage(Model model) {
		
		model.addAttribute("user", new User());
		
		return "/management/registration";
	}
	
	@PostMapping
	public String saveUser(@Valid @ModelAttribute("user") User user, BindingResult bindingResult, Model model) {
		
		if(bindingResult.hasErrors()) {
			return "/management/registration";
		}
		
		userService.save(user);
		
		User existing = userService.findUserByEmail(user.getEmail());
		
		if(existing != null) {
			return "/management/update-confirmation";
		}
		
		return "/management/registration-confirmation";
	}
}
