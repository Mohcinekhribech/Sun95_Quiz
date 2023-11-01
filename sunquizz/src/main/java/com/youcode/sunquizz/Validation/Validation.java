package com.youcode.sunquizz.Validation;

import com.youcode.sunquizz.Answer.Answer;
import com.youcode.sunquizz.Question.Question;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Embeddable
@Data
public class Validation {
    private float point;
    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;

    @ManyToOne
    @JoinColumn(name = "answer_id")
    private Answer answer;
}
