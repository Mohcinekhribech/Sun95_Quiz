package com.youcode.sunquizz.domains.User.Student.DTOs;

import com.youcode.sunquizz.Security.User.DTOs.UserDTO;
import lombok.Data;

import java.time.LocalDate;

@Data
public class StudentRespDTO extends UserDTO {
    private Integer id;
    private LocalDate registrationDate;
}