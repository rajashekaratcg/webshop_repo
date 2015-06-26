package com.petsupplies.web.controller.common.error;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class ErrorController
{

   @RequestMapping({"/404"})
   public String pageNotFound(){      
      return "/common/error/404";
   } 
   
   @RequestMapping({"/403"})
   public String unauthorized(){      
      return "/common/error/404";
   }    
}
