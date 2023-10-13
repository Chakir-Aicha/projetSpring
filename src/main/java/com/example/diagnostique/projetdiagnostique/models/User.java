package com.example.diagnostique.projetdiagnostique.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    @NonNull
    private String username;
    @NonNull
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false, name = "usertype")
    private String usertype;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)

    private List<Reponse> reponses;

    public User(int id, String username, String password, String email, String usertype) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.usertype = usertype;
    }
    @PrePersist
    public void prePersist() {
        // Vérifier si le nom contient un entier
        if (containsInteger(username)) {
            throw new IllegalArgumentException("Le nom d'utilisateur ne peut pas contenir de chiffres.");
        }if (username.length() < 4) {
            throw new IllegalArgumentException("Le nom d'utilisateur doit contenir au moins 4 caractères.");
        }if (username.isEmpty() || email.isEmpty()||password.isEmpty()) {
            throw new IllegalArgumentException("les informations incompletes.");
        }
    }

    private boolean containsInteger(String str) {
        try {
            Integer.parseInt(str);
            return true;  // Contient un entier
        } catch (NumberFormatException e) {
            return false;  // Ne contient pas d'entier
        }
    }
//    @ManyToOne
//    private  User user;


}

