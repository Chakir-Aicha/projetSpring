package com.example.diagnostique.projetdiagnostique.DTO;

import com.example.diagnostique.projetdiagnostique.models.Diagno;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDtoRequest {

    private String libelle;
    private Diagno diagno;

}
