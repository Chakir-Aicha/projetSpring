package com.example.diagnostique.projetdiagnostique.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.diagnostique.projetdiagnostique.models.Choice;
@Repository
public interface ChoiceDAO extends JpaRepository<Choice,Integer> {
        }
