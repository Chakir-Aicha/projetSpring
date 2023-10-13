package com.example.diagnostique.projetdiagnostique.service;

import java.util.List;
import com.example.diagnostique.projetdiagnostique.models.Question;
import com.example.diagnostique.projetdiagnostique.DTO.Questions.QuestionDtoResponse;
import com.example.diagnostique.projetdiagnostique.DTO.Questions.QuestionDtoRequest;
public interface QuestionService {


    QuestionDtoResponse save(QuestionDtoRequest questionDtoRequest);
    public List<QuestionDtoResponse> getQuestionsByCategoryId(int categoryId);
    public Question getQuestionById(Integer QuestionId) ;
}
