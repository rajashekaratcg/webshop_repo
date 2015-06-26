package com.petsupplies.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.petsupplies.service.user.IUserService;

@Controller
public class WelcomeController
{

   @Autowired
   private IUserService userService;

   @RequestMapping({ "/", "/welcome" })
   public String welcome(Model model)
   {
      return "welcome";
   }
}
