package com.petsupplies.admin.controller.category;

import java.beans.PropertyEditorSupport;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.petsupplies.model.category.Category;
import com.petsupplies.service.category.ICategoryService;

@Controller
@RequestMapping("/category")
public class CategoryController
{

   @Autowired
   private ICategoryService categoryService;

   @RequestMapping({ "/", "/welcome" })
   public String welcome(Model model)
   {

      model.addAttribute("categories", categoryService.findAll());

      return "/category/welcome";
   }

   @RequestMapping("/delete")
   public String delete(RedirectAttributes redirectAttributes, @RequestParam(value = "id", required = true) long id)
   {
      // TODO Check if any products have chosen category reference and refuse deletion

      categoryService.delete(id);

      redirectAttributes.addAttribute("info", "Category " + id + " deleted successfully!");
      return "redirect:/category/welcome";
   }

   @RequestMapping(value = "/edit", method = RequestMethod.GET)
   public String edit(Model model, @RequestParam(value = "id", required = true) long id)
   {
      model.addAttribute("mode", "Edit");
      model.addAttribute("category", categoryService.findById(id));
      model.addAttribute("categories", categoryService.findAll());

      return "/category/edit";
   }

   @RequestMapping(value = "/edit", method = RequestMethod.POST)
   public String edit(Model model, RedirectAttributes redirectAttributes, @Valid @ModelAttribute("category") Category category, BindingResult result)
   {

      if (result.hasErrors())
      {
         model.addAttribute("mode", "Edit");
         model.addAttribute("categories", categoryService.findAll());
         return "/category/edit";
      }
      else
      {
         categoryService.update(category);
      }

      redirectAttributes.addAttribute("info", "Category " + category.getName() + " updated successfully!");

      return "redirect:/category/welcome";
   }

   @RequestMapping(value = "/create", method = RequestMethod.GET)
   public String create(Model model)
   {
      model.addAttribute("mode", "Create");
      model.addAttribute("category", new Category());
      model.addAttribute("categories", categoryService.findAll());

      return "/category/edit";
   }

   @RequestMapping(value = "/create", method = RequestMethod.POST)
   public String create(Model model, RedirectAttributes redirectAttributes, @Valid @ModelAttribute("category") Category category, BindingResult result)
   {
      if (result.hasErrors())
      {
         model.addAttribute("mode", "Create");
         model.addAttribute("categories", categoryService.findAll());
         return "/category/edit";
      }
      else
      {
         categoryService.create(category);
      }

      redirectAttributes.addAttribute("info", "Category " + category.getName() + " created successfully!");

      return "redirect:/category/welcome";
   }

   @InitBinder(value = "category")
   protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception
   {

      binder.registerCustomEditor(Category.class, "parent", new PropertyEditorSupport()
         {
            @Override
            public void setAsText(String text)
            {
               Category ch = null;
               if (!(StringUtils.isEmpty(text) || "-1".equals(text)))
               {
                  ch = categoryService.findById(Long.parseLong(text));
               }
               setValue(ch);
            }
         });
   }

}
