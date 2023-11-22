package com.youcode.sunquizz.AssignQuizz.DTOs;

import com.youcode.sunquizz.Quizz.DTOs.QuizzReqDTO;
import com.youcode.sunquizz.User.Student.DTOs.StudentReqDTO;
import jakarta.annotation.Nullable;
import lombok.Data;

import java.time.LocalDate;
@Data
public class AssignQuizzRespDTO {
    private Integer id;
    private Integer chance;
    private LocalDate startDate;
    private LocalDate endDate;
    @Nullable
    private Integer score;
    @Nullable
    private boolean result;
    private QuizzReqDTO quizz;
    private StudentReqDTO student;
}
