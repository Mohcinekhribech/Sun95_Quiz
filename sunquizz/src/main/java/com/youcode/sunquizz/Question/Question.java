package com.youcode.sunquizz.Question;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonMerge;
import com.youcode.sunquizz.Answer.Answer;
import com.youcode.sunquizz.Level.Level;
import com.youcode.sunquizz.Question.Enums.QuestionType;
import com.youcode.sunquizz.QuizzQuestion.QuizzQuestion;
import com.youcode.sunquizz.Subject.Subject;
import com.youcode.sunquizz.Validation.Validation;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Entity
@Table
@Data
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String text;
    private QuestionType type;
    @ManyToOne
    @JoinColumn(name = "subject_id",referencedColumnName = "id")
    private Subject subject;
    @ManyToOne
    @JoinColumn(name = "level_id",referencedColumnName = "id")
    private Level level;
    @OneToMany(mappedBy = "question", fetch = FetchType.LAZY)
    private List<Validation> validations;
    @OneToMany(mappedBy = "question", fetch = FetchType.LAZY)
    private List<QuizzQuestion> quizzQuestions;

}