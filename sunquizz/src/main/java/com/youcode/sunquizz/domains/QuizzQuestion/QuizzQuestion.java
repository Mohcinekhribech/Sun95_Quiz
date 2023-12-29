package com.youcode.sunquizz.domains.QuizzQuestion;

import com.youcode.sunquizz.domains.Question.Question;
import com.youcode.sunquizz.domains.Quizz.Quizz;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class QuizzQuestion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Nullable
    private Integer duration;
    @ManyToOne
    @JoinColumn(name = "quizz_id")
    private Quizz quizz;
    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;
}
