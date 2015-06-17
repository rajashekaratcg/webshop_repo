package com.petsupplies.service.product;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.petsupplies.model.product.Product;

public interface IProductService {

   Page<Product> findAll(Pageable result);

   Product create(Product product);

   void delete(Long id);

   Product findById(Long id);
}
