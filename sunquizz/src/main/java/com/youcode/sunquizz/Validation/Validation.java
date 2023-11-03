package com.youcode.sunquizz.Validation;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.youcode.sunquizz.Answer.Answer;
import com.youcode.sunquizz.Question.Question;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Validation {
    @Id
    private int id;
    private boolean correct;
    private int points;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "answer_id")
    private Answer answer;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id")
    private Question question;
}
