package com.example.diagnostique.projetdiagnostique.models;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@Entity
@Data
@Table
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

@JsonIgnoreProperties ("diagno")

public class Category  implements Serializable {
    @Id
    @GeneratedValue
    private  int id;
    @Column(nullable = false)
    private String libelle;

    @OneToMany(mappedBy="categorie",cascade = CascadeType.ALL)
    private List<Question> Quest;

    @ManyToOne

    private Diagno diagno;
}
