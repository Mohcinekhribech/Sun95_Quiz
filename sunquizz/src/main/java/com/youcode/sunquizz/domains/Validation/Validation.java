package com.youcode.sunquizz.domains.Validation;

import com.youcode.sunquizz.domains.Answer.Answer;
import com.youcode.sunquizz.domains.AssignQuizz.AssignQuizz;
import com.youcode.sunquizz.domains.Question.Question;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

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
    @ManyToOne(fetch = FetchType.LAZY)
    private Question question;
    @ManyToMany(mappedBy = "validations")
    private List<AssignQuizz> assignQuizzes = new ArrayList<>();
}
