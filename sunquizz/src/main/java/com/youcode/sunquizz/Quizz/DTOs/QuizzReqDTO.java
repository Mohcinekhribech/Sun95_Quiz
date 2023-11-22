package com.youcode.sunquizz.Quizz.DTOs;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.youcode.sunquizz.User.Teacher.Teacher;
import lombok.Data;

import java.time.LocalTime;
@Data
public class QuizzReqDTO {
    private Integer id;
    private Integer passScore;
    private Integer chances;
    private String comment;
    @JsonFormat(pattern = "HH:mm:ss")
    private LocalTime duration;
    private int teacher_id;
}