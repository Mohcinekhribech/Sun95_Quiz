package com.youcode.sunquizz.domains.Answer.DTOs;

import com.youcode.sunquizz.domains.Validation.DTOs.ValidationReqDTO;
import lombok.Data;

import java.util.List;

@Data
public class AnswerRespDTO {
    private int id;
    private String text;
    private List<ValidationReqDTO> validations;
}
