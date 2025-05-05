package com.xpensetracker.app.controller.web;

import com.xpensetracker.app.model.CategoryDTO;
import com.xpensetracker.app.service.web.CategoryWebService;
import com.xpensetracker.app.service.web.UserWebService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Comparator;
import java.util.List;

@Controller
public class CategoryWebController {


    private final CategoryWebService categoryWebService;
    private final UserWebService userWebService;

    public CategoryWebController(CategoryWebService categoryWebService, UserWebService userWebService) {
        this.categoryWebService = categoryWebService;
        this.userWebService = userWebService;
    }

    /*Bellow are the methods for interaction with Thymeleaf*/
    @GetMapping("/showcategories")
    public String listCategories(Model model) {
        List<CategoryDTO> categories = categoryWebService.getAllCategories()
                .stream()
                .sorted(Comparator.comparing(CategoryDTO::id)).toList();
        model.addAttribute("categories", categories);
        model.addAttribute("category", new CategoryDTO(null, null, null, null, false));
        model.addAttribute("users", userWebService.getAllUsers());
        return "showcategories";
    }

    @PostMapping("/categories/save")
    public String saveCategory(@ModelAttribute("category") CategoryDTO categoryDTO) {
        categoryWebService.createCategory(categoryDTO);
        return "redirect:/showcategories";
    }

    @GetMapping("/categories/delete/{id}")
    public String deleteCategory(@PathVariable Long id) {
        categoryWebService.deleteCategoryById(id);
        return "redirect:/showcategories";
    }

 }


