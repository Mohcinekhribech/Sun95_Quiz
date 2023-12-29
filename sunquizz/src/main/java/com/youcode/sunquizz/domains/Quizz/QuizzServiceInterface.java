package com.youcode.sunquizz.domains.Quizz;

import com.youcode.sunquizz.domains.Quizz.DTOs.QuizzReqDTO;
import com.youcode.sunquizz.domains.Quizz.DTOs.QuizzRespDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface QuizzServiceInterface {
    QuizzRespDTO createQuizz(QuizzReqDTO quizz);
    Integer deleteQuizz(Integer id);
    QuizzRespDTO updateQuizz(Integer id, QuizzReqDTO quizz);
    Page<QuizzRespDTO> getAll(Pageable pageable);
    List<QuizzRespDTO> getAllByTeacher(Integer id);
    QuizzRespDTO getQuizz(Integer id);
}
