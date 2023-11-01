package com.youcode.sunquizz.Question;

import com.youcode.sunquizz.Level.Level;
import com.youcode.sunquizz.Question.Enums.QuestionType;
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
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "level_id",referencedColumnName = "id")
    private Level level;
}
