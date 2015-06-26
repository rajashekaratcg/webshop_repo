package com.petsupplies.service.product;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.petsupplies.model.product.Product;

/**
 * Product related services.
 *
 * @author rajassub (c) Jun 19, 2015, Sogeti B.V.
 */
public interface IProductService
{

   /**
    * Fetch all products limited to the pagination boundaries provided.
    * 
    * @param result details, i.e. page number, page size, etc
    * @return Paginated list of products.
    */
   Page<Product> findAll(Pageable result);

   /**
    * Fetch all products by Category Id and limited to the pagination boundaries provided.
    *
    * @param categoryId category id
    * @param result details, i.e. page number, page size, etc
    * @return Paginated list of products.
    */
   Page<Product> findByCategoryId(Long categoryId, Pageable result);

   /**
    * Create a product.
    * 
    * @param product
    * @return persisted product
    */
   Product create(Product product);

   /**
    * Delete a product
    * 
    * @param id primary key
    */
   void delete(Long id);

   /**
    * Find product by primary key id
    * 
    * @param id primary key
    * @return product
    */
   Product findById(Long id);

   /**
    * Update a product.
    * 
    * @param product to update
    * @return persisted product
    */
   Product update(Product product);
}
