package com.petsupplies.web.controller.user;

import static com.petsupplies.web.controller.common.util.ViewPath.USER_SIGNUP;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.common.collect.Lists;
import com.petsupplies.model.product.Product;
import com.petsupplies.model.user.User;
import com.petsupplies.model.user.UserAddress;
import com.petsupplies.model.user.UserPhone;
import com.petsupplies.service.user.IUserService;
import com.petsupplies.web.controller.AbstractController;
import com.petsupplies.web.model.user.ShoppingCart;

@Controller
public class UserController extends AbstractController
{

   @Autowired
   private IUserService userService;
   
   @RequestMapping({ "/signup", USER_SIGNUP })
   public String signup(Model model)
   {
      model.addAttribute("user", createUser());
      return USER_SIGNUP;
   }

   private User createUser()
   {
      User user = new User();
      user.setUserAddress(Lists.newArrayList(new UserAddress()));
      user.setUserPhones(Lists.newArrayList(new UserPhone()));
      return user;
   }

   @RequestMapping(value = { "/signup", USER_SIGNUP }, method = RequestMethod.POST)
   public String signup(Model model, RedirectAttributes redirectAttributes, @Valid @ModelAttribute("user") User user, BindingResult result)
   {
      if (result.hasErrors())
      {
         model.addAttribute("user", user);
         return USER_SIGNUP;
      }
      else
      {
         userService.createUser(user);
      }

      redirectAttributes.addAttribute("info", user.getUsername() + " created successfully! Login now!");

      return "redirect:/user/signin";
   }

   @RequestMapping({ "/signin", "/user/signin" })
   public String signin(Model model)
   {
      model.addAttribute("user", new User());
      return "/user/signin";
   }

   @RequestMapping({ "/authentication_failure", "/user/authentication_failure" })
   public String authenticationFailure(RedirectAttributes model)
   {
      model.addAttribute("error", true);
      return "redirect:/user/signin";
   }

   @RequestMapping({ "/signout", "/user/signout" })
   public String signout(RedirectAttributes model, HttpSession session)
   {
      model.addAttribute("info", "You have successfully signed out!");
      session.invalidate();
      return "redirect:/welcome";
   }

   @RequestMapping({ "/denied", "/user/denied" })
   public String denied(Model model)
   {
      model.addAttribute("info", "Sorry, you are not authorized to view the requested resource.");
      return "/user/denied";
   }

   @RequestMapping({ "/user/profile" })
   public String profile(Model model)
   {
      return "/welcome";
   }

   @RequestMapping({ "/user/shopping/cart", "/user/shopping" })
   public String shoppingCart(Model model)
   {
      model.addAttribute("shoppingCart", shoppingCart);
      return "/user/shopping/cart/view";
   }

   @RequestMapping(value = "/user/shopping/cart/add", method = RequestMethod.POST)
   public String addToShoppingCart(@RequestParam(value = "productId", required = true) long productId, @RequestParam(value = "quantity", required = true) int quantity, RedirectAttributes model)
   {
      Product product = productService.findById(productId);
      if (product != null)
      {
         shoppingCart.addItem(product, quantity);
         model.addAttribute("info", "Product added to your shopping cart successfully!");
      }
      else
      {
         model.addAttribute("info", "Invalid product added!");
      }

      return "redirect:/product/welcome";
   }

   @RequestMapping(value = "/user/shopping/cart/remove", method = RequestMethod.POST)
   public String removeFromShoppingCart(@RequestParam(value = "productId", required = true) long productId, RedirectAttributes model)
   {
      shoppingCart.removeItem(productId);
      model.addAttribute("info", "Product removed from your shopping cart successfully!");

      return "redirect:/user/shopping/cart";
   }
}
