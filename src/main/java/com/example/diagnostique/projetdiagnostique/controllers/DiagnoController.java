package com.example.diagnostique.projetdiagnostique.controllers;

import com.example.diagnostique.projetdiagnostique.models.Choice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import com.example.diagnostique.projetdiagnostique.models.Diagno;
import com.example.diagnostique.projetdiagnostique.service.DiagnoService;
@RestController
@RequestMapping ("/diagno")
public class DiagnoController {
    @Autowired
    DiagnoService diagnoService;
    @PostMapping("/add")
    public Diagno save(@RequestBody Diagno diagno){
        return diagnoService.save(diagno);
    }
    @GetMapping("/")
    public List<Diagno> getDiagnoWithCategories() {
        return diagnoService.getDiagnoWithCategories();
    }
}

