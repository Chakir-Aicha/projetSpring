package com.example.diagnostique.projetdiagnostique.controllers;
import com.example.diagnostique.projetdiagnostique.DTO.ReponseDetailsDTO;
import com.example.diagnostique.projetdiagnostique.service.ReponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.diagnostique.projetdiagnostique.service.QuestionService;
import com.example.diagnostique.projetdiagnostique.DTO.Questions.*;

@RestController
@RequestMapping("Questions")
public class QuestionController {

    @Autowired
    QuestionService questionService;
    @PostMapping("/add")
    public QuestionDtoResponse save(@RequestBody() QuestionDtoRequest questionDtoRequest){
        return questionService.save(questionDtoRequest);
    }
    @GetMapping("/byCategory/{categoryId}")
    public List<QuestionDtoResponse> getQuestionsByCategoryId(@PathVariable int categoryId) {
        return questionService.getQuestionsByCategoryId(categoryId);
    }
}
