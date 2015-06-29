package com.petsupplies.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.petsupplies.service.category.ICategoryService;
import com.petsupplies.service.product.IProductService;

@Controller
public class WelcomeController
{

   @Autowired
   private ICategoryService categoryService;

   @Autowired
   private IProductService productService;

   @RequestMapping({ "/", "/welcome", "/home" })
   public String welcome(Model model)
   {
      model.addAttribute("parentCategories", categoryService.findAllParents());
      model.addAttribute("products", productService.findAll(new PageRequest(0, 10)));

      return "welcome";
   }
}
