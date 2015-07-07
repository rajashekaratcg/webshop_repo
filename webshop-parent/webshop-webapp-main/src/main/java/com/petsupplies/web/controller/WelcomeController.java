package com.petsupplies.web.controller;

import static com.petsupplies.web.controller.product.ProductController.ATTRIB_PRODUCTS;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.petsupplies.web.model.user.ShoppingCart;

@Controller
public class WelcomeController extends AbstractController
{
	   @Autowired
	   protected ShoppingCart shoppingCart;
	   
   @RequestMapping({ ROOT, WELCOME })
   public String welcome(Model model)
   {
      populateCommonAttributes(model);
      model.addAttribute(ATTRIB_PRODUCTS, productService.findAll(createPageRequest()));

      return WELCOME;
   }

}
