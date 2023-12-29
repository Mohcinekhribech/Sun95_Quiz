package com.youcode.sunquizz.domains.Validation.DTOs;

import com.youcode.sunquizz.domains.Answer.DTOs.AnswerReqDTO;
import lombok.Data;

@Data
public class ValidationRespDTO {
    private int id;
    private boolean correct;
    private int points;
    private AnswerReqDTO answer;
}