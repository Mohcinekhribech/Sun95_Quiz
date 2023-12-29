package com.youcode.sunquizz.domains.Answer.DTOs;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class AnswerReqDTO {
    private int id;
    @NotBlank(message = "Answer text cannot be blank")
    @Size(min = 1, max = 255, message = "Answer text must be between 1 and 255 characters")
    private String text;
}
