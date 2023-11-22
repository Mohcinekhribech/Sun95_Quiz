package com.youcode.sunquizz.User.Teacher.DTOs;

import com.youcode.sunquizz.Question.DTOs.QuestionReqDTO;
import com.youcode.sunquizz.Quizz.DTOs.QuizzReqDTO;
import com.youcode.sunquizz.User.DTOs.UserDTO;
import lombok.Data;

import java.util.List;

@Data
public class TeacherRespDTO extends UserDTO {
    private Integer id;
    private String Speciality;
    private List<QuizzReqDTO> quizzes;
}
