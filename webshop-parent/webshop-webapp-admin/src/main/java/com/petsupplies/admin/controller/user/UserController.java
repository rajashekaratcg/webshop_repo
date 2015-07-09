package com.petsupplies.admin.controller.user;

import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.petsupplies.admin.controller.AbstractController;
import com.petsupplies.model.user.User;

@Controller
@RequestMapping(UserController.USER)
public class UserController extends AbstractController
{

   public static final String USER_DENIED = "/user/denied";
   public static final String DENIED = "/denied";
   public static final String SIGNOUT = "/signout";
   public static final String REDIRECT$_USER_SIGNIN = "redirect:/user/signin";
   public static final String AUTHENTICATION_FAILURE = "/authentication_failure";
   public static final String USER_SIGNIN = "/user/signin";
   public static final String SIGNIN = "/signin";
   public static final String USER = "/user";

   public static final String ATTRIB_ERROR = "error";
   public static final String ATTRIB_USER = "user";

   public static final String MSG_YOU_HAVE_SUCCESSFULLY_SIGNED_OUT = "msg.youHaveSuccessfullySignedOut";

   @RequestMapping(SIGNIN)
   public String signin(Model model)
   {
      model.addAttribute(ATTRIB_USER, new User());
      return USER_SIGNIN;
   }

   @RequestMapping(AUTHENTICATION_FAILURE)
   public String authenticationFailure(RedirectAttributes model)
   {
      model.addAttribute(ATTRIB_ERROR, true);
      return REDIRECT$_USER_SIGNIN;
   }

   @RequestMapping(SIGNOUT)
   public String signout(RedirectAttributes model, Locale locale, HttpSession session)
   {
      setInfoMsg(MSG_YOU_HAVE_SUCCESSFULLY_SIGNED_OUT, locale, model);

      session.invalidate();
      return REDIRECT$_USER_SIGNIN;
   }

   @RequestMapping(DENIED)
   public String denied()
   {
      return USER_DENIED;
   }
}
