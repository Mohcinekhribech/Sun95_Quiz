package com.youcode.sunquizz.Validation;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.youcode.sunquizz.Answer.Answer;
import com.youcode.sunquizz.AssignQuizz.AssignQuizz;
import com.youcode.sunquizz.Question.Question;
import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class Validation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private boolean correct;
    private int points;
    @ManyToOne
    private Answer answer;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne(fetch = FetchType.LAZY)
    private Question question;
    @ManyToMany(mappedBy = "validations")
    private Set<AssignQuizz> assignQuizzes = new HashSet<>();
}
