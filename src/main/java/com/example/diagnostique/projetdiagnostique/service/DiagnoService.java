package com.example.diagnostique.projetdiagnostique.service;

import java.util.List;
import com.example.diagnostique.projetdiagnostique.models.Diagno;
import org.springframework.stereotype.Service;

@Service
public interface DiagnoService {
    List<Diagno> getDiagnoWithCategories();
    Diagno save(Diagno diagno);
}