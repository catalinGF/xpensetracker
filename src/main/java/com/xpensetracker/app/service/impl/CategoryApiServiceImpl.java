package com.xpensetracker.app.service.impl;

import com.xpensetracker.app.entity.Category;
import com.xpensetracker.app.exception.CategoryNotFoundException;
import com.xpensetracker.app.model.CategoryDTO;
import com.xpensetracker.app.repository.CategoryRepository;
import com.xpensetracker.app.service.api.CategoryApiService;
import com.xpensetracker.app.util.CategoryConverter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryApiServiceImpl implements CategoryApiService {

    private final CategoryRepository categoryRepository;
    public CategoryApiServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    @Override
    public CategoryDTO createCategory(CategoryDTO categoryDTO) {
        Category category = CategoryConverter.convertDTOtoEntity(categoryDTO);
        Category createdCategory = categoryRepository.save(category);
        return CategoryConverter.convertEntitytoDTO(createdCategory);
    }

    @Override
    public CategoryDTO getCategoryById(long id) {
        Category foundCategory = categoryRepository.findById(id).orElseThrow(() -> new CategoryNotFoundException("Category with id " + id + " not found"));
        return CategoryConverter.convertEntitytoDTO(foundCategory);
    }

    @Override
    public CategoryDTO updateCategory(long id, CategoryDTO categoryDTO) {
        Category category = CategoryConverter.convertDTOtoEntity(categoryDTO);
        category.setId(id);
        Category updatedCategory = categoryRepository.save(category);
        return CategoryConverter.convertEntitytoDTO(updatedCategory);
    }

    @Override
    public void deleteCategoryById(long id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public List<CategoryDTO> getAllCategories() {
        List<Category> allcategories = categoryRepository.findAll();
        return allcategories.stream().map(CategoryConverter::convertEntitytoDTO).toList();
    }
}
