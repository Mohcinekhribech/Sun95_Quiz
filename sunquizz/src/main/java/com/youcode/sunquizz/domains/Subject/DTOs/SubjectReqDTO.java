package com.youcode.sunquizz.domains.Subject.DTOs;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class SubjectReqDTO {
    private int id;
    @NotBlank(message = "Title cannot be blank.")
    private String title;

    @Positive(message = "ParentSubject ID must be a positive integer.")
    private int parentSubject_id;
}