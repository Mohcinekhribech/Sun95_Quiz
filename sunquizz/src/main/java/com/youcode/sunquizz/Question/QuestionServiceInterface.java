package com.youcode.sunquizz.Question;

import com.youcode.sunquizz.Level.Level;
import com.youcode.sunquizz.Question.DTOs.QuestionReqDTO;
import com.youcode.sunquizz.Question.DTOs.QuestionRespDTO;
import com.youcode.sunquizz.Subject.Subject;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public interface QuestionServiceInterface {
    QuestionRespDTO getQuestion(Integer id);
    List<QuestionRespDTO> getQuestionByLevel(Integer id);
     List<QuestionRespDTO> getQuestionBySubject(Integer id);
    List<QuestionRespDTO> getQuestions();
    QuestionRespDTO createQuestion(QuestionReqDTO question);
    QuestionRespDTO updateQuestion(QuestionReqDTO question,Integer id);
    Integer deleteQuestion(Integer id);
}
