package com.xpensetracker.app.util;

import com.xpensetracker.app.entity.Category;
import com.xpensetracker.app.model.CategoryDTO;

public class CategoryConverter {

    private CategoryConverter() {
    }
    
    public static CategoryDTO convertEntitytoDTO(Category category) {
        return new CategoryDTO(category.getId(), category.getName());
    }
    
    public static Category convertDTOtoEntity(CategoryDTO categoryDTO) {
        return new Category(categoryDTO.id(), categoryDTO.name());
    }
}
