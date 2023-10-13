package com.example.diagnostique.projetdiagnostique.service;

import jdk.jshell.Diag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import com.example.diagnostique.projetdiagnostique.models.Diagno;
import com.example.diagnostique.projetdiagnostique.repository.DiagnoDAO;
import com.example.diagnostique.projetdiagnostique.repository.CategoryDAO;
@Service
public class DiagnoServiceImpl implements DiagnoService{
    @Autowired
    DiagnoDAO diagnoDAO;
    CategoryDAO categoryDAO;
    @Override
    public List<Diagno> getDiagnoWithCategories() {
        return diagnoDAO.findAll();
    }

    @Override
    public Diagno save(Diagno diagno) {
        return diagnoDAO.save(diagno);
    }


}
