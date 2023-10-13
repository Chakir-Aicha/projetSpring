package com.example.diagnostique.projetdiagnostique.service;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.example.diagnostique.projetdiagnostique.repository.ReponseDAO;
import com.example.diagnostique.projetdiagnostique.models.Choice;
import com.example.diagnostique.projetdiagnostique.models.Question;
import com.example.diagnostique.projetdiagnostique.models.User;
import com.example.diagnostique.projetdiagnostique.models.Reponse;
import com.example.diagnostique.projetdiagnostique.models.ResKey;
import com.example.diagnostique.projetdiagnostique.DTO.ReponseDetailsDTO;
@Service
public class ReponseService {
    @Autowired
    ReponseDAO reponseDAO;
    @Autowired
    QuestionService questionService;
    @Autowired
    ChoiceService choiceService;
    @Autowired
    UserService userService;
    @Autowired
    CategoryService categoryService;





    public void saveResponse(Integer choiceId, Integer questionId,Integer userId) {
        Choice choice = choiceService.getChoiceById(choiceId);
        Question question = questionService.getQuestionById(questionId);
        User user=userService.getUserById(userId);

        Reponse reponse = new Reponse();

        // Create and set the ResKey
        ResKey resKey = new ResKey();
        resKey.setChoiceId(choiceId);
        resKey.setQuestId(questionId);

        reponse.setResKey(resKey);
        reponse.setChoice(choice);
        reponse.setQuestion(question);
        reponse.setUserId(userId);

        reponseDAO.save(reponse);
    }

    public List<ReponseDetailsDTO> getReponsesByUserId(Integer userId) {
        List<Reponse> reponses = reponseDAO.findAllByUser_Id(userId);
        List<ReponseDetailsDTO> reponseDetailsDTOs = new ArrayList<>();

        for (Reponse reponse : reponses) {
            ReponseDetailsDTO dto = new ReponseDetailsDTO();
            dto.setChoiceId(reponse.getResKey().getChoiceId());
            dto.setQuestionId(reponse.getResKey().getQuestId());
//            dto.setUserId(userId);
            dto.setCategoryId(reponse.getQuestion().getCategorie().getId());  // Ajout de l'ID de la catégorie
            reponseDetailsDTOs.add(dto);
        }

        return reponseDetailsDTOs;
    }
    public Map<String, Object> calculateScoreByCategory(Integer userId) {
        List<ReponseDetailsDTO> reponseDetailsDTOs = getReponsesByUserId(userId);
        Map<Integer, Integer> categoryScores = new HashMap<>();
        int scoreg=0;


        // Calculer les scores par catégorie
        for (ReponseDetailsDTO reponseDetailsDTO : reponseDetailsDTOs) {
            Integer categoryId = reponseDetailsDTO.getCategoryId();
            Integer choiceId = reponseDetailsDTO.getChoiceId();

            Integer choicePoints = choiceService.getChoicePointsById(choiceId);

            // Ajouter les points du choix à la catégorie correspondante
            categoryScores.put(categoryId, categoryScores.getOrDefault(categoryId, 0) + choicePoints);
        }


        // Créer le résultat dans le format souhaité
        Map<String, Object> result = new HashMap<>();
        int tailleDeLaMap = 0;
        for (Map.Entry<Integer, Integer> entry : categoryScores.entrySet()) {
            Integer categoryId = entry.getKey();
            Integer score = entry.getValue();
            
            scoreg= scoreg + score;

            // Récupérer le nom de la catégorie
            String categoryName =categoryService.getCategoryNameById(categoryId);
             tailleDeLaMap = categoryScores.size();
            // Ajouter au résultat dans le format "categoryName:scoreId"
            result.put("" + categoryName + ",score " , score);
        }
        result.put("Score global",scoreg/tailleDeLaMap);
        return result;
    }


}

