package com.youcode.sunquizz.User.Student.DTOs;

import com.youcode.sunquizz.User.DTOs.UserDTO;
import lombok.Data;

import java.time.LocalDate;
@Data
public class StudentReqDTO extends UserDTO {
    private Integer id;
    private LocalDate registrationDate;
}
