package com.petsupplies.admin.controller.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.petsupplies.service.product.IProductService;

@Controller
public class ProductController {
   
   @Autowired
   private IProductService productService;   

   @RequestMapping({"/product", "/product/welcome"})
   public String welcome(Model model, @RequestParam(value="pageSize", defaultValue="10") int pageSize, 
         @RequestParam(value="pageNum", defaultValue="10") int pageNum) {

      
      
      
      model.addAttribute("products", productService.findAll(new PageRequest(pageNum, pageSize)));
      
      return "/product/welcome";
   }
}
