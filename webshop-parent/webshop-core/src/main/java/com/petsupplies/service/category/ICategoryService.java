package com.petsupplies.service.category;

import java.util.List;

import com.petsupplies.model.category.Category;

public interface ICategoryService {
	Category create(Category category);

	void delete(Long id);

	Category findById(Long id);

	Category update(Category product);
	
	List<Category> findAll();
}
