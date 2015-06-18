package com.petsupplies.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.petsupplies.service.user.IUserService;

@Controller
public class WelcomeController {
   
   @Autowired
   IUserService userService;

	@RequestMapping({"/", "/welcome"})
	public String welcome(Model model) {

		model.addAttribute("welcome", "Hello World!");
		
/*		User user = new User();
		user.setEmail("raj@cg.com");
		user.setFullName("Rajashekar Subramany");
		user.setPassword("random");
		user.setUsername("raj"+new Date().getTime());
		
		user = userService.createUser(user);*/
		
//		System.out.println(user);
		
		return "welcome";
	}
}
