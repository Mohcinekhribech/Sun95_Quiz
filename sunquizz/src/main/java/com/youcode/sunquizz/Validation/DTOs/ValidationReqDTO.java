package com.youcode.sunquizz.Validation.DTOs;

import lombok.Data;

@Data
public class ValidationReqDTO {
    private int id;
    private boolean correct;
    private int points;
    private int answer_id;
    private int question_id;
}
