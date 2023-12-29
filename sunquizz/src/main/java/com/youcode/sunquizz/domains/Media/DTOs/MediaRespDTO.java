package com.youcode.sunquizz.domains.Media.DTOs;

import com.youcode.sunquizz.domains.Media.MediaType;
import com.youcode.sunquizz.domains.Question.DTOs.QuestionReqDTO;
import lombok.Data;

import java.util.List;

@Data
public class MediaRespDTO {
    private int id;
    private String description;
    private String link;
    private MediaType type;
    private List<QuestionReqDTO> questions;
}
