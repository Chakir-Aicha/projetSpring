package com.example.diagnostique.projetdiagnostique.DTO.Questions;

import com.example.diagnostique.projetdiagnostique.models.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionDtoRequest {

    private String description;
    private Category categorie;



}
