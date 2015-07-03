package com.petsupplies.web.controller.product;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.petsupplies.web.controller.AbstractController;

@Controller
@RequestMapping("/product")
public class ProductController extends AbstractController
{
   
   public static final String PRODUCT_WELCOME = "/product/welcome";
   public static final String PRODUCT_VIEW = "/product/view";   

   public static final String ATTRIB_PRODUCTS = "products";
   
   @RequestMapping(WELCOME)
   public String welcome(Model model, @RequestParam(value = "pageNum", defaultValue = "0") int pageNum, @RequestParam(value = "pageSize", defaultValue = "10") int pageSize)
   {
      populateCommonAttributes(model);
      model.addAttribute("products", productService.findAll(createPageRequest()));

      return PRODUCT_WELCOME;
   }

   @RequestMapping("/category/{id}")
   public String browseByCategory(Model model, @RequestParam(value = "pageNum", defaultValue = "0") int pageNum, @RequestParam(value = "pageSize", defaultValue = "10") int pageSize,
         @PathVariable("id") long id)
   {
      populateCommonAttributes(model);
      model.addAttribute("products", productService.findByCategoryId(id, createPageRequest()));

      return PRODUCT_WELCOME;
   }

   @RequestMapping("/{id}")
   public String view(Model model, @PathVariable("id") long id)
   {
      populateCommonAttributes(model);

      if (id < 1)
      {
         model.addAttribute("warning", "Product not found.");
         return PRODUCT_WELCOME;
      }

      model.addAttribute("product", productService.findById(id));

      return PRODUCT_VIEW;
   }

   @RequestMapping("/search")
   public String search(Model model, @RequestParam(value = "q") String query)
   {
      populateCommonAttributes(model);
      if (StringUtils.isNotBlank(query))
      {
         model.addAttribute("products", productService.searchByNameOrDescription(query, createPageRequest()));
      }
      else
      {
         model.addAttribute("products", productService.findAll(createPageRequest()));
      }

      return PRODUCT_WELCOME;
   }

}
