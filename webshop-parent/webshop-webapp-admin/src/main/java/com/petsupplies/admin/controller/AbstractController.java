package com.petsupplies.admin.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.ui.Model;

public abstract class AbstractController
{
   public static final String WELCOME = "welcome";
   public static final String ROOT = "/";
   public static final String EDIT = "/edit";
   public static final String DELETE = "/delete";
   public static final String CREATE = "/create";   

   public static final String ATTRIB_INFO = "info";
   public static final String ATTRIB_CREATE = "Create";
   public static final String ATTRIB_EDIT = "Edit";
   public static final String ATTRIB_MODE = "mode";

   public static final String PARAM_ID = "id";
   public static final String PARAM_10 = "10";
   public static final String PARAM_PAGE_SIZE = "pageSize";
   public static final String PARAM_0 = "0";
   public static final String PARAM_PAGE_NUM = "pageNum";   

   @Autowired
   protected MessageSource messageSource;

   protected String getMsg(String code, Locale locale)
   {
      return messageSource.getMessage(code, null, locale);
   }

   protected void setInfoMsg(String code, Locale locale, Model model)
   {
      model.addAttribute(ATTRIB_INFO, getMsg(code, locale));
   }
}
