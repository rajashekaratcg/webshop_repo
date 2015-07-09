package com.petsupplies.web.controller.user;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.common.collect.Lists;
import com.petsupplies.model.order.Address;
import com.petsupplies.model.order.Order;
import com.petsupplies.model.order.OrderItem;
import com.petsupplies.model.product.Product;
import com.petsupplies.model.user.User;
import com.petsupplies.model.user.UserAddress;
import com.petsupplies.model.user.UserPhone;
import com.petsupplies.service.order.IOrderService;
import com.petsupplies.service.user.IUserService;
import com.petsupplies.web.controller.AbstractController;
import com.petsupplies.web.model.user.ShoppingCartItem;

@Controller
public class UserController extends AbstractController
{
   public static final String USER_SHOPPING_CART_CHECKOUT_SELECT_ADDRESS_ID = "/user/shopping/cart/checkout/selectAddress/{id}";
   public static final String USER_SHOPPING_CART_CHECKOUT_SELECT_ADDRESS = "/user/shopping/cart/checkout/selectAddress";
   public static final String USER_SHOPPING_CART_CHECKOUT = "/user/shopping/cart/checkout";
   public static final String USER_SHOPPING_CART_CHECKOUT_CHECKOUT = "/user/shopping/cart/checkout/checkout";
   public static final String REDIRECT$_USER_SHOPPING_CART = "redirect:/user/shopping/cart";
   public static final String USER_SHOPPING_CART_REMOVE = "/user/shopping/cart/remove";
   public static final String REDIRECT$_PRODUCT_WELCOME = "redirect:/product/welcome";
   public static final String USER_SHOPPING_CART_ADD = "/user/shopping/cart/add";
   public static final String USER_SHOPPING_CART_VIEW = "/user/shopping/cart/view";
   public static final String USER_SHOPPING = "/user/shopping";
   public static final String USER_SHOPPING_CART = "/user/shopping/cart";
   public static final String USER_PROFILE = "/user/profile";
   public static final String USER_DENIED = "/user/denied";
   public static final String DENIED = "/denied";
   public static final String USER_SIGNOUT = "/user/signout";
   public static final String SIGNOUT = "/signout";
   public static final String AUTHENTICATION_FAILURE = "/authentication_failure";
   public static final String USER_AUTHENTICATION_FAILURE = "/user/authentication_failure";
   public static final String USER_SIGNIN = "/user/signin";
   public static final String SIGNIN = "/signin";
   public static final String REDIRECT$_USER_SIGNIN = "redirect:/user/signin";
   public static final String SIGNUP = "/signup";
   public static final String USER_SIGNUP = "/user/signup";

   public static final String ATTRIB_USER = "user";
   public static final String ATTRIB_ERROR = "error";
   public static final String ATTRIB_SHOPPING_CART = "shoppingCart";
   public static final String ATTRIB_ADDRESSES = "addresses";
   public static final String ATTRIB_ORDER = "order";

   public static final String PARAM_QUANTITY = "quantity";
   public static final String PARAM_PRODUCT_ID = "productId";

   public static final String MSG_USER_CREATED_SUCCESSFULLY = "msg.userCreatedSuccessfully";
   public static final String MSG_SORRY_NOT_AUTHORIZED_ACCESS = "msg.sorryNotAuthorizedAccess";
   public static final String MSG_PRODUCT_REMOVED_SUCCESSFULLY = "msg.productRemovedSuccessfully";
   public static final String MSG_INVALID_PRODUCT_ADDED = "msg.invalidProductAdded";
   public static final String MSG_PRODUCT_ADDED_TO_SHOPPING_CART_SUCCESSFULLY = "msg.productAddedToShoppingCartSuccessfully";
   public static final String MSG_YOU_SUCCESSFULLY_SIGNED_OUT = "msg.youSuccessfullySignedOut";

   @Autowired
   private IUserService userService;

   @Autowired
   private IOrderService orderService;

   @RequestMapping({ SIGNUP, USER_SIGNUP })
   public String signup(Model model)
   {
      model.addAttribute(ATTRIB_USER, createUser());
      return USER_SIGNUP;
   }

   private User createUser()
   {
      User user = new User();
      user.setUserAddress(Lists.newArrayList(new UserAddress()));
      user.setUserPhones(Lists.newArrayList(new UserPhone()));
      return user;
   }

   @RequestMapping(value = { SIGNUP, USER_SIGNUP }, method = RequestMethod.POST)
   public String signup(Model model, RedirectAttributes redirectAttributes, Locale locale, @Valid @ModelAttribute(ATTRIB_USER) User user, BindingResult result)
   {
      if (result.hasErrors())
      {
         model.addAttribute(ATTRIB_USER, user);
         return USER_SIGNUP;
      }
      else
      {
         userService.createUser(user);
      }

      redirectAttributes.addAttribute(ATTRIB_INFO, user.getUsername() + getMsg(MSG_USER_CREATED_SUCCESSFULLY, locale));

      return REDIRECT$_USER_SIGNIN;
   }

   @RequestMapping({ SIGNIN, USER_SIGNIN })
   public String signin(Model model)
   {
      model.addAttribute(ATTRIB_USER, new User());
      return USER_SIGNIN;
   }

   @RequestMapping({ AUTHENTICATION_FAILURE, USER_AUTHENTICATION_FAILURE })
   public String authenticationFailure(RedirectAttributes model)
   {
      model.addAttribute(ATTRIB_ERROR, true);
      return REDIRECT$_USER_SIGNIN;
   }

