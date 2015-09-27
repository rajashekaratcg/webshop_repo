package com.petsupplies.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.petsupplies.model.product.Product;
import com.petsupplies.service.category.ICategoryService;
import com.petsupplies.service.product.IProductService;

@Controller
public class ProductController extends AbstractController {

	public static final String PRODUCT_EDIT = "/product/edit";
	public static final String REDIRECT$_PRODUCT_WELCOME = "redirect:/product/welcome";
	public static final String PRODUCT = "/product";
	public static final String PRODUCT_WELCOME = "/product/welcome";

	public static final String ATTRIB_PRODUCTS = "products";
	public static final String ATTRIB_PRODUCT = "product";

	@Autowired
	private IProductService productService;

	@Autowired
	private ICategoryService categoryService;
	

   @RequestMapping(value = "/api/products")
   public @ResponseBody Page<Product> getList(@RequestParam(value = PARAM_PAGE_NUM, defaultValue = PARAM_0) int pageNum, @RequestParam(value = PARAM_PAGE_SIZE, defaultValue = PARAM_10) int pageSize)
   {
      return productService.findAll(new PageRequest(pageNum, pageSize));
   }  
}
