package com.example.diagnostique.projetdiagnostique.repository;

import com.example.diagnostique.projetdiagnostique.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface CategoryDAO extends JpaRepository <Category,Integer>{

}