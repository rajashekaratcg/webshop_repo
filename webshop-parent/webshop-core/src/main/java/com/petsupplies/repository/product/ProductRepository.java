package com.petsupplies.repository.product;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.petsupplies.model.product.Product;

@Repository
public interface ProductRepository extends PagingAndSortingRepository<Product, Long> {

}
