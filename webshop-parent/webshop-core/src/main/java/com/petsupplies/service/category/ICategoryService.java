package com.petsupplies.service.category;

import java.util.List;

import com.petsupplies.model.category.Category;

/**
 * Category related services.
 *
 * @author rajassub (c) Jun 19, 2015, Sogeti B.V.
 */
public interface ICategoryService
{
   /**
    * Create a category
    * 
    * @param category to create
    * @return persisted category
    */
   Category create(Category category);

   /**
    * Delete a category
    * 
    * @param id - primary key of category
    */
   void delete(Long id);

   /**
    * Find a category by id
    * 
    * @param id primary key
    * @return category
    */
   Category findById(Long id);

   /**
    * Update a category.
    * 
    * @param category to be updated
    * @return persisted category
    */
   Category update(Category category);

   /**
    * Fetch all categories in system
    * 
    * @return list of categories
    */
   List<Category> findAll();
   

   /**
    * Fetch all parent categories in system
    * 
    * @return list of categories
    */
   List<Category> findAllParents();
}
