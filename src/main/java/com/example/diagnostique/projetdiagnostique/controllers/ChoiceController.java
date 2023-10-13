package com.example.diagnostique.projetdiagnostique.controllers;

import com.example.diagnostique.projetdiagnostique.models.Choice;
import com.example.diagnostique.projetdiagnostique.repository.ChoiceDAO;
import com.example.diagnostique.projetdiagnostique.service.ChoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/choices")
public class ChoiceController {
    @Autowired
    private ChoiceService choiceService;
    @Autowired
    private ChoiceDAO choiceDAO;
    @PostMapping("/add")
    public Choice save(@RequestBody()Choice choice){
        return choiceDAO.save(choice);
    }
    @GetMapping("/list")
    public List<Choice> getList(){
        return  this.choiceService.choiceList();
    }

}
