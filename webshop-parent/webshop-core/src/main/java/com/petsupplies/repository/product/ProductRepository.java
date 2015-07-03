package com.petsupplies.repository.product;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.petsupplies.model.product.Product;

@Repository
public interface ProductRepository extends PagingAndSortingRepository<Product, Long>
{
   Page<Product> findByCategoryId(Long categoryId, Pageable result);
   
   Page<Product> findByNameContainingOrDescriptionContainingAllIgnoreCase(String nameOrDescription, String nameOrDescription2, Pageable result);

}
