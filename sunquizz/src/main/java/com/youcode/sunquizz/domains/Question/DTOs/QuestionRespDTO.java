package com.youcode.sunquizz.domains.Question.DTOs;

import com.youcode.sunquizz.domains.Level.DTOs.LevelReqDTO;
import com.youcode.sunquizz.domains.Media.DTOs.MediaReqDTO;
import com.youcode.sunquizz.domains.Question.Enums.QuestionType;
import com.youcode.sunquizz.domains.Subject.DTOs.SubjectReqDTO;
import com.youcode.sunquizz.domains.Validation.DTOs.ValidationRespDTO;
import lombok.Data;

import java.util.List;

@Data
public class QuestionRespDTO {
    private Integer id;
    private String text;
    private QuestionType type;
    private SubjectReqDTO subject;
    private LevelReqDTO level;
    private MediaReqDTO media;
    private List<ValidationRespDTO> validations;
}
