package com.xpensetracker.app.service;

import com.xpensetracker.app.model.CategoryDTO;

import java.util.List;

public interface CategoryService {

    CategoryDTO getCategoryById(long id);

    CategoryDTO createCategory(CategoryDTO categoryDTO);

    CategoryDTO updateCategory(long id, CategoryDTO categoryDTO);

    void deleteCategoryById(long id);

    List<CategoryDTO> getAllCategories();
}
