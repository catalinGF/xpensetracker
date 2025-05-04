package com.xpensetracker.app.controller.api;

import com.xpensetracker.app.model.CategoryDTO;
import com.xpensetracker.app.service.api.CategoryApiService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
@Tag(name = "Category", description = "Category operations")
public class CategoryApiController {

    private final CategoryApiService categoryApiService;

    public CategoryApiController(CategoryApiService categoryApiService) {
        this.categoryApiService = categoryApiService;
    }

    /*C R U D*/

    /*Create the category*/
    @PostMapping
    @Operation(summary = "Create a category in database")
    public CategoryDTO createCategory(@RequestBody CategoryDTO categoryDTO) {
        return categoryApiService.createCategory(categoryDTO);
    }

    /*READ or Get the category by id*/
    @GetMapping("/{id}")
    @Operation(summary = "Get a category from database by id")
    public CategoryDTO getCategoryById(@PathVariable long id) {
        return categoryApiService.getCategoryById(id);
    }

    /*Update the category*/
    @PutMapping("/{id}")
    @Operation(summary = "Update a category in database")
    public CategoryDTO updateCategory(@PathVariable long id, @RequestBody CategoryDTO categoryDTO) {
        return categoryApiService.updateCategory(id, categoryDTO);
    }

    /*Delete the category*/
    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a category from database")
    public void deleteCategoryById(@PathVariable long id) {
        categoryApiService.deleteCategoryById(id);
    }

    /*Get all the categories from database*/
    @GetMapping
    @Operation(summary = "Get all categories from database")
    public List<CategoryDTO> getAllCategories() {
        return categoryApiService.getAllCategories();
    }

}





