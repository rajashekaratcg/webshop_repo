package com.petsupplies.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.petsupplies.service.category.ICategoryService;
import com.petsupplies.service.product.IProductService;
import com.petsupplies.web.model.user.ShoppingCart;

@Controller
public abstract class AbstractController
{
   public static final String WELCOME = "/welcome";
   public static final String ROOT = "/";

   @Autowired
   protected ICategoryService categoryService;

   @Autowired
   protected IProductService productService;

   @Autowired()
   protected ShoppingCart shoppingCart;

   protected void populateParentCategories(Model model)
   {
      model.addAttribute("parentCategories", categoryService.findAllParents());
   }

   protected PageRequest createPageRequest()
   {
      return createPageRequest(0, 10);
   }

   protected PageRequest createPageRequest(int page, int size)
   {
      return new PageRequest(page, size);
   }

   protected void populateShoppingCart(Model model)
   {
      model.addAttribute("shoppingCart", shoppingCart);
   }

   protected void populateCommonAttributes(Model model)
   {
      populateShoppingCart(model);
      populateParentCategories(model);
   }
}
