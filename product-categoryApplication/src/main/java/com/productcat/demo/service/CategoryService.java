package com.productcat.demo.service;

import java.util.List;

import com.productcat.demo.exception.IDNotFoundException;
import com.productcat.demo.model.Category;

public interface CategoryService {

	void saveCategrioes(Category cat);

	Category singleCategory(Integer categoryId) throws IDNotFoundException;

	void deleteCategory(Integer categoryId) throws IDNotFoundException;

	void updateCategory(Integer categoryId, Category cat);

	List<Category> getALL(Integer page);

}
