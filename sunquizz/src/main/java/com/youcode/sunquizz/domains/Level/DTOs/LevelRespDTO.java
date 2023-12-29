package com.youcode.sunquizz.domains.Level.DTOs;

import com.youcode.sunquizz.domains.Question.DTOs.QuestionReqDTO;
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
