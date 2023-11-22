package com.youcode.sunquizz.Media.DTOs;

import com.youcode.sunquizz.Media.MediaType;
import com.youcode.sunquizz.Question.DTOs.QuestionReqDTO;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class MediaRespDTO {
    private int id;
    private String name;
    private String link;
    private MediaType type;
    private QuestionReqDTO question;
}
