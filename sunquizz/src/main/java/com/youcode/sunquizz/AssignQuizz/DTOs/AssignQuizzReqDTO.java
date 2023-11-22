package com.youcode.sunquizz.AssignQuizz.DTOs;

import jakarta.annotation.Nullable;
import lombok.Data;

import java.time.LocalDate;
@Data
public class AssignQuizzReqDTO {
    private Integer id;
    private Integer chance;
    private LocalDate startDate;
    private LocalDate endDate;
    @Nullable
    private Integer score;
    @Nullable
    private boolean result;
    private int quizz_id;
    private int student_id;
}
