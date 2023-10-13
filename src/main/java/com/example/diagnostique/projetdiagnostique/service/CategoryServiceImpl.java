package com.example.diagnostique.projetdiagnostique.service;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.diagnostique.projetdiagnostique.DTO.CategoryDtoResponse;
import com.example.diagnostique.projetdiagnostique.DTO.CategoryDtoRequest;
import com.example.diagnostique.projetdiagnostique.repository.CategoryDAO;
import com.example.diagnostique.projetdiagnostique.models.Category;

import java.util.List;
import java.util.Optional;
@Service
public class CategoryServiceImpl implements CategoryService{
    @Autowired
    private CategoryDAO categoryDAO;
    private ModelMapper modelMapper;
    public CategoryServiceImpl(CategoryDAO categoryDAO, ModelMapper modelMapper) {
        this.categoryDAO = categoryDAO;
        this.modelMapper = modelMapper;
    }

    @Override
    public CategoryDtoResponse save(CategoryDtoRequest categoryDtoRequest) {
        Category category=modelMapper.map(categoryDtoRequest,Category.class);
        Category saved=categoryDAO.save(category);
        return modelMapper.map(saved,CategoryDtoResponse.class);
    }
    @Override
    public String getCategoryNameById(Integer categoryId) {
        Optional<Category> categoryOptional = categoryDAO.findById(categoryId);
        return categoryOptional.map(Category::getLibelle).orElse(null);
    }

    @Override
    public List<Category> categories() {
        return categoryDAO.findAll();
    }
}

