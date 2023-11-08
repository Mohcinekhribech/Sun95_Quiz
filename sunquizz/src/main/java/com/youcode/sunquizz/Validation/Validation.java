package com.youcode.sunquizz.Validation;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.youcode.sunquizz.Answer.Answer;
import com.youcode.sunquizz.AssignQuizz.AssignQuizz;
import com.youcode.sunquizz.Question.Question;
import com.youcode.sunquizz.StudentAnswer.StudentAnswer;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

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
    @OneToMany(mappedBy = "validation", fetch = FetchType.LAZY)
    private List<StudentAnswer> studentAnswers;
}
