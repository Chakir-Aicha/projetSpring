package com.example.diagnostique.projetdiagnostique.DTO.Questions;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.example.diagnostique.projetdiagnostique.models.Category;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionDtoResponse {
    private String description;
    @JsonIgnore
    private Category categorie;
}

