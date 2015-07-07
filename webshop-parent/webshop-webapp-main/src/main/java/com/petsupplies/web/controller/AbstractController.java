package com.petsupplies.web.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.data.domain.PageRequest;
import org.springframework.ui.Model;

import com.petsupplies.service.category.ICategoryService;
import com.petsupplies.service.product.IProductService;
import com.petsupplies.web.controller.user.UserController;
import com.petsupplies.web.model.user.ShoppingCart;

public abstract class AbstractController
{
   public static final String WELCOME = "/welcome";
   public static final String ROOT = "/";
   public static final String REDIRECT$_WELCOME = "redirect:/welcome";

   public static final String PARAM_PAGE_NUM = "pageNum";
   public static final String PARAM_ZERO = "0";
   public static final String PARAM_PAGE_SIZE = "pageSize";
   public static final String PARAM_TEN = "10";

   public static final String ATTRIB_INFO = "info";
   public static final String ATTRIB_WARNING = "warning";
   public static final String ATTRIB_PARENT_CATEGORIES = "parentCategories";
   public static final String PARAM_ID = "id";   

   @Autowired
   protected ICategoryService categoryService;

   @Autowired
   protected IProductService productService;

   @Autowired
   protected ShoppingCart shoppingCart;

   @Autowired
   protected MessageSource messageSource;

   protected void populateParentCategories(Model model)
   {
      model.addAttribute(ATTRIB_PARENT_CATEGORIES, categoryService.findAllParents());
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
      model.addAttribute(UserController.ATTRIB_SHOPPING_CART, shoppingCart);
   }

   protected void populateCommonAttributes(Model model)
   {
      populateShoppingCart(model);
      populateParentCategories(model);
   }

   protected String getMsg(String code, Locale locale)
   {
      return messageSource.getMessage(code, null, locale);
   }
}
