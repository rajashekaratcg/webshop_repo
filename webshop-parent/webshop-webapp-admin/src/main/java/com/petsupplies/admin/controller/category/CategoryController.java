package com.petsupplies.admin.controller.category;

import java.beans.PropertyEditorSupport;
import java.util.Locale;

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

import com.petsupplies.admin.controller.AbstractController;
import com.petsupplies.model.category.Category;
import com.petsupplies.service.category.ICategoryService;

@Controller
@RequestMapping(CategoryController.CATEGORY)
public class CategoryController extends AbstractController
{
   public static final String CREATE = "/create";
   public static final String CATEGORY_EDIT = "/category/edit";
   public static final String REDIRECT$_CATEGORY_WELCOME = "redirect:/category/welcome";
   public static final String CATEGORY = "/category";
   public static final String CATEGORY_WELCOME = "/category/welcome";

   public static final String ATTRIB_CATEGORIES = "categories";
   public static final String ATTRIB_CATEGORY = "category";
   public static final String ATTRIB_MINUS_1 = "-1";
   public static final String ATTRIB_PARENT = "parent";

   public static final String MSG_CATEGORY_DELETED_SUCCESSFULLY = "msg.categoryDeletedSuccessfully";
   public static final String MSG_CATEGORY_UPDATED_SUCCESSFULLY = "msg.categoryUpdatedSuccessfully";
   public static final String MSG_CATEGORY_CREATED_SUCCESSFULLY = "msg.categoryCreatedSuccessfully";

   @Autowired
   private ICategoryService categoryService;

   @RequestMapping({ ROOT, WELCOME })
   public String welcome(Model model)
   {
      model.addAttribute(ATTRIB_CATEGORIES, categoryService.findAll());
      return CATEGORY_WELCOME;
   }

   @RequestMapping(DELETE)
   public String delete(RedirectAttributes redirectAttributes, Locale locale, @RequestParam(value = PARAM_ID, required = true) long id)
   {
      // TODO Check if any products have chosen category reference and refuse deletion

      categoryService.delete(id);
      setInfoMsg(MSG_CATEGORY_DELETED_SUCCESSFULLY, locale, redirectAttributes);
      return REDIRECT$_CATEGORY_WELCOME;
   }

   @RequestMapping(value = EDIT, method = RequestMethod.GET)
   public String edit(Model model, @RequestParam(value = PARAM_ID, required = true) long id)
   {
      model.addAttribute(ATTRIB_MODE, ATTRIB_EDIT);
      model.addAttribute(ATTRIB_CATEGORY, categoryService.findById(id));
      model.addAttribute(ATTRIB_CATEGORIES, categoryService.findAll());

      return CATEGORY_EDIT;
   }

   @RequestMapping(value = EDIT, method = RequestMethod.POST)
   public String edit(Model model, Locale locale, RedirectAttributes redirectAttributes, @Valid @ModelAttribute(ATTRIB_CATEGORY) Category category, BindingResult result)
   {

      if (result.hasErrors())
      {
         model.addAttribute(ATTRIB_MODE, ATTRIB_EDIT);
         model.addAttribute(ATTRIB_CATEGORIES, categoryService.findAll());
         return CATEGORY_EDIT;
      }
      else
      {
         categoryService.update(category);
      }

      setInfoMsg(MSG_CATEGORY_UPDATED_SUCCESSFULLY, locale, redirectAttributes);

      return REDIRECT$_CATEGORY_WELCOME;
   }

   @RequestMapping(value = CREATE, method = RequestMethod.GET)
   public String create(Model model)
   {
      model.addAttribute(ATTRIB_MODE, ATTRIB_CREATE);
      model.addAttribute(ATTRIB_CATEGORY, new Category());
      model.addAttribute(ATTRIB_CATEGORIES, categoryService.findAll());

      return CATEGORY_EDIT;
   }

   @RequestMapping(value = CREATE, method = RequestMethod.POST)
   public String create(Model model, Locale locale, RedirectAttributes redirectAttributes, @Valid @ModelAttribute(ATTRIB_CATEGORY) Category category, BindingResult result)
   {
      if (result.hasErrors())
      {
         model.addAttribute(ATTRIB_MODE, ATTRIB_CREATE);
         model.addAttribute(ATTRIB_CATEGORIES, categoryService.findAll());
         return CATEGORY_EDIT;
      }
      else
      {
         categoryService.create(category);
      }

      setInfoMsg(MSG_CATEGORY_CREATED_SUCCESSFULLY, locale, redirectAttributes);

      return REDIRECT$_CATEGORY_WELCOME;
   }

   @InitBinder(value = ATTRIB_CATEGORY)
   protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder)
   {

      binder.registerCustomEditor(Category.class, ATTRIB_PARENT, new PropertyEditorSupport()
         {
            @Override
            public void setAsText(String text)
            {
               Category ch = null;
               if (!(StringUtils.isEmpty(text) || ATTRIB_MINUS_1.equals(text)))
               {
                  ch = categoryService.findById(Long.parseLong(text));
               }
               setValue(ch);
            }
         });
   }

}
