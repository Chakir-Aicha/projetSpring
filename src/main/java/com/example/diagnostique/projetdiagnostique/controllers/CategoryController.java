package com.example.diagnostique.projetdiagnostique.controllers;

import com.example.diagnostique.projetdiagnostique.models.Category;
import com.example.diagnostique.projetdiagnostique.service.CategoryService;
import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.diagnostique.projetdiagnostique.DTO.CategoryDtoRequest;
import com.example.diagnostique.projetdiagnostique.DTO.CategoryDtoResponse;

import java.util.List;

@RestController
@RequestMapping("categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @PostMapping("/add")
    public CategoryDtoResponse save(@RequestBody()CategoryDtoRequest categoryDtoRequest){
        return categoryService.save(categoryDtoRequest);
    }
    @GetMapping("/list")
    public List<Category> getlist(){
        return this.categoryService.categories();
    }

}

