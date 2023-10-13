package com.example.diagnostique.projetdiagnostique.models;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Embeddable

public class ResKey implements Serializable {
    @Column(name = "Choice_id")
    private Integer ChoiceId;
    @Column(name = "Quest_id")
    private Integer QuestId;

    public void setChoiceId(Integer choiceId) {
        this.ChoiceId=choiceId;
    }

    public void setQuestId(Integer questionId) {
        this.QuestId=questionId;
    }

    public Integer getChoiceId() {
        return  ChoiceId;
    }

    public Integer getQuestId() {
        return QuestId;
    }
}

