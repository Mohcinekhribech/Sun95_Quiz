package com.youcode.sunquizz.domains.Question;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.youcode.sunquizz.domains.Level.Level;
import com.youcode.sunquizz.domains.Media.Media;
import com.youcode.sunquizz.domains.Question.Enums.QuestionType;
import com.youcode.sunquizz.domains.QuizzQuestion.QuizzQuestion;
import com.youcode.sunquizz.domains.Subject.Subject;
import com.youcode.sunquizz.domains.Validation.Validation;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

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
    @OneToMany(mappedBy = "question", fetch = FetchType.LAZY,cascade = { CascadeType.MERGE, CascadeType.REMOVE })
    private List<Validation> validations;

    @JsonIgnore
    @OneToMany(mappedBy = "question", fetch = FetchType.LAZY)
    private List<QuizzQuestion> quizzQuestions;

    @ManyToOne
    @JoinColumn(name = "media_id",referencedColumnName = "id")
    private Media media;

}