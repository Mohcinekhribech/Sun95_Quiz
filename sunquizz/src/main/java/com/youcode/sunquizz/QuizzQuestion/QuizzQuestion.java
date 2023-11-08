package com.youcode.sunquizz.QuizzQuestion;

import com.youcode.sunquizz.Question.Question;
import com.youcode.sunquizz.Quizz.Quizz;
import jakarta.annotation.Nullable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class QuizzQuestion {
    @Id
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