   @RequestMapping({ SIGNOUT, USER_SIGNOUT })
   public String signout(RedirectAttributes model, Locale locale, HttpSession session)
   {
      model.addAttribute(ATTRIB_INFO, getMsg(MSG_YOU_SUCCESSFULLY_SIGNED_OUT, locale));
      session.invalidate();
      return REDIRECT$_WELCOME;
   }

   @RequestMapping({ DENIED, USER_DENIED })
   public String denied(Model model, Locale locale)
   {
      model.addAttribute(ATTRIB_INFO, getMsg(MSG_SORRY_NOT_AUTHORIZED_ACCESS, locale));
      return USER_DENIED;
   }

   @RequestMapping({ USER_PROFILE })
   public String profile(Model model)
   {
      return WELCOME;
   }

   @RequestMapping({ USER_SHOPPING_CART, USER_SHOPPING })
   public String shoppingCart(Model model)
   {
      populateCommonAttributes(model);

      model.addAttribute(ATTRIB_SHOPPING_CART, shoppingCart);
      return USER_SHOPPING_CART_VIEW;
   }

   @RequestMapping(value = USER_SHOPPING_CART_ADD, method = RequestMethod.POST)
   public String addToShoppingCart(Locale locale, @RequestParam(value = PARAM_PRODUCT_ID, required = true) long productId, @RequestParam(value = PARAM_QUANTITY, required = true) int quantity,
         RedirectAttributes model)
   {
      Product product = productService.findById(productId);
      if (product != null)
      {
         shoppingCart.addItem(product, quantity);
         model.addAttribute(ATTRIB_INFO, getMsg(MSG_PRODUCT_ADDED_TO_SHOPPING_CART_SUCCESSFULLY, locale));
      }
      else
      {
         model.addAttribute(ATTRIB_INFO, getMsg(MSG_INVALID_PRODUCT_ADDED, locale));
      }

      return REDIRECT$_PRODUCT_WELCOME;
   }

   @RequestMapping(value = USER_SHOPPING_CART_REMOVE, method = RequestMethod.POST)
   public String removeFromShoppingCart(Locale locale, @RequestParam(value = PARAM_PRODUCT_ID, required = true) long productId, RedirectAttributes model)
   {
      shoppingCart.removeItem(productId);
      model.addAttribute(ATTRIB_INFO, getMsg(MSG_PRODUCT_REMOVED_SUCCESSFULLY, locale));

      return REDIRECT$_USER_SHOPPING_CART;
   }

   @RequestMapping(value = USER_SHOPPING_CART_CHECKOUT)
   public String checkoutStep1(Model model)
   {
      User user = userService.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
      model.addAttribute(ATTRIB_ADDRESSES, user.getUserAddress());
      return USER_SHOPPING_CART_CHECKOUT_SELECT_ADDRESS;
   }

   @RequestMapping(value = USER_SHOPPING_CART_CHECKOUT_SELECT_ADDRESS_ID)
   public String checkoutStep2(Model model, @PathVariable(PARAM_ID) long addressId)
   {
      User user = userService.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());

      populateOrder(addressId, user, model);

      return USER_SHOPPING_CART_CHECKOUT_CHECKOUT;
   }

   private void populateOrder(long addressId, User user, Model model)
   {
      Address shippingAddress = new Address();
      for (UserAddress userAddress : user.getUserAddress())
      {
         if (userAddress.getId().equals(addressId))
         {
            shippingAddress.setAddress(userAddress.getAddress());
            shippingAddress.setCity(userAddress.getCity());
            shippingAddress.setCountry(userAddress.getCountry());
            shippingAddress.setState(userAddress.getState());
            shippingAddress.setZipcode(userAddress.getZipcode());
            break;
         }
      }

      Order newOrder = new Order();
      newOrder.setShippingAddress(shippingAddress);
      newOrder.setBillingAddress(new Address());
      model.addAttribute(ATTRIB_ORDER, newOrder);
   }

   @RequestMapping(value = USER_SHOPPING_CART_CHECKOUT, method = RequestMethod.POST)
   public String checkoutStep2(Model model, RedirectAttributes redirectModel, Locale locale, @Valid @ModelAttribute(ATTRIB_ORDER) Order order, BindingResult result)
   {

      String username = SecurityContextHolder.getContext().getAuthentication().getName();
      User user = userService.findByUsername(username);

      List<OrderItem> orderItems = Lists.newArrayList();
      for (ShoppingCartItem item : shoppingCart.getItems())
      {
         OrderItem orderItem = new OrderItem();
         orderItem.setAmount(item.getProduct().getPrice().multiply(BigDecimal.valueOf(item.getQuantity())));
         orderItem.setOrder(order);
         orderItem.setProduct(item.getProduct());
         orderItem.setQuantity(item.getQuantity());
         orderItems.add(orderItem);
      }
      order.setItem(orderItems);

      order.setOrderDate(new Date());
      order.setOrderNumber(username + (new Date()).getTime());
      order.setOrderStatus(Order.Status.PLACED);
      order.setUser(user);

      orderService.placeOrder(order);      

      redirectModel.addAttribute(ATTRIB_INFO, "Order placed successfully!");
      return REDIRECT$_WELCOME;
   }

}
