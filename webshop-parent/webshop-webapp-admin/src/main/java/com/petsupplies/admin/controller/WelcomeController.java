package com.petsupplies.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomeController extends AbstractController
{

   @RequestMapping({ ROOT, WELCOME })
   public String welcome()
   {
      return WELCOME;
   }
}
