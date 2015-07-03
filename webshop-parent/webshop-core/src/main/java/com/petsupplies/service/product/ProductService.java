package com.petsupplies.service.product;

import java.util.Collection;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.petsupplies.model.product.Product;
import com.petsupplies.repository.product.ProductRepository;

@Service("productService")
public class ProductService implements IProductService
{

   @Autowired
   private ProductRepository productRepository;

   @Override
   public Page<Product> findAll(Pageable result)
   {
      return productRepository.findAll(result);
   }

   @Override
   @Transactional
   public Product create(Product product)
   {
      product.setId(null);
      return productRepository.save(product);
   }

   @Override
   @Transactional
   public void delete(Long id)
   {
      productRepository.delete(id);
   }

   @Override
   public Product findById(Long id)
   {
      return productRepository.findOne(id);
   }

   @Override
   @Transactional
   public Product update(Product product)
   {
      return productRepository.save(product);
   }

   @Override
   public Page<Product> findByCategoryId(Long categoryId, Pageable result)
   {
      return productRepository.findByCategoryId(categoryId, result);
   }

   @Override
   public Page<Product> searchByNameOrDescription(String nameOrDescription, Pageable result)
   {
      return productRepository.findByNameContainingOrDescriptionContainingAllIgnoreCase(nameOrDescription, nameOrDescription, result);
   }

   @Override
   public List<Product> findById(Collection<Long> ids)
   {
      return Lists.<Product>newArrayList(productRepository.findAll(ids));
   }

}
