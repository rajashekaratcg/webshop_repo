package com.petsupplies.web.controller.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.petsupplies.service.category.ICategoryService;
import com.petsupplies.service.product.IProductService;

@Controller
@RequestMapping("/product")
public class ProductController
{
   @Autowired
   private IProductService productService;

   @Autowired
   private ICategoryService categoryService;

   @RequestMapping("/welcome")
   public String welcome(Model model, @RequestParam(value = "pageNum", defaultValue = "0") int pageNum, @RequestParam(value = "pageSize", defaultValue = "10") int pageSize)
   {

      model.addAttribute("parentCategories", categoryService.findAllParents());
      model.addAttribute("products", productService.findAll(new PageRequest(0, 10)));

      return "/product/welcome";
   }

   @RequestMapping("/category/{id}")
   public String browseByCategory(Model model, @RequestParam(value = "pageNum", defaultValue = "0") int pageNum, @RequestParam(value = "pageSize", defaultValue = "10") int pageSize,
         @PathVariable("id") long id)
   {

      model.addAttribute("parentCategories", categoryService.findAllParents());
      model.addAttribute("products", productService.findByCategoryId(id, new PageRequest(0, 10)));

      return "/product/welcome";
   }
}
