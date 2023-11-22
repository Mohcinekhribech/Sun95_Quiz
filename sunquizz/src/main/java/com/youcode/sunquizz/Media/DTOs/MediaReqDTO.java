package com.youcode.sunquizz.Media.DTOs;

import com.youcode.sunquizz.Media.MediaType;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class MediaReqDTO {
    private int id;
    @NotBlank(message = "the name require a non empty string")
    private String name;
    @NotBlank(message = "the link require a non empty string")
    private String link;
    @NotBlank(message = "the type require a non empty string")
    private MediaType type;
    @Min(value = 0, message = "invalid question id")
    @NotNull(message = "response require question id")
    private int question_id;
}