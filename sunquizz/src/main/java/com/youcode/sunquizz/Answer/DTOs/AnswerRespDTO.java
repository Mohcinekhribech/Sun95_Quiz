package com.youcode.sunquizz.Answer.DTOs;

import com.youcode.sunquizz.Validation.DTOs.ValidationReqDTO;
import lombok.Data;

import java.util.List;

@Data
public class AnswerRespDTO {
    private int id;
    private String text;
    private List<ValidationReqDTO> validations;
}
