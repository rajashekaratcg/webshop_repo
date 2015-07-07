package com.petsupplies.web.controller.product;

import java.util.Locale;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.petsupplies.web.controller.AbstractController;

@Controller
@RequestMapping(ProductController.PRODUCT)
public class ProductController extends AbstractController
{
   public static final String SEARCH = "/search";
   public static final String PRODUCT = "/product";
   public static final String PRODUCT_WELCOME = "/product/welcome";
   public static final String PRODUCT_VIEW = "/product/view";
   public static final String PATH_PARAM_ID = "/{id}";
   public static final String CATEGORY_PARAM_ID = "/category/{id}";

   public static final String ATTRIB_PRODUCT = "product";
   public static final String ATTRIB_PRODUCTS = "products";

   public static final String PARAM_Q = "q";

   private static final String MSG_PRODUCT_NOT_FOUND = "msg.productNotFound";

   @RequestMapping(WELCOME)
   public String welcome(Model model, @RequestParam(value = PARAM_PAGE_NUM, defaultValue = PARAM_ZERO) int pageNum, @RequestParam(value = PARAM_PAGE_SIZE, defaultValue = PARAM_TEN) int pageSize)
   {
      populateCommonAttributes(model);
      model.addAttribute(ATTRIB_PRODUCTS, productService.findAll(createPageRequest()));

      return PRODUCT_WELCOME;
   }

   @RequestMapping(CATEGORY_PARAM_ID)
   public String browseByCategory(Model model, @RequestParam(value = PARAM_PAGE_NUM, defaultValue = PARAM_ZERO) int pageNum,
         @RequestParam(value = PARAM_PAGE_SIZE, defaultValue = PARAM_TEN) int pageSize, @PathVariable(PARAM_ID) long id)
   {
      populateCommonAttributes(model);
      model.addAttribute(ATTRIB_PRODUCTS, productService.findByCategoryId(id, createPageRequest()));

      return PRODUCT_WELCOME;
   }

   @RequestMapping(PATH_PARAM_ID)
   public String view(Model model, Locale locale, @PathVariable(PARAM_ID) long id)
   {
      populateCommonAttributes(model);

      if (id < 1)
      {
         model.addAttribute(ATTRIB_WARNING, getMsg(MSG_PRODUCT_NOT_FOUND, locale));
         return PRODUCT_WELCOME;
      }

      model.addAttribute(ATTRIB_PRODUCT, productService.findById(id));

      return PRODUCT_VIEW;
   }

   @RequestMapping(SEARCH)
   public String search(Model model, @RequestParam(value = PARAM_Q) String query)
   {
      populateCommonAttributes(model);
      if (StringUtils.isNotBlank(query))
      {
         model.addAttribute(ATTRIB_PRODUCTS, productService.searchByNameOrDescription(query, createPageRequest()));
      }
      else
      {
         model.addAttribute(ATTRIB_PRODUCTS, productService.findAll(createPageRequest()));
      }

      return PRODUCT_WELCOME;
   }

}
