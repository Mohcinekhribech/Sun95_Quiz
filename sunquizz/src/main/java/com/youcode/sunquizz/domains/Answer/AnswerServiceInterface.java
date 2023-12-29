package com.youcode.sunquizz.domains.Answer;

import com.youcode.sunquizz.domains.Answer.DTOs.AnswerReqDTO;
import com.youcode.sunquizz.domains.Answer.DTOs.AnswerRespDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AnswerServiceInterface {
    AnswerRespDTO getAnswer(Integer id);
    Page<AnswerRespDTO> getAnswers(Pageable pageable);
    AnswerRespDTO createAnswer(AnswerReqDTO answer);
    AnswerRespDTO updateAnswer(AnswerReqDTO answer, Integer id);
    Integer deleteAnswer(Integer id);
}
