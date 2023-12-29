package com.youcode.sunquizz.domains.QuizzQuestion.DTOs;

import com.youcode.sunquizz.domains.Question.DTOs.QuestionRespDTO;
import lombok.Data;

@Data
public class QuizzQuestionResp {
    private Integer id;
    private Integer duration;
    private QuestionRespDTO question;
}
