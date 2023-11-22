package com.youcode.sunquizz.Level.DTOs;

import com.youcode.sunquizz.Question.DTOs.QuestionReqDTO;
import com.youcode.sunquizz.Question.Question;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class LevelRespDTO {
    private int id;
    private String name;
    private int maxPoint;
    private int minPoint;
    private Set<QuestionReqDTO> questions = new HashSet<>();
}
