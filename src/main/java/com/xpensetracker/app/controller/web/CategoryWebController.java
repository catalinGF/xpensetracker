package com.xpensetracker.app.controller.web;

import com.xpensetracker.app.model.CategoryDTO;
import com.xpensetracker.app.service.CategoryService;
import com.xpensetracker.app.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;

@Controller
public class CategoryWebController {


    private final CategoryService categoryService;
    private final UserService userService;

    public CategoryWebController(CategoryService categoryService, UserService userService) {
        this.categoryService = categoryService;
        this.userService = userService;
    }

    /*Bellow are the methods for interaction with Thymeleaf*/
    @RequestMapping("/showcategories")
    public String listCategories(Model model) {
        List<CategoryDTO> categories = categoryService.getAllCategories()
                .stream()
                .sorted(Comparator.comparing(CategoryDTO::id)).toList();
        model.addAttribute("categories", categories);
        model.addAttribute("category", new CategoryDTO(null, null, null, null, false));
        model.addAttribute("users", userService.getAllUsers());
        return "showcategories";
    }

    @RequestMapping("/categories/save")
    public String saveCategory(@ModelAttribute("category") CategoryDTO categoryDTO) {
        categoryService.createCategory(categoryDTO);
        return "redirect:/showcategories";
    }

    @RequestMapping("/categories/delete/{id}")
    public String deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategoryById(id);
        return "redirect:/showcategories";
    }

 }


