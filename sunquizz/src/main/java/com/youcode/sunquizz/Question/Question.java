package com.youcode.sunquizz.Question;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonMerge;
import com.youcode.sunquizz.Level.Level;
import com.youcode.sunquizz.Question.Enums.QuestionType;
import com.youcode.sunquizz.Subject.Subject;
import jakarta.persistence.*;
import lombok.Data;

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
}