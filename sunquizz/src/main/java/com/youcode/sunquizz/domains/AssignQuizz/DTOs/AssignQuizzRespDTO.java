package com.youcode.sunquizz.domains.AssignQuizz.DTOs;

import com.youcode.sunquizz.domains.Quizz.DTOs.QuizzReqDTO;
import com.youcode.sunquizz.domains.User.Student.DTOs.StudentReqDTO;
import com.youcode.sunquizz.domains.Validation.DTOs.ValidationRespDTO;
import jakarta.annotation.Nullable;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
    private List<ValidationRespDTO> validations = new ArrayList<>();
}
