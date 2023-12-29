package com.youcode.sunquizz.domains.QuizzQuestion.DTOs;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class QuizzQuestionReq {
    private Integer id;
    @NotNull(message = "Duration cannot be null")
    @Positive(message = "Duration must be a positive number")
    private Integer duration;

    @NotNull(message = "Quizz ID cannot be null")
    @Positive(message = "Quizz ID must be a positive number")
    private Integer quizz_id;

    @NotNull(message = "Question ID cannot be null")
    @Positive(message = "Question ID must be a positive number")
    private Integer question_id;
}