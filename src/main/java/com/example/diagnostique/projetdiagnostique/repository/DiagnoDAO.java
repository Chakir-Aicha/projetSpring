package com.example.diagnostique.projetdiagnostique.repository;
import com.example.diagnostique.projetdiagnostique.models.Diagno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiagnoDAO extends JpaRepository<Diagno,Integer> {
}
