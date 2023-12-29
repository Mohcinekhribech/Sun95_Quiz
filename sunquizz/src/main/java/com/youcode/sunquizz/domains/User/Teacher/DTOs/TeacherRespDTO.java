package com.youcode.sunquizz.domains.User.Teacher.DTOs;

import com.youcode.sunquizz.domains.Quizz.DTOs.QuizzReqDTO;
import com.youcode.sunquizz.Security.User.DTOs.UserDTO;
import lombok.Data;

import java.util.List;

@Data
public class TeacherRespDTO extends UserDTO {
    private Integer id;
    private String Speciality;
    private List<QuizzReqDTO> quizzes;
}
