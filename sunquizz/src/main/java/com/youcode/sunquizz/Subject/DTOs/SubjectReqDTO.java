package com.youcode.sunquizz.Subject.DTOs;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class SubjectReqDTO {
    private int id;
    @NotBlank(message = "the title require a non empty string")
    private String title;
    private int parentSubject_id;
}