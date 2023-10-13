package com.example.diagnostique.projetdiagnostique.models;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonIgnoreProperties("reponses")
public class Choice implements Serializable {
    @Id
    @GeneratedValue
    private int id;
    @Column(nullable = false)
    private String Description;
    @Column(nullable = false)
    private int Point;
    @OneToMany(mappedBy = "choice",fetch = FetchType.LAZY,cascade = CascadeType.ALL)

    private Set<Reponse> reponses;

}
