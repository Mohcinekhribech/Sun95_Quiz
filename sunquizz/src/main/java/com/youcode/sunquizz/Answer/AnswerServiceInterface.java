package com.youcode.sunquizz.Answer;

import com.youcode.sunquizz.Answer.DTOs.AnswerReqDTO;
import com.youcode.sunquizz.Answer.DTOs.AnswerRespDTO;

import java.util.List;

public interface AnswerServiceInterface {
    AnswerRespDTO getAnswer(Integer id);
    List<AnswerRespDTO> getAnswers();
    AnswerRespDTO createAnswer(AnswerReqDTO answer);
    AnswerRespDTO updateAnswer(AnswerReqDTO answer, Integer id);
    Integer deleteAnswer(Integer id);
}
