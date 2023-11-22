package com.youcode.sunquizz.Validation.DTOs;

import com.youcode.sunquizz.Answer.DTOs.AnswerRespDTO;
import lombok.Data;

@Data
public class ValidationRespDTO {
    private int id;
    private boolean correct;
    private int points;
    private AnswerRespDTO answer;
}