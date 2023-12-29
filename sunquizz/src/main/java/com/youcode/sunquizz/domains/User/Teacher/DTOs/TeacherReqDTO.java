package com.youcode.sunquizz.domains.User.Teacher.DTOs;

import com.youcode.sunquizz.Security.User.DTOs.UserDTO;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class TeacherReqDTO extends UserDTO {
    private Integer id;
    @NotBlank(message = "Speciality cannot be blank")
    @Size(max = 255, message = "Last name must not exceed 255 characters")
    private String Speciality;
}
