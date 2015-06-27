package com.petsupplies.admin.controller.user;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.petsupplies.model.user.User;
import com.petsupplies.service.user.IUserService;


@Controller
public class UserController
{
   @Autowired
   private IUserService userService;

   @RequestMapping("/user/signin")
   public String signin(Model model)
   {
      model.addAttribute("user", new User());
      return "/user/signin";
   }

   @RequestMapping("/user/authentication_failure")
   public String authenticationFailure(RedirectAttributes model)
   {
      model.addAttribute("error", true);
      return "redirect:/user/signin";
   }

   @RequestMapping("/user/signout")
   public String signout(RedirectAttributes model, HttpSession session)
   {
      model.addAttribute("info", "You have successfully signed out!");
      session.invalidate();
      return "redirect:/user/signin";
   }

   @RequestMapping("/user/denied")
   public String denied()
   {
      return "/user/denied";
   }
}

