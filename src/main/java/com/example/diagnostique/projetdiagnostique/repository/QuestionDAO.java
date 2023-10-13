package com.example.diagnostique.projetdiagnostique.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.example.diagnostique.projetdiagnostique.models.Question;
@Repository
public interface QuestionDAO extends JpaRepository<Question,Integer> {


    List<Question> findByCategorieId(int categoryId);

}
