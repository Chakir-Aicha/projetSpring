package com.example.diagnostique.projetdiagnostique.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReponseDetailsDTO {
    private Integer choiceId;
    private Integer questionId;
    private Integer categoryId;

}

