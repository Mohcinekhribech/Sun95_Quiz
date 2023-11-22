package com.youcode.sunquizz.Question;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonMerge;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.youcode.sunquizz.Answer.Answer;
import com.youcode.sunquizz.Level.Level;
import com.youcode.sunquizz.Media.Media;
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
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @OneToMany(mappedBy = "question", fetch = FetchType.LAZY)
    private List<Validation> validations;

    @JsonIgnore
    @OneToMany(mappedBy = "question", fetch = FetchType.LAZY)
    private List<QuizzQuestion> quizzQuestions;

    @ManyToOne
    @JoinColumn(name = "media_id",referencedColumnName = "id")
    private Media media;

}