package com.youcode.sunquizz.domains.Media.DTOs;

import com.youcode.sunquizz.domains.Media.MediaType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class MediaReqDTO {
    private int id;
    @NotBlank(message = "Description cannot be blank")
    private String description;

    @NotBlank(message = "Link cannot be blank")
    @Pattern(regexp = "^(https?|ftp)://.*$", message = "Link must be a valid URL")
    private String link;

    @NotNull(message = "Type cannot be null")
    private MediaType type;
}