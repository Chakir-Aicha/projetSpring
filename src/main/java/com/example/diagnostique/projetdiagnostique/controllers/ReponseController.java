package com.example.diagnostique.projetdiagnostique.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.example.diagnostique.projetdiagnostique.service.ReponseService;
import com.example.diagnostique.projetdiagnostique.DTO.ReponseDetailsDTO;

@RestController
@RequestMapping("Responses")
public class ReponseController {
    @Autowired
    private ReponseService reponseService;



    @PostMapping("/add")
    public void saveResponse(@RequestBody Map<String, Integer> requestBody) {
        Integer choiceId = requestBody.get("choiceId");
        Integer questionId = requestBody.get("questionId");

        Integer userId = requestBody.get("userId");  // Ajoutez cette ligne pour récupérer userId

        reponseService.saveResponse(choiceId, questionId, userId);
//        {
//            "choiceId": 1,
//                "questionId": 3,
//                "userId":1
//        }
    }
    @GetMapping("/details/{userId}")
    public Map<String, Map<String, List<String>>> getReponseDetailsByUserId(@PathVariable Integer userId) {
        List<ReponseDetailsDTO> reponseDetailsDTOs = reponseService.getReponsesByUserId(userId);

        // Map pour stocker les questions par catégorie et choix avec les noms et les IDs
        Map<String, Map<String, List<String>>> categoryQuestionMap = new HashMap<>();

        for (ReponseDetailsDTO reponseDetailsDTO : reponseDetailsDTOs) {
            String categoryName = "CategoryID: " + reponseDetailsDTO.getCategoryId();
            String questionName = "QuestionID: " + reponseDetailsDTO.getQuestionId();
            String choiceName = "ChoiceID: " + reponseDetailsDTO.getChoiceId();

            // Si la catégorie n'existe pas dans la map, on l'ajoute
            categoryQuestionMap.putIfAbsent(categoryName, new HashMap<>());

            // Si la question n'existe pas dans la catégorie, on l'ajoute
            categoryQuestionMap.get(categoryName).putIfAbsent(questionName, new ArrayList<>());

            // On ajoute le nom du choix à la question correspondante
            categoryQuestionMap.get(categoryName).get(questionName).add(choiceName);
        }

        return categoryQuestionMap;
    }
    @GetMapping("/scoreByCategory_global/{userId}")
    public Map<String, Object>  getScoreByCategory(@PathVariable Integer userId) {
        return reponseService.calculateScoreByCategory(userId);
    }


}

