package com.youcode.sunquizz.domains.Level.DTOs;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LevelReqDTO {
    private int id;
    @NotBlank(message = "Name cannot be blank")
    private String name;

    @Min(value = 0, message = "MinPoint must be a non-negative integer")
    private int minPoint;

    @Min(value = 0, message = "MaxPoint must be a non-negative integer")
    private int maxPoint;
}
