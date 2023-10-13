package com.example.diagnostique.projetdiagnostique.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import com.example.diagnostique.projetdiagnostique.models.Reponse;
@Repository
public interface ReponseDAO extends JpaRepository<Reponse,Integer> {

    List<Reponse> findAllByUser_Id(Integer userId);
}


