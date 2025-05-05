package com.xpensetracker.app.util;

import com.xpensetracker.app.entity.Category;
import com.xpensetracker.app.entity.User;
import com.xpensetracker.app.model.CategoryDTO;

import java.util.Optional;

public class CategoryConverter {

    private CategoryConverter() {
    }

    public static CategoryDTO convertEntitytoDTO(Category category) {
        Long userId = category.getUser() != null ? category.getUser().getId() : null;
        String userName = category.getUser() != null ? category.getUser().getName() : null;
        Boolean hasExpenses = category.getExpenses() != null && !category.getExpenses().isEmpty();
        return new CategoryDTO(category.getId(), category.getName(), userId, userName, hasExpenses);
    }

    public static Category convertDTOtoEntity(CategoryDTO categoryDTO) {
        Category category = new Category();
        category.setId(categoryDTO.id());
        category.setName(categoryDTO.name());

        Optional.ofNullable(categoryDTO.userId()).ifPresent(userId -> {
            User user = new User();
            user.setId(userId);
            category.setUser(user);
        });

        return category;
    }

}
