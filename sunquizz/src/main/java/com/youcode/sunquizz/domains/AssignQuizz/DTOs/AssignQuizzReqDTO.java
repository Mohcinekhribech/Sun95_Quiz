package com.youcode.sunquizz.domains.AssignQuizz.DTOs;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

import java.time.LocalDate;
    @Data
    public class AssignQuizzReqDTO {
        private Integer id;

        @PositiveOrZero(message = "Chance must be a non-negative number")
        private Integer chance;

        @NotNull(message = "Start date cannot be null")
        private LocalDate startDate;

        @NotNull(message = "End date cannot be null")
        private LocalDate endDate;

        @Nullable
        @PositiveOrZero(message = "Score must be a non-negative number")
        private Integer score;

        @Nullable
        private Boolean result;

        @Positive(message = "Quizz ID must be a positive number")
        private int quizz_id;

        @Positive(message = "Student ID must be a positive number")
        private int student_id;
    }
