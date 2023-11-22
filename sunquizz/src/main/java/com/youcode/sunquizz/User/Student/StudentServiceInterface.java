package com.youcode.sunquizz.User.Student;

import com.youcode.sunquizz.User.Student.DTOs.StudentReqDTO;
import com.youcode.sunquizz.User.Student.DTOs.StudentRespDTO;

import java.util.List;

public interface StudentServiceInterface {
    StudentRespDTO createStudent(StudentReqDTO teacher);
    Integer deleteStudent(Integer id);
    StudentRespDTO updateStudent(Integer id, StudentReqDTO teacher);
    List<StudentRespDTO> getAll();
    List<StudentRespDTO> searchByName(String name);
}
