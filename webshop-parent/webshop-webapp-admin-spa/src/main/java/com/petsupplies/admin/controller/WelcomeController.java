package com.petsupplies.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.petsupplies.model.user.User;
import com.petsupplies.service.user.IUserService;

@Controller
public class WelcomeController extends AbstractController {

	@Autowired
	private IUserService userService;

	@RequestMapping({ ROOT, WELCOME })
	public String welcome() {
		return WELCOME;
	}

	@RequestMapping(value = "/api/users/{username}")
	public @ResponseBody User getUser(@PathVariable String username) {
		return userService.findByUsername(username);
	}
}
