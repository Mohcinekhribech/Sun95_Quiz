package com.youcode.sunquizz.domains.User.Student.DTOs;

import com.youcode.sunquizz.Security.User.DTOs.UserDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;
@EqualsAndHashCode(callSuper = true)
@Data
public class StudentReqDTO extends UserDTO {
    private Integer id;
    private LocalDate registrationDate;
}
