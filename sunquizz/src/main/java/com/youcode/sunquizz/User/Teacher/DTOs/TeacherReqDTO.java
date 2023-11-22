package com.youcode.sunquizz.User.Teacher.DTOs;

import com.youcode.sunquizz.User.DTOs.UserDTO;
import lombok.Data;

@Data
public class TeacherReqDTO extends UserDTO {
    private Integer id;
    private String Speciality;
}
