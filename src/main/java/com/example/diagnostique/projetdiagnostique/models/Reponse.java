package com.example.diagnostique.projetdiagnostique.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Setter;

import java.io.Serializable;
@Entity
@Table
@Setter
public class Reponse implements Serializable {
    @EmbeddedId
    private ResKey resKey;

    @ManyToOne()
    @MapsId("ChoiceId")
    @JoinColumn(name = "Choice_id")
    private Choice choice;

    @ManyToOne()
    @MapsId("QuestId")
    @JoinColumn(name = "Quest_id")
    private Question question;
    @ManyToOne

    private User user;

    public void setUserId(Integer userId) {
        if (user == null) {
            user = new User();  // Initialisation si null
        }
        user.setId(userId);
    }

    public Choice getChoice() {
        return choice;
    }

    public Question getQuestion() {
        return question;
    }

    public User getUser() {
        return user;
    }

    public ResKey getResKey() {
        return resKey;
    }
}

