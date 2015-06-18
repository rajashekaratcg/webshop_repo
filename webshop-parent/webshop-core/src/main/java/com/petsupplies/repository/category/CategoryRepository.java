package com.petsupplies.repository.category;

import org.springframework.data.repository.CrudRepository;

import com.petsupplies.model.category.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {

}
