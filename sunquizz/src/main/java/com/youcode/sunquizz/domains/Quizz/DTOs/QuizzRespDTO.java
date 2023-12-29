package com.youcode.sunquizz.domains.Quizz.DTOs;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.youcode.sunquizz.domains.QuizzQuestion.DTOs.QuizzQuestionResp;
import com.youcode.sunquizz.domains.User.Teacher.DTOs.TeacherReqDTO;
import lombok.Data;

import java.time.LocalTime;
import java.util.List;

@Data
public class QuizzRespDTO {
    private Integer id;
    private Integer passScore;
    private Integer chances;
    private String comment;
    @JsonFormat(pattern = "HH:mm:ss")
    private LocalTime duration;
    private TeacherReqDTO teacher;
    private List<QuizzQuestionResp> quizzQuestions;
}
