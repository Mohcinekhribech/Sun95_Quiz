package com.youcode.sunquizz.domains.Question;

import com.youcode.sunquizz.domains.Question.DTOs.QuestionReqDTO;
import com.youcode.sunquizz.domains.Question.DTOs.QuestionRespDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface QuestionServiceInterface {
    QuestionRespDTO getQuestion(Integer id);
    List<QuestionRespDTO> getQuestionByLevel(Integer id);
    List<QuestionRespDTO> getQuestionBySubject(Integer id);
    Page<QuestionRespDTO> getQuestions(Pageable pageable);
    QuestionRespDTO createQuestion(QuestionReqDTO question);
    QuestionRespDTO updateQuestion(QuestionReqDTO question,Integer id);
    Integer deleteQuestion(Integer id);
}
