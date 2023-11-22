package com.youcode.sunquizz.Question.DTOs;

import com.youcode.sunquizz.Question.Enums.QuestionType;
import com.youcode.sunquizz.Validation.DTOs.ValidationReqDTO;
import com.youcode.sunquizz.Validation.Validation;
import lombok.Data;

import java.util.List;

@Data
public class QuestionRespDTO {
    private Integer id;
    private String text;
    private QuestionType type;
    private int subject_id;
    private int level_id;
    private List<ValidationReqDTO> validations;
}
