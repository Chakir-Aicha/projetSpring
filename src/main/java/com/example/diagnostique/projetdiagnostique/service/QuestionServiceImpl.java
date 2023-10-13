package com.example.diagnostique.projetdiagnostique.service;


import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import com.example.diagnostique.projetdiagnostique.repository.QuestionDAO;
import com.example.diagnostique.projetdiagnostique.DTO.Questions.*;
import com.example.diagnostique.projetdiagnostique.models.Question;


@Service
public class QuestionServiceImpl implements QuestionService {
    private ModelMapper modelMapper;
    QuestionDAO questionDAO;

    public QuestionServiceImpl(  ModelMapper modelMapper,QuestionDAO questionDAO){
        this.questionDAO=questionDAO;
        this.modelMapper=modelMapper;

    }

    @Override
    public QuestionDtoResponse save(QuestionDtoRequest questionDtoRequest){
        Question question = modelMapper.map(questionDtoRequest, Question.class);
        Question saved = questionDAO.save(question);

        return modelMapper.map(saved, QuestionDtoResponse.class);


    }

    @Override
    public List<QuestionDtoResponse> getQuestionsByCategoryId(int categoryId) {
        List<Question> questions = questionDAO.findByCategorieId(categoryId);
        return questions.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public Question getQuestionById(Integer QuestionId) {
        return questionDAO.findById(QuestionId).orElse(null);

    }

    private QuestionDtoResponse convertToDto(Question question) {
        return modelMapper.map(question, QuestionDtoResponse.class);
    }
}
