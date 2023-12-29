package com.youcode.sunquizz.domains.Question.DTOs;


import com.youcode.sunquizz.domains.Question.Enums.QuestionType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class QuestionReqDTO {
    private Integer id;
    @NotBlank(message = "Text cannot be blank")
    private String text;

    @NotNull(message = "Type cannot be null")
    private QuestionType type;

    @NotNull(message = "Subject ID cannot be null")
    private Integer subject_id;

    @NotNull(message = "Level ID cannot be null")
    private Integer level_id;

    @NotNull(message = "Media ID cannot be null")
    private Integer media_id;
}
