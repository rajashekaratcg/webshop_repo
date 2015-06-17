package com.petsupplies.service.product;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.petsupplies.model.product.Product;
import com.petsupplies.repository.product.ProductRepository;

@Service("productService")
@Transactional
public class ProductService implements IProductService {

   @Autowired
   private ProductRepository productRepository;

   @Override
   public Page<Product> findAll(Pageable result) {
      return productRepository.findAll(result);
   }

   @Override
   public Product create(Product product) {
      return productRepository.save(product);
   }

   @Override
   public void delete(Long id) {
      productRepository.delete(id);
   }

   @Override
   public Product findById(Long id) {
      return productRepository.findOne(id);
   }

}
