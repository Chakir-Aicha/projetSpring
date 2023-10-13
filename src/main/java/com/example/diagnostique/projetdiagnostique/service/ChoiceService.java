package com.example.diagnostique.projetdiagnostique.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.diagnostique.projetdiagnostique.repository.ChoiceDAO;

import java.util.List;
import java.util.Optional;
import com.example.diagnostique.projetdiagnostique.models.Choice;
@Service
public class ChoiceService {
    @Autowired
    ChoiceDAO choiceDAO;
    public Choice getChoiceById(Integer choiceId) {
        return choiceDAO.findById(choiceId).orElse(null);
    }
    public Integer getChoicePointsById(Integer choiceId) {
        Optional<Choice> choiceOptional = choiceDAO.findById(choiceId);
        return choiceOptional.map(Choice::getPoint).orElse(0);
    }
    public List<Choice> choiceList(){
        return choiceDAO.findAll();
    }

}
