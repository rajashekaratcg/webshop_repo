package com.petsupplies.admin.controller.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.petsupplies.service.category.ICategoryService;

@Controller
@RequestMapping("/category")
public class CategoryController
{

   @Autowired
   private ICategoryService categoryService;

   @RequestMapping({ "/", "/welcome" })
   public String welcome(Model model)
   {

      model.addAttribute("categories", categoryService.findAll());

      return "/category/welcome";
   }

   @RequestMapping("/delete")
   public String delete(Model model, @RequestParam(value = "id", required = true) long id)
   {
      categoryService.delete(id);

      model.addAttribute("info", "Category deleted successfully!");
      return "redirect:/category/welcome";
   }
   
   @RequestMapping(value = "/edit", method = RequestMethod.GET)
   public String edit(Model model, @RequestParam(value = "id", required = true) long id)
   {

      model.addAttribute("mode", "Edit");
      model.addAttribute("categories", categoryService.findAll());

      return "/product/edit";
   }   

}
