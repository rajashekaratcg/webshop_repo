package com.petsupplies.admin.controller.product;

import java.beans.PropertyEditorSupport;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.petsupplies.model.category.Category;
import com.petsupplies.model.product.Product;
import com.petsupplies.service.category.ICategoryService;
import com.petsupplies.service.product.IProductService;

@Controller
@RequestMapping("/product")
public class ProductController
{

   @Autowired
   private IProductService productService;

   @Autowired
   private ICategoryService categoryService;

   @RequestMapping({ "/", "/welcome" })
   public String welcome(Model model, @RequestParam(value = "pageNum", defaultValue = "0") int pageNum, @RequestParam(value = "pageSize", defaultValue = "10") int pageSize)
   {
      model.addAttribute("products", productService.findAll(new PageRequest(pageNum, pageSize)));

      return "/product/welcome";
   }

   @RequestMapping("/delete")
   public String delete(Model model, @RequestParam(value = "id", required = true) long id)
   {
      productService.delete(id);

      model.addAttribute("info", "Product deleted successfully!");

      return "redirect:/product/welcome";
   }

   @RequestMapping(value = "/edit", method = RequestMethod.GET)
   public String edit(Model model, @RequestParam(value = "id", required = true) long id)
   {
      model.addAttribute("mode", "Edit");
      model.addAttribute("product", productService.findById(id));
      model.addAttribute("categories", categoryService.findAll());

      return "/product/edit";
   }

   @RequestMapping(value = "/edit", method = RequestMethod.POST)
   public String edit(Model model, @Valid @ModelAttribute("product") Product product, BindingResult result)
   {

      if (result.hasErrors())
      {
         model.addAttribute("mode", "Edit");
         model.addAttribute("categories", categoryService.findAll());
         return "/product/edit";
      }
      else
      {
         productService.update(product);
      }

      return "redirect:/product/welcome";
   }

   @RequestMapping(value = "/create", method = RequestMethod.GET)
   public String create(Model model)
   {
      model.addAttribute("mode", "Create");
      model.addAttribute("product", new Product());
      model.addAttribute("categories", categoryService.findAll());

      return "/product/edit";
   }

   @RequestMapping(value = "/create", method = RequestMethod.POST)
   public String create(Model model, @Valid @ModelAttribute("product") Product product, BindingResult result)
   {

      if (result.hasErrors())
      {
         model.addAttribute("mode", "Create");
         model.addAttribute("categories", categoryService.findAll());
         return "/product/edit";
      }
      else
      {
         productService.create(product);
      }

      return "redirect:/product/welcome";
   }

   @InitBinder(value = "product")
   protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception
   {

      binder.registerCustomEditor(Category.class, "category", new PropertyEditorSupport()
         {
            @Override
            public void setAsText(String text)
            {
               Category ch = categoryService.findById(Long.parseLong(text));
               setValue(ch);
            }
         });
   }

}
