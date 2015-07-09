package com.petsupplies.admin.controller.product;

import java.beans.PropertyEditorSupport;
import java.util.Locale;

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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.petsupplies.admin.controller.AbstractController;
import com.petsupplies.admin.controller.category.CategoryController;
import com.petsupplies.model.category.Category;
import com.petsupplies.model.product.Product;
import com.petsupplies.service.category.ICategoryService;
import com.petsupplies.service.product.IProductService;

@Controller
@RequestMapping(ProductController.PRODUCT)
public class ProductController extends AbstractController
{

   public static final String PRODUCT_EDIT = "/product/edit";
   public static final String REDIRECT$_PRODUCT_WELCOME = "redirect:/product/welcome";
   public static final String PRODUCT = "/product";
   public static final String PRODUCT_WELCOME = "/product/welcome";

   public static final String ATTRIB_PRODUCTS = "products";
   public static final String ATTRIB_PRODUCT = "product";

   public static final String MSG_PRODUCT_DELETED_SUCCESSFULLY = "msg.productDeletedSuccessfully";
   public static final String MSG_PRODUCT_CREATED_SUCCESSFULLY = "msg.productCreatedSuccessfully";
   public static final String MSG_PRODUCT_UPDATED_SUCCESSFULLY = "msg.productUpdatedSuccessfully";

   @Autowired
   private IProductService productService;

   @Autowired
   private ICategoryService categoryService;

   @RequestMapping({ ROOT, WELCOME })
   public String welcome(Model model, @RequestParam(value = PARAM_PAGE_NUM, defaultValue = PARAM_0) int pageNum, @RequestParam(value = PARAM_PAGE_SIZE, defaultValue = PARAM_10) int pageSize)
   {
      model.addAttribute(ATTRIB_PRODUCTS, productService.findAll(new PageRequest(pageNum, pageSize)));

      return PRODUCT_WELCOME;
   }

   @RequestMapping(DELETE)
   public String delete(RedirectAttributes redirectAttributes, Locale locale, @RequestParam(value = PARAM_ID, required = true) long id)
   {
      productService.delete(id);

      setInfoMsg(MSG_PRODUCT_DELETED_SUCCESSFULLY, locale, redirectAttributes);

      return REDIRECT$_PRODUCT_WELCOME;
   }

   @RequestMapping(value = EDIT, method = RequestMethod.GET)
   public String edit(Model model, @RequestParam(value = PARAM_ID, required = true) long id)
   {
      model.addAttribute(ATTRIB_MODE, ATTRIB_EDIT);
      model.addAttribute(ATTRIB_PRODUCT, productService.findById(id));
      model.addAttribute(CategoryController.ATTRIB_CATEGORIES, categoryService.findAll());

      return PRODUCT_EDIT;
   }

   @RequestMapping(value = EDIT, method = RequestMethod.POST)
   public String edit(Model model, Locale locale, RedirectAttributes redirectAttributes, @Valid @ModelAttribute(ATTRIB_PRODUCT) Product product, BindingResult result)
   {

      if (result.hasErrors())
      {
         model.addAttribute(ATTRIB_MODE, ATTRIB_EDIT);
         model.addAttribute(CategoryController.ATTRIB_CATEGORIES, categoryService.findAll());
         return PRODUCT_EDIT;
      }
      else
      {
         productService.update(product);
      }

      setInfoMsg(MSG_PRODUCT_UPDATED_SUCCESSFULLY, locale, model);

      return REDIRECT$_PRODUCT_WELCOME;
   }

   @RequestMapping(value = CREATE, method = RequestMethod.GET)
   public String create(Model model)
   {
      model.addAttribute(ATTRIB_MODE, ATTRIB_CREATE);
      model.addAttribute(ATTRIB_PRODUCT, new Product());
      model.addAttribute(CategoryController.ATTRIB_CATEGORIES, categoryService.findAll());

      return PRODUCT_EDIT;
   }

   @RequestMapping(value = CREATE, method = RequestMethod.POST)
   public String create(Model model, Locale locale, RedirectAttributes redirectAttributes, @Valid @ModelAttribute(ATTRIB_PRODUCT) Product product, BindingResult result)
   {

      if (result.hasErrors())
      {
         model.addAttribute(ATTRIB_MODE, ATTRIB_CREATE);
         model.addAttribute(CategoryController.ATTRIB_CATEGORIES, categoryService.findAll());
         return PRODUCT_EDIT;
      }
      else
      {
         productService.create(product);
      }

      setInfoMsg(MSG_PRODUCT_CREATED_SUCCESSFULLY, locale, redirectAttributes);

      return REDIRECT$_PRODUCT_WELCOME;
   }

   @InitBinder(value = ATTRIB_PRODUCT)
   protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder)
   {

      binder.registerCustomEditor(Category.class, CategoryController.ATTRIB_CATEGORY, new PropertyEditorSupport()
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
