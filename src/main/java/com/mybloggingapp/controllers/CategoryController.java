package com.mybloggingapp.controllers;

import com.mybloggingapp.payloads.ApiResponse;
import com.mybloggingapp.payloads.CategoryDto;
import com.mybloggingapp.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    //POST - Create Category
    @PostMapping("/")
    public ResponseEntity<CategoryDto> createCategory(@RequestBody CategoryDto categoryDto) {
        CategoryDto createCategoryDto = this.categoryService.createCategory(categoryDto);
        return new ResponseEntity<>(createCategoryDto, HttpStatus.CREATED);
    }

    //PUT - Update Category
    @PutMapping("/{categoryId}")
    public ResponseEntity<CategoryDto> updateCategory(@RequestBody CategoryDto categoryDto, @PathVariable("categoryId") Integer catid) {
        CategoryDto updatedCategory = this.categoryService.updateCategory(categoryDto, catid);
        return  ResponseEntity.ok(updatedCategory);
    }

    //DELETE - Delete Category
    @DeleteMapping("/{categoryId}")
    public ResponseEntity<ApiResponse> deleteCategory(@PathVariable ("categoryId") Integer catid) {
        this.categoryService.deleteCategory(catid);
        return new ResponseEntity(new ApiResponse("Category deleted successfully",true), HttpStatus.OK);
    }

    //GET- get single category
    @GetMapping("/{categoryId}")
    public ResponseEntity<CategoryDto> getCategory(@PathVariable Integer categoryId) {
        return ResponseEntity.ok(this.categoryService.getCategory(categoryId));
    }

    //GET - Get all Categories
    @GetMapping("/")
    public ResponseEntity<List<CategoryDto>> getCategories() {
        return ResponseEntity.ok(this.categoryService.getCategories());
    }
}
