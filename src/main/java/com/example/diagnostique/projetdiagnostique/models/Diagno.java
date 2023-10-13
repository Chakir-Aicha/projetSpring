package com.example.diagnostique.projetdiagnostique.models;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

@Entity
@Data
@Table

@AllArgsConstructor
@NoArgsConstructor

@ToString
public class Diagno implements Serializable {
    @Id
    @GeneratedValue
    private int id;
    @Column(nullable = false)
    private int ScoreG;
    @OneToMany(mappedBy="diagno",cascade = CascadeType.ALL)
    private List<Category> categorie;
//    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
//    private  List<Diagno> users;



}
