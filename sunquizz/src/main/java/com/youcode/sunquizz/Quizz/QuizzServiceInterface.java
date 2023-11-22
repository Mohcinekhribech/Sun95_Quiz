package com.youcode.sunquizz.Quizz;

import com.youcode.sunquizz.Quizz.DTOs.QuizzReqDTO;
import com.youcode.sunquizz.Quizz.DTOs.QuizzRespDTO;

import java.util.List;

public interface QuizzServiceInterface {
    QuizzRespDTO createQuizz(QuizzReqDTO quizz);
    Integer deleteQuizz(Integer id);
    QuizzRespDTO updateQuizz(Integer id, QuizzReqDTO quizz);
    List<QuizzRespDTO> getAll();
    List<QuizzRespDTO> getAllByTeacher(Integer id);
}
