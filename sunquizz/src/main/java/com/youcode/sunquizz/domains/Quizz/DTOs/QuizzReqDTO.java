package com.youcode.sunquizz.domains.Quizz.DTOs;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalTime;
@Data
public class QuizzReqDTO {
    private Integer id;
    @NotNull(message = "Pass score is required")
    @Min(value = 0, message = "Pass score must be a positive integer")
    private Integer passScore;

    @NotNull(message = "Chances are required")
    @Min(value = 1, message = "Chances must be at least 1")
    private Integer chances;

    @NotBlank(message = "Comment cannot be blank")
    private String comment;

    @JsonFormat(pattern = "HH:mm:ss")
    @NotNull(message = "Duration is required")
    private LocalTime duration;

    @Min(value = 1, message = "Teacher ID must be a positive integer")
    private int teacher_id;
}