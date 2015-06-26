package com.petsupplies.service.category;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.petsupplies.model.category.Category;
import com.petsupplies.repository.category.CategoryRepository;

@Service("categoryService")
public class CategoryService implements ICategoryService
{

   @Autowired
   private CategoryRepository categoryRepository;

   @Override
   @Transactional
   public Category create(Category category)
   {
      return categoryRepository.save(category);
   }

   @Override
   @Transactional
   public void delete(Long id)
   {
      categoryRepository.delete(id);
   }

   @Override
   public Category findById(Long id)
   {
      return categoryRepository.findOne(id);
   }

   @Override
   @Transactional
   public Category update(Category category)
   {
      return categoryRepository.save(category);
   }

   @Override
   public List<Category> findAll()
   {
      return Lists.newArrayList(categoryRepository.findAll());
   }

   @Override
   public List<Category> findAllParents()
   {
      return categoryRepository.findByParentIsNull();
   }

}
