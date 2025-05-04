package com.xpensetracker.app.controller.web;

import com.xpensetracker.app.model.CategoryDTO;
import com.xpensetracker.app.service.web.CategoryWebService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CategoryWebController {


    private final CategoryWebService categoryWebService;

    public CategoryWebController(CategoryWebService categoryWebService) {
        this.categoryWebService = categoryWebService;
    }

    /*Bellow are the methods for interaction with Thymeleaf*/
    @GetMapping("/showcategories")
    public String listCategories(Model model) {
        List<CategoryDTO> categories = categoryWebService.getAllCategories();
        model.addAttribute("categories", categories);
        return "showcategories";
    }

 }


