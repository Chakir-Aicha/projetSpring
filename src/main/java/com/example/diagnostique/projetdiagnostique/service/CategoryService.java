package com.example.diagnostique.projetdiagnostique.service;


import com.example.diagnostique.projetdiagnostique.DTO.CategoryDtoResponse;
import com.example.diagnostique.projetdiagnostique.DTO.CategoryDtoRequest;
import com.example.diagnostique.projetdiagnostique.models.Category;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

public interface CategoryService {

    CategoryDtoResponse save(CategoryDtoRequest categoryDtoRequest);
    String getCategoryNameById(Integer categoryId);
    List<Category> categories();
}