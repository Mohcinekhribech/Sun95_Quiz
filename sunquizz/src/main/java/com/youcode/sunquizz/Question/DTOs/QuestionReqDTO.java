package com.youcode.sunquizz.Question.DTOs;


import com.youcode.sunquizz.Question.Enums.QuestionType;
import lombok.Data;

@Data
public class QuestionReqDTO {
    private Integer id;
    private String text;
    private QuestionType type;
    private int subject_id;
    private int level_id;
    private int media_id;
}
